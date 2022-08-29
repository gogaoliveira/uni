package com.unifica.documentos;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unifica.documentos.entity.Company;
import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.Request;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.documents.Cpf;
import com.unifica.documentos.entity.documents.TituloEleitor;
import com.unifica.documentos.entity.enums.StateRequest;
import com.unifica.documentos.entity.enums.TypeDocument;
import com.unifica.documentos.repositories.CompanyRepositories;
import com.unifica.documentos.repositories.DocumentRepositories;
import com.unifica.documentos.repositories.RequestRepositories;
import com.unifica.documentos.repositories.UserRepositories;

@SpringBootApplication
public class UniApplication implements CommandLineRunner {

	@Autowired
	private UserRepositories userRepositories;
	@Autowired
	private CompanyRepositories companyRepositories;
	@Autowired
	private DocumentRepositories documentRepositories;
	@Autowired
	private RequestRepositories requestRepositories;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(UniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		User u1 = new User(null, "Douglas", "photo/douglas", "12345678909", "douglas@email.com", encoder.encode("123"));
		User u2 = new User(null, "Flavia", "photo/flavia", "12345678909", "flavia@email.com", encoder.encode("321"));
		User u3 = new User(null, "Eric", "photo/eric", "12345678909", "eric@email.com", "2020");

		userRepositories.saveAll(Arrays.asList(u1, u2, u3));

		Company c1 = new Company(null, "Empresa01", "11.111.111/0001-91", "photo/empresa01", "empresa01@empresa01.com");
		Company c2 = new Company(null, "Empresa02", "22.222.222/0001-92", "photo/empresa02", "empresa02@empresa02.com");

		companyRepositories.saveAll(Arrays.asList(c1, c2));
		
		Document d1 = new Cpf(null, TypeDocument.CPF, "111.111.111-11", "photo/cpf", u1, sdf.parse("01/01/1991"));
		Document d2 = new Cpf(null, TypeDocument.CPF, "222.222.22", "photo/cnh", u2, sdf.parse("01/01/1992"));
		Document d3 = new TituloEleitor(null, TypeDocument.TITULO_ELEITOR, "19991199119", "photo/tituloeleitor", u1,  sdf.parse("23/09/1991"),  sdf.parse("23/09/2007"), "001", "049", "Criciuma");
		
		documentRepositories.saveAll(Arrays.asList(d1, d2, d3));
				
		Request r1 = new Request(null, sdf.parse("01/01/1999"), StateRequest.AWAIT, u1, c1);
		Request r2 = new Request(null, sdf.parse("09/09/2020"), StateRequest.AWAIT, u2, c2);
		
		requestRepositories.saveAll(Arrays.asList(r1, r2));
	}
}

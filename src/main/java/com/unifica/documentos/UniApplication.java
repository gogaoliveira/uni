package com.unifica.documentos;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unifica.documentos.entity.Company;
import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.Request;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.StateRequest;
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

	public static void main(String[] args) {
		SpringApplication.run(UniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Douglas", "photo/douglas", "douglas@email.com", "123");
		User u2 = new User(null, "Flavia", "photo/flavia", "flavia@email.com", "321");
		User u3 = new User(null, "Eric", "photo/eric", "eric@email.com", "2020");

		userRepositories.saveAll(Arrays.asList(u1, u2, u3));

		Company c1 = new Company(null, "Empresa01", "11.111.111/0001-91", "photo/empresa01", "empresa01@empresa01.com");
		Company c2 = new Company(null, "Empresa02", "22.222.222/0001-92", "photo/empresa02", "empresa02@empresa02.com");

		companyRepositories.saveAll(Arrays.asList(c1, c2));
		
		Document d1 = new Document(null, "CPF", "111.111.111-11", "photo/cpf", u1);
		Document d2 = new Document(null, "CNH", "222.222.22", "photo/cnh", u2);
		
		documentRepositories.saveAll(Arrays.asList(d1, d2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		Request r1 = new Request(null, sdf.parse("01/01/1999"), StateRequest.AWAIT, u1, c1);
		Request r2 = new Request(null, sdf.parse("09/09/2020"), StateRequest.AWAIT, u2, c2);
		
		requestRepositories.saveAll(Arrays.asList(r1, r2));
	}
}

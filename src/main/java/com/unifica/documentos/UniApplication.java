package com.unifica.documentos;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.Request;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.documents.CarteiraMotorista;
import com.unifica.documentos.entity.documents.CarteiraTrabalho;
import com.unifica.documentos.entity.documents.CertidaoCasamento;
import com.unifica.documentos.entity.documents.CertidaoNascimento;
import com.unifica.documentos.entity.documents.Cpf;
import com.unifica.documentos.entity.documents.Endereco;
import com.unifica.documentos.entity.documents.Outros;
import com.unifica.documentos.entity.documents.Rg;
import com.unifica.documentos.entity.documents.TituloEleitor;
import com.unifica.documentos.entity.enums.StateRequest;
import com.unifica.documentos.entity.enums.TypeDocument;
import com.unifica.documentos.repositories.DocumentRepositories;
import com.unifica.documentos.repositories.RequestRepositories;
import com.unifica.documentos.repositories.UserRepositories;

@SpringBootApplication
public class UniApplication implements CommandLineRunner {

	@Autowired
	private UserRepositories userRepositories;
	
	@Autowired
	private DocumentRepositories documentRepositories;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private RequestRepositories requestRepositories;

	public static void main(String[] args) {
		SpringApplication.run(UniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		Set<Integer> userProfile = new HashSet<>();
		userProfile.add(2);

		Set<Integer> companyProfile = new HashSet<>();
		companyProfile.add(1);

		User u1 = new User(null, "Douglas", "photo/douglas", "12345678909", "douglas@email.com", encoder.encode("123"),
				userProfile);
		User u2 = new User(null, "Flavia", "photo/flavia", "12345678909", "flavia@email.com", encoder.encode("321"),
				userProfile);
		User u3 = new User(null, "Eric", "photo/eric", "12345678909", "eric@email.com", encoder.encode("321"),
				userProfile);
		User c1 = new User(null, "Empresa01", "photo/emp1", "12.123.122/0001-91", "emp1@email.com",
				encoder.encode("123"), companyProfile);
		User c2 = new User(null, "Empresa02", "photo/emp1", "95.007.654/0001-91", "emp2@email.com",
				encoder.encode("123"), companyProfile);

		userRepositories.saveAll(Arrays.asList(u1, u2, u3, c1, c2));

		Document d1 = new CarteiraMotorista(null, TypeDocument.CARTEIRA_MOTORISTA, "32165432", u1, "N",
				sdf.parse("01/01/2025"), sdf.parse("01/01/2020"), "AB", "#####", "#####", "sem observações");
		Document d2 = new CarteiraTrabalho(null, TypeDocument.CARTEIRA_TRABALHO, "1234", u1, "N", "12345678912", "E", "SC");
		Document d3 = new CertidaoCasamento(null, TypeDocument.CERTIDAO_CASAMENTO, "133", u1, "N", "Flavia Acosta",
				"11122233345", sdf.parse("09/02/1994"), "Porto Alegre", "Marcos da Silva", "Luciane Acosta",
				sdf.parse("01/01/2020"), "A", "sem observações");
		Document d4 = new CertidaoNascimento(null, TypeDocument.CERTIDAO_NASCIMENTO, "321654", u1, "N", "Titular",
				"12345678909", sdf.parse("01/01/2020"), "Ararangua", "Ararangua", "Hospital Regional", "M",
				"Antonio Oliveira e Silvia de Souza", "Maria Leopoldo e Avelino Leopoldo",
				"Maria minervina e Lorival Gomes", "sem observações", "123");
		Document d5 = new Cpf(null, TypeDocument.CPF, "111.111.111-11", u1, "N", sdf.parse("01/01/1991"));
		Document d6 = new Endereco(null, TypeDocument.ENDERECO, "123", u1, "N", "Estrada Geral", "Apto 101 Bloco B",
				"88900555", "122", "Ararangua", "SC");
		Document d7 = new Outros(null, TypeDocument.OUTROS, "123465", u1, "N", "Carteira de vacinação",
				"Dados seguem na foto");
		Document d8 = new Rg(null, TypeDocument.RG, "12346578", u1, "N", sdf.parse("01/01/2020"), sdf.parse("01/01/2000"),
				"Ararangua", "Silvia de Souza Gomes", "Antonio Leopoldo de Oliveira", "SSP/SC");
		Document d9 = new TituloEleitor(null, TypeDocument.TITULO_ELEITOR, "19991199119", u1, "N", sdf.parse("23/09/1991"),
				sdf.parse("23/09/2007"), "001", "049", "Criciuma");

		documentRepositories.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
		
		Request r1 = new Request(null, sdf.parse("09/10/2022"), StateRequest.AWAIT, u1, c1);
		Request r2 = new Request(null, sdf.parse("13/08/2018"), StateRequest.AWAIT, u1, c2);
		Request r3 = new Request(null, sdf.parse("21/07/2015"), StateRequest.REFUSED, u1, c2);
		Request r4 = new Request(null, sdf.parse("21/07/2015"), StateRequest.REFUSED, u1, c2);
		Request r5 = new Request(null, sdf.parse("21/07/2015"), StateRequest.REFUSED, u1, c2);
		Request r6 = new Request(null, sdf.parse("21/07/2015"), StateRequest.REFUSED, u1, c2);
		Request r7 = new Request(null, sdf.parse("11/06/2019"), StateRequest.APPROVED, u1, c2);
		Request r8 = new Request(null, sdf.parse("11/06/2019"), StateRequest.APPROVED, u1, c2);
		Request r9 = new Request(null, sdf.parse("11/06/2019"), StateRequest.APPROVED, u1, c2);
		Request r10 = new Request(null, sdf.parse("11/06/2019"), StateRequest.APPROVED, u1, c2);
		Request r11 = new Request(null, sdf.parse("11/06/2019"), StateRequest.APPROVED, u1, c2);
		requestRepositories.saveAll(Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11));

	}
}

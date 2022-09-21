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
		
		Document d1 = new CarteiraMotorista(null, TypeDocument.CARTEIRA_MOTORISTA, "32165432", "photocarteira.jpg", u1, sdf.parse("01/01/2025"), sdf.parse("01/01/2020"), "AB", "#####", "#####");
		Document d2 = new CarteiraTrabalho(null, TypeDocument.CARTEIRA_TRABALHO, "1234", "photocarteiratrabalho.jps", u1, "12345678912", "E", "SC");
		Document d3 = new CertidaoCasamento(null, TypeDocument.CERTIDAO_CASAMENTO, "133", "certidaocasamento.jpg", u1, "Flavia Acosta", "11122233345", sdf.parse("09/02/1994"), "Porto Alegre", "Marcos da Silva", "Luciane Acosta", sdf.parse("01/01/2020"), "Comunhão parcial de bens", "sem observações");
		Document d4 = new CertidaoNascimento(null, TypeDocument.CERTIDAO_NASCIMENTO, "321654", "certid.jpg", u1, "Titular", "12345678909", sdf.parse("01/01/2020"), "Ararangua", "Ararangua", "Hospital Regional", "M", "Antonio Oliveira e Silvia de Souza", "Maria Leopoldo e Avelino Leopoldo", "Maria minervina e Lorival Gomes", "sem observações", "123");
		Document d5 = new Cpf(null, TypeDocument.CPF, "111.111.111-11", "photo/cpf", u1, sdf.parse("01/01/1991"));
		Document d6 = new Endereco(null, TypeDocument.ENDERECO, "123", "compronte.jpg", u1, "Estrada Geral", "Apto 101 Bloco B", "88900555", "122", "Ararangua", "SC");
		Document d7 = new Outros(null, TypeDocument.OUTROS, "123465", "outros.jpg", u1, "Carteira de vacinação", "Dados seguem na foto");
		Document d8 = new Rg(null, TypeDocument.RG, "12346578", "rg.jpg", u1, sdf.parse("01/01/2020"), sdf.parse("01/01/2000"), "Ararangua", "Silvia de Souza Gomes", "Antonio Leopoldo de Oliveira", "SSP/SC");
		Document d9 = new TituloEleitor(null, TypeDocument.TITULO_ELEITOR, "19991199119", "photo/tituloeleitor", u1,  sdf.parse("23/09/1991"),  sdf.parse("23/09/2007"), "001", "049", "Criciuma");
		
		Document d20 = new Cpf(null, TypeDocument.CPF, "222.222.222-22", "photo/cnh", u2, sdf.parse("01/01/1992"));
		
		
		documentRepositories.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
				
		Request r1 = new Request(null, sdf.parse("01/01/1999"), StateRequest.AWAIT, u1, c1);
		Request r2 = new Request(null, sdf.parse("09/09/2020"), StateRequest.AWAIT, u2, c2);
		
		requestRepositories.saveAll(Arrays.asList(r1, r2));
	}
}

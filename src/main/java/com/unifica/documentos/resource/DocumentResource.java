package com.unifica.documentos.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unifica.documentos.dto.CarteiraMotoristaDTO;
import com.unifica.documentos.dto.CarteiraTrabalhoDTO;
import com.unifica.documentos.dto.CertidaoCasamentoDTO;
import com.unifica.documentos.dto.CertidaoNascimentoDTO;
import com.unifica.documentos.dto.CpfDTO;
import com.unifica.documentos.dto.EnderecoDTO;
import com.unifica.documentos.dto.OutrosDTO;
import com.unifica.documentos.dto.RgDTO;
import com.unifica.documentos.dto.TituloEleitorDTO;
import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.documents.CarteiraMotorista;
import com.unifica.documentos.entity.documents.CarteiraTrabalho;
import com.unifica.documentos.entity.documents.CertidaoCasamento;
import com.unifica.documentos.entity.documents.CertidaoNascimento;
import com.unifica.documentos.entity.documents.Cpf;
import com.unifica.documentos.entity.documents.Endereco;
import com.unifica.documentos.entity.documents.Outros;
import com.unifica.documentos.entity.documents.Rg;
import com.unifica.documentos.entity.documents.TituloEleitor;
import com.unifica.documentos.services.DocumentService;

@RestController
@RequestMapping(value = "/documentos")
public class DocumentResource {

	@Autowired
	private DocumentService docserv;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Document obj = docserv.find(id);
		return ResponseEntity.ok().body(obj);
	}

	// ==========>CPF<==========

	@PostMapping(value = "cpf")
	public ResponseEntity<Void> insert(@RequestBody CpfDTO obj) {
		Cpf newObj = docserv.cpfDtoFromCpf(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "cpf/{id}")
	public ResponseEntity<Void> update(@RequestBody CpfDTO obj, @PathVariable Integer id) {
		Cpf attObj = docserv.cpfDtoFromCpf(obj);
		attObj.setId(id);
		attObj = docserv.update(attObj);
		return ResponseEntity.noContent().build();
	}

	// ==========>Motorista<==========

	@PostMapping(value = "Motorista")
	public ResponseEntity<Void> insert(@RequestBody CarteiraMotoristaDTO obj) {
		CarteiraMotorista newObj = docserv.MotoristaDtoFromMotorista(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "Motorista/{id}")
	public ResponseEntity<Void> update(@RequestBody CarteiraMotoristaDTO obj, @PathVariable Integer id) {
		CarteiraMotorista attObj = docserv.MotoristaDtoFromMotorista(obj);
		attObj.setId(id);
		attObj = docserv.update(attObj);
		return ResponseEntity.noContent().build();
	}

	// ==========>Carteira de Trabalho<==========

	@PostMapping(value = "trabalho")
	public ResponseEntity<Void> insert(@RequestBody CarteiraTrabalhoDTO obj) {
		CarteiraTrabalho newObj = docserv.TrabalhoDtoFromTrabalho(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "trabalho/{id}")
	public ResponseEntity<Void> update(@RequestBody CarteiraTrabalhoDTO obj, @PathVariable Integer id) {
		CarteiraTrabalho attObj = docserv.TrabalhoDtoFromTrabalho(obj);
		attObj.setId(id);
		attObj = docserv.update(attObj);
		return ResponseEntity.noContent().build();
	}

	// ==========>Certidao de Casamento<==========

	@PostMapping(value = "casamento")
	public ResponseEntity<Void> insert(@RequestBody CertidaoCasamentoDTO obj) {
		CertidaoCasamento newObj = docserv.CasamentoDtoFromCasamento(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "casamento/{id}")
	public ResponseEntity<Void> update(@RequestBody CertidaoCasamentoDTO obj, @PathVariable Integer id) {
		CertidaoCasamento attObj = docserv.CasamentoDtoFromCasamento(obj);
		attObj.setId(id);
		attObj = docserv.update(attObj);
		return ResponseEntity.noContent().build();
	}

	// ==========>Certidao de Nascimento<==========

	@PostMapping(value = "nascimento")
	public ResponseEntity<Void> insert(@RequestBody CertidaoNascimentoDTO obj) {
		CertidaoNascimento newObj = docserv.NascimentoDtoFromNascimento(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "nascimento/{id}")
	public ResponseEntity<Void> update(@RequestBody CertidaoNascimentoDTO obj, @PathVariable Integer id) {
		CertidaoNascimento attObj = docserv.NascimentoDtoFromNascimento(obj);
		attObj.setId(id);
		attObj = docserv.update(attObj);
		return ResponseEntity.noContent().build();
	}

	// ==========>Endereco<==========

	@PostMapping(value = "endereco")
	public ResponseEntity<Void> insert(@RequestBody EnderecoDTO obj) {
		Endereco newObj = docserv.enderecoDtoFromEndereco(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "endereco/{id}")
	public ResponseEntity<Void> update(@RequestBody EnderecoDTO obj, @PathVariable Integer id) {
		Endereco attObj = docserv.enderecoDtoFromEndereco(obj);
		attObj.setId(id);
		attObj = docserv.update(attObj);
		return ResponseEntity.noContent().build();
	}

	// ==========>OUTROs<==========

	@PostMapping(value = "outros")
	public ResponseEntity<Void> insert(@RequestBody OutrosDTO obj) {
		Outros newObj = docserv.outrosDtoFromOutros(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "outros/{id}")
	public ResponseEntity<Void> update(@RequestBody OutrosDTO obj, @PathVariable Integer id) {
		Outros attObj = docserv.outrosDtoFromOutros(obj);
		attObj.setId(id);
		attObj = docserv.update(attObj);
		return ResponseEntity.noContent().build();
	}

	// ==========>RG<==========

	@PostMapping(value = "rg")
	public ResponseEntity<Void> insert(@RequestBody RgDTO obj) {
		Rg newObj = docserv.rgDtoFromRg(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "rg/{id}")
	public ResponseEntity<Void> update(@RequestBody RgDTO obj, @PathVariable Integer id) {
		Rg attObj = docserv.rgDtoFromRg(obj);
		attObj.setId(id);
		attObj = docserv.update(attObj);
		return ResponseEntity.noContent().build();
	}

	// ==========>Titulo Eleitor<==========

	@PostMapping(value = "eleitor")
	public ResponseEntity<Void> insert(@RequestBody TituloEleitorDTO obj) {
		TituloEleitor newObj = docserv.eleitorDtoFromEleitor(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "eleitor/{id}")
	public ResponseEntity<Void> update(@RequestBody TituloEleitorDTO obj, @PathVariable Integer id) {
		TituloEleitor attObj = docserv.eleitorDtoFromEleitor(obj);
		attObj.setId(id);
		attObj = docserv.update(attObj);
		return ResponseEntity.noContent().build();
	}
	
	

}

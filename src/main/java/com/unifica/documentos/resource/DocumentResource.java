package com.unifica.documentos.resource;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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

	@Autowired
	private HttpServletResponse responseServ;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Document obj = docserv.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDoc(@PathVariable Integer id) throws IOException {
		String path1 = docserv.find(id).getPhoto1();
		String path2 = docserv.find(id).getPhoto2();
		Files.delete(Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + path1));
		Files.delete(Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + path2));
		docserv.deleteDocument(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping(value = "cpf")
	public ResponseEntity<Void> insert(@RequestBody CpfDTO obj) {
		Cpf newObj = docserv.cpfDtoFromCpf(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		responseServ.setHeader("access-control-expose-headers", "*");
		responseServ.setHeader("idDocument", newObj.getId().toString());
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "cpf/img/{id}")
	public ResponseEntity<Void> insertPhotoCpf(@PathVariable Integer id, @RequestParam(required = false) MultipartFile photo1, @RequestParam(required = false) MultipartFile photo2){
		Cpf newObj = (Cpf) docserv.find(id);
		try {
			if (photo1 != null) {
				if (!photo1.isEmpty()) {
					byte[] bytes1 = photo1.getBytes();
					Path path1 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\"
							+ newObj.getId() + "f" + photo1.getOriginalFilename());
					Files.write(path1, bytes1);
					newObj.setPhoto1(String.valueOf(newObj.getId() + "f" + photo1.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
			if (photo2 != null) {
				if (!photo2.isEmpty()) {
					byte[] bytes2 = photo2.getBytes();
					Path path2 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\"
							+ newObj.getId() + "v" + photo2.getOriginalFilename());
					Files.write(path2, bytes2);
					newObj.setPhoto2(String.valueOf(newObj.getId() + "v" + photo2.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "cpf/{id}")
	public ResponseEntity<Void> update(@RequestBody CpfDTO obj, @PathVariable Integer id) {
		Cpf cpf = new Cpf();
		cpf = (Cpf) docserv.find(id);
		cpf.setNumberDocument(obj.getNumberDocument() == null ? cpf.getNumberDocument() : obj.getNumberDocument());
		cpf.setDataNascimento(obj.getDataNascimento() == null ? cpf.getDataNascimento() : obj.getDataNascimento());
		cpf.setPrivateDocument(obj.getPrivateDocument() == null ? cpf.getPrivateDocument() : obj.getPrivateDocument());
		cpf = docserv.update(cpf);
		return ResponseEntity.noContent().build();
	}

	// ==========>Motorista<==========

	@PostMapping(value = "motorista")
	public ResponseEntity<Void> insert(@RequestBody CarteiraMotoristaDTO obj) {
		CarteiraMotorista newObj = docserv.MotoristaDtoFromMotorista(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		responseServ.setHeader("access-control-expose-headers", "*");
		responseServ.setHeader("idDocument", newObj.getId().toString());
		return ResponseEntity.created(uri).build();
	}
		
	@PostMapping(value = "motorista/img/{id}")
	public ResponseEntity<Void> insertPhotoMotorista(@PathVariable Integer id, @RequestParam(required = false) MultipartFile photo1, @RequestParam(required = false) MultipartFile photo2) {
		CarteiraMotorista newObj = (CarteiraMotorista) docserv.find(id);
		try {
			if (photo1 != null) {
				if (!photo1.isEmpty()) {
					byte[] bytes1 = photo1.getBytes();
					Path path1 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "f" + photo1.getOriginalFilename());
					Files.write(path1, bytes1);
					newObj.setPhoto1(String.valueOf(newObj.getId() + "f" + photo1.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
			if (photo2 != null) {
				if (!photo2.isEmpty()) {
					byte[] bytes2 = photo2.getBytes();
					Path path2 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "v" + photo2.getOriginalFilename());
					Files.write(path2, bytes2);
					newObj.setPhoto2(String.valueOf(newObj.getId() + "v" + photo2.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "motorista/{id}")
	public ResponseEntity<Void> update(@RequestBody CarteiraMotoristaDTO obj, @PathVariable Integer id) {
		CarteiraMotorista motorista = new CarteiraMotorista();
		motorista = (CarteiraMotorista) docserv.find(id);
		motorista.setNumberDocument(obj.getNumberDocument() == null ? motorista.getNumberDocument() : obj.getNumberDocument());
		motorista.setCategoria(obj.getCategoria() == null ? motorista.getCategoria() : obj.getCategoria());
		motorista.setPrimeiraHabilitacao(obj.getPrimeiraHabilitacao() == null ? motorista.getPrimeiraHabilitacao() : obj.getPrimeiraHabilitacao());
		motorista.setValidade(obj.getValidade() == null ? motorista.getValidade() : obj.getValidade());
		motorista.setPermissao(obj.getPermissao() == null ? motorista.getPermissao() : obj.getPermissao());
		motorista.setACC(obj.getAcc() == null ? motorista.getACC() : obj.getAcc());
		motorista.setObservacoes(obj.getObservacoes() == null ? motorista.getObservacoes() : obj.getObservacoes());
		motorista.setPrivateDocument(obj.getPrivateDocument() == null ? motorista.getPrivateDocument() : obj.getPrivateDocument());
		motorista = docserv.update(motorista);
		return ResponseEntity.noContent().build();
	}

	// ==========>Carteira de Trabalho<==========

	@PostMapping(value = "trabalho")
	public ResponseEntity<Void> insert(@RequestBody CarteiraTrabalhoDTO obj) {
		CarteiraTrabalho newObj = docserv.TrabalhoDtoFromTrabalho(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		responseServ.setHeader("access-control-expose-headers", "*");
		responseServ.setHeader("idDocument", newObj.getId().toString());
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "trabalho/img/{id}")
	public ResponseEntity<Void> insertPhotoTrabalho(@PathVariable Integer id, @RequestParam(required = false) MultipartFile photo1, @RequestParam(required = false) MultipartFile photo2) {
		CarteiraTrabalho newObj = (CarteiraTrabalho) docserv.find(id);
		try {
			if (photo1 != null) {
				if (!photo1.isEmpty()) {
					byte[] bytes1 = photo1.getBytes();
					Path path1 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "f" + photo1.getOriginalFilename());
					Files.write(path1, bytes1);
					newObj.setPhoto1(String.valueOf(newObj.getId() + "f" + photo1.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
			if (photo2 != null) {
				if (!photo2.isEmpty()) {
					byte[] bytes2 = photo2.getBytes();
					Path path2 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "v" + photo2.getOriginalFilename());
					Files.write(path2, bytes2);
					newObj.setPhoto2(String.valueOf(newObj.getId() + "v" + photo2.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "trabalho/{id}")
	public ResponseEntity<Void> update(@RequestBody CarteiraTrabalhoDTO obj, @PathVariable Integer id) {
		CarteiraTrabalho trabalho = new CarteiraTrabalho();
		trabalho = (CarteiraTrabalho) docserv.find(id);
		trabalho.setNumberDocument(obj.getNumberDocument() == null ? trabalho.getNumberDocument() : obj.getNumberDocument());
		trabalho.setPis(obj.getPis() == null ? trabalho.getPis() : obj.getPis());
		trabalho.setSerie(obj.getSerie() == null ? trabalho.getSerie() : obj.getSerie());
		trabalho.setUf(obj.getUf() == null ? trabalho.getUf() : obj.getUf());
		trabalho.setPrivateDocument(obj.getPrivateDocument() == null ? trabalho.getPrivateDocument() : obj.getPrivateDocument());
		trabalho = docserv.update(trabalho);
		return ResponseEntity.noContent().build();
	}

	// )==========>Certidao de Casamento<==========

	@PostMapping(value = "casamento")
	public ResponseEntity<Void> insert(@RequestBody CertidaoCasamentoDTO obj) {
		CertidaoCasamento newObj = docserv.CasamentoDtoFromCasamento(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		responseServ.setHeader("access-control-expose-headers", "*");
		responseServ.setHeader("idDocument", newObj.getId().toString());
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "casamento/img/{id}")
	public ResponseEntity<Void> insertPhotoCasamento(@PathVariable Integer id, @RequestParam(required = false) MultipartFile photo1, @RequestParam(required = false) MultipartFile photo2) {
		CertidaoCasamento newObj = (CertidaoCasamento) docserv.find(id);
		try {
			if (photo1 != null) {
				if (!photo1.isEmpty()) {
					byte[] bytes1 = photo1.getBytes();
					Path path1 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "f" + photo1.getOriginalFilename());
					Files.write(path1, bytes1);
					newObj.setPhoto1(String.valueOf(newObj.getId() + "f" + photo1.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
			if (photo2 != null) {
				if (!photo2.isEmpty()) {
					byte[] bytes2 = photo2.getBytes();
					Path path2 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "v" + photo2.getOriginalFilename());
					Files.write(path2, bytes2);
					newObj.setPhoto2(String.valueOf(newObj.getId() + "v" + photo2.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "casamento/{id}")
	public ResponseEntity<Void> update(@RequestBody CertidaoCasamentoDTO obj, @PathVariable Integer id) {
		CertidaoCasamento casamento = new CertidaoCasamento();
		casamento = (CertidaoCasamento) docserv.find(id);
		casamento.setNumberDocument(obj.getNumberDocument() == null ? casamento.getNumberDocument() : obj.getNumberDocument());
		casamento.setDataCasamento(obj.getDataCasamento() == null ? casamento.getDataCasamento() : obj.getDataCasamento());
		casamento.setNomeConjuge(obj.getNomeConjuge() == null ? casamento.getNomeConjuge() : obj.getNomeConjuge());
		casamento.setCpfConjuge(obj.getCpfConjuge() == null ? casamento.getCpfConjuge() : obj.getCpfConjuge());
		casamento.setNascimentoConjuge(obj.getNascimentoConjuge() == null ? casamento.getNascimentoConjuge() : obj.getNascimentoConjuge());
		casamento.setCidadeNascimentoConjuge(obj.getCidadeNascimentoConjuge() == null ? casamento.getCidadeNascimentoConjuge() : obj.getCidadeNascimentoConjuge());
		casamento.setPaiConjunge(obj.getPaiConjunge() == null ? casamento.getPaiConjunge() : obj.getPaiConjunge());
		casamento.setMaeConjuge(obj.getMaeConjuge() == null ? casamento.getMaeConjuge() : obj.getMaeConjuge());
		casamento.setRegimeBens(obj.getRegimeBens() == null ? casamento.getRegimeBens() : obj.getRegimeBens());
		casamento.setObservacoes(obj.getObservacoes() == null ? casamento.getObservacoes() : obj.getObservacoes());
		casamento.setPrivateDocument(obj.getPrivateDocument() == null ? casamento.getPrivateDocument() : obj.getPrivateDocument());
		casamento = docserv.update(casamento);
		return ResponseEntity.noContent().build();
	}

	// ==========>Certidao de Nascimento<==========

	@PostMapping(value = "nascimento")
	public ResponseEntity<Void> insert(@RequestBody CertidaoNascimentoDTO obj) {
		CertidaoNascimento newObj = docserv.NascimentoDtoFromNascimento(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		responseServ.setHeader("access-control-expose-headers", "*");
		responseServ.setHeader("idDocument", newObj.getId().toString());
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "nascimento/img/{id}")
	public ResponseEntity<Void> insertPhotoNascimento(@PathVariable Integer id, @RequestParam(required = false) MultipartFile photo1, @RequestParam(required = false) MultipartFile photo2) {
		CertidaoNascimento newObj = (CertidaoNascimento) docserv.find(id);
		try {
			if (photo1 != null) {
				if (!photo1.isEmpty()) {
					byte[] bytes1 = photo1.getBytes();
					Path path1 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "f" + photo1.getOriginalFilename());
					Files.write(path1, bytes1);
					newObj.setPhoto1(String.valueOf(newObj.getId() + "f" + photo1.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
			if (photo2 != null) {
				if (!photo2.isEmpty()) {
					byte[] bytes2 = photo2.getBytes();
					Path path2 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "v" + photo2.getOriginalFilename());
					Files.write(path2, bytes2);
					newObj.setPhoto2(String.valueOf(newObj.getId() + "v" + photo2.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "nascimento/{id}")
	public ResponseEntity<Void> update(@RequestBody CertidaoNascimentoDTO obj, @PathVariable Integer id) {
		CertidaoNascimento nascimento = new CertidaoNascimento();
		nascimento = (CertidaoNascimento) docserv.find(id);
		nascimento.setNumberDocument(obj.getNumberDocument() == null ? nascimento.getNumberDocument() : obj.getNumberDocument());
		nascimento.setCpf(obj.getCpf() == null ? nascimento.getCpf() : obj.getCpf());
		nascimento.setDataNascimento(obj.getDataNascimento() == null ? nascimento.getDataNascimento() : obj.getDataNascimento());
		nascimento.setLocalNascimento(obj.getLocalNascimento() == null ? nascimento.getLocalNascimento() : obj.getLocalNascimento());
		nascimento.setSexo(obj.getSexo() == null ? nascimento.getSexo() : obj.getSexo());
		nascimento.setNumeroDnv(obj.getNumeroDnv() == null ? nascimento.getNumeroDnv() : obj.getNumeroDnv());
		nascimento.setFiliacao(obj.getFiliacao() == null ? nascimento.getFiliacao() : obj.getFiliacao());
		nascimento.setAvosPaternos(obj.getAvosPaternos() == null ? nascimento.getAvosPaternos() : obj.getAvosPaternos());
		nascimento.setAvosMaternos(obj.getAvosMaternos() == null ? nascimento.getAvosMaternos() : obj.getAvosMaternos());
		nascimento.setMunicipioDeRegistro(obj.getMunicipioDeRegistro() == null ? nascimento.getMunicipioDeRegistro() : obj.getMunicipioDeRegistro());
		nascimento.setNaturalidade(obj.getNaturalidade() == null ? nascimento.getNaturalidade() : obj.getNaturalidade());
		nascimento.setObservacao(obj.getObservacao() == null ? nascimento.getObservacao() : obj.getObservacao());
		nascimento.setPrivateDocument(obj.getPrivateDocument() == null ? nascimento.getPrivateDocument() : obj.getPrivateDocument());
		nascimento = docserv.update(nascimento);
		return ResponseEntity.noContent().build();
	}

	// ==========>Endereco<==========

	@PostMapping(value = "endereco")
	public ResponseEntity<Void> insert(@RequestBody EnderecoDTO obj) {
		Endereco newObj = docserv.enderecoDtoFromEndereco(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		responseServ.setHeader("access-control-expose-headers", "*");
		responseServ.setHeader("idDocument", newObj.getId().toString());
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "endereco/img/{id}")
	public ResponseEntity<Void> insertPhotoEndereco(@PathVariable Integer id, @RequestParam(required = false) MultipartFile photo1, @RequestParam(required = false) MultipartFile photo2) {
		Endereco newObj = (Endereco) docserv.find(id);
		try {
			if (photo1 != null) {
				if (!photo1.isEmpty()) {
					byte[] bytes1 = photo1.getBytes();
					Path path1 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "f" + photo1.getOriginalFilename());
					Files.write(path1, bytes1);
					newObj.setPhoto1(String.valueOf(newObj.getId() + "f" + photo1.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
			if (photo2 != null) {
				if (!photo2.isEmpty()) {
					byte[] bytes2 = photo2.getBytes();
					Path path2 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "v" + photo2.getOriginalFilename());
					Files.write(path2, bytes2);
					newObj.setPhoto2(String.valueOf(newObj.getId() + "v" + photo2.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "endereco/{id}")
	public ResponseEntity<Void> update(@RequestBody EnderecoDTO obj, @PathVariable Integer id) {
		Endereco endereco = new Endereco();
		endereco = (Endereco) docserv.find(id);
		endereco.setEndereco(obj.getEndereco() == null ? endereco.getEndereco() : obj.getEndereco());
		endereco.setNumero(obj.getNumero() == null ? endereco.getNumero() : obj.getNumero());
		endereco.setComplemento(obj.getComplemento() == null ? endereco.getComplemento() : obj.getComplemento());
		endereco.setCep(obj.getCep() == null ? endereco.getCep() : obj.getCep());
		endereco.setUf(obj.getUf() == null ? endereco.getUf() : obj.getUf());
		endereco.setCidade(obj.getCidade() == null ? endereco.getCidade() : obj.getCidade());
		endereco.setPrivateDocument(obj.getPrivateDocument() == null ? endereco.getPrivateDocument() : obj.getPrivateDocument());
		endereco = docserv.update(endereco);
		return ResponseEntity.noContent().build();
	}

	// ==========>OUTROs<==========

	@PostMapping(value = "outros")
	public ResponseEntity<Void> insert(@RequestBody OutrosDTO obj) {
		Outros newObj = docserv.outrosDtoFromOutros(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		responseServ.setHeader("access-control-expose-headers", "*");
		responseServ.setHeader("idDocument", newObj.getId().toString());
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "outros/img/{id}")
	public ResponseEntity<Void> insertPhotoOutros(@PathVariable Integer id, @RequestParam(required = false) MultipartFile photo1, @RequestParam(required = false) MultipartFile photo2) {
		Outros newObj = (Outros) docserv.find(id);
		try {
			if (photo1 != null) {
				if (!photo1.isEmpty()) {
					byte[] bytes1 = photo1.getBytes();
					Path path1 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "f" + photo1.getOriginalFilename());
					Files.write(path1, bytes1);
					newObj.setPhoto1(String.valueOf(newObj.getId() + "f" + photo1.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
			if (photo2 != null) {
				if (!photo2.isEmpty()) {
					byte[] bytes2 = photo2.getBytes();
					Path path2 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "v" + photo2.getOriginalFilename());
					Files.write(path2, bytes2);
					newObj.setPhoto2(String.valueOf(newObj.getId() + "v" + photo2.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "outros/{id}")
	public ResponseEntity<Void> update(@RequestBody OutrosDTO obj, @PathVariable Integer id) {
		Outros outros = new Outros();
		outros = (Outros) docserv.find(id);
		outros.setNomeDocumento(obj.getNomeDocumento() == null ? outros.getNomeDocumento() : obj.getNomeDocumento());
		outros.setNumberDocument(obj.getNumberDocument() == null ? outros.getNumberDocument() : obj.getNumberDocument());
		outros.setDados(obj.getDados() == null ? outros.getDados() : obj.getDados());
		outros.setPrivateDocument(obj.getPrivateDocument() == null ? outros.getPrivateDocument() : obj.getPrivateDocument());
		outros = docserv.update(outros);
		return ResponseEntity.noContent().build();
	}

	// ==========>RG<==========

	@PostMapping(value = "rg")
	public ResponseEntity<Void> insert(@RequestBody RgDTO obj) {
		Rg newObj = docserv.rgDtoFromRg(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		responseServ.setHeader("access-control-expose-headers", "*");
		responseServ.setHeader("idDocument", newObj.getId().toString());
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "rg/img/{id}")
	public ResponseEntity<Void> insertPhotoRg(@PathVariable Integer id, @RequestParam(required = false) MultipartFile photo1, @RequestParam(required = false) MultipartFile photo2) {
		Rg newObj = (Rg) docserv.find(id);
		try {
			if (photo1 != null) {
				if (!photo1.isEmpty()) {
					byte[] bytes1 = photo1.getBytes();
					Path path1 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "f" + photo1.getOriginalFilename());
					Files.write(path1, bytes1);
					newObj.setPhoto1(String.valueOf(newObj.getId() + "f" + photo1.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
			if (photo2 != null) {
				if (!photo2.isEmpty()) {
					byte[] bytes2 = photo2.getBytes();
					Path path2 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "v" + photo2.getOriginalFilename());
					Files.write(path2, bytes2);
					newObj.setPhoto2(String.valueOf(newObj.getId() + "v" + photo2.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "rg/{id}")
	public ResponseEntity<Void> update(@RequestBody RgDTO obj, @PathVariable Integer id) {
		Rg rg = new Rg();
		rg = (Rg) docserv.find(id);
		rg.setNumberDocument(obj.getNumberDocument() == null ? rg.getNumberDocument() : obj.getNumberDocument());
		rg.setOrgaoExpedidor(obj.getOrgaoExpedidor() == null ? rg.getOrgaoExpedidor() : obj.getOrgaoExpedidor());
		rg.setDataNascimento(obj.getDataNascimento() == null ? rg.getDataNascimento() : obj.getDataNascimento());
		rg.setDataExpedicao(obj.getDataExpedicao() == null ? rg.getDataExpedicao() : obj.getDataExpedicao());
		rg.setNaturalidade(obj.getNaturalidade() == null ? rg.getNaturalidade() : obj.getNaturalidade());
		rg.setNomeMae(obj.getNomeMae() == null ? rg.getNomeMae() : obj.getNomeMae());
		rg.setNomePai(obj.getNomePai() == null ? rg.getNomePai() : obj.getNomePai());
		rg.setPrivateDocument(obj.getPrivateDocument() == null ? rg.getPrivateDocument() : obj.getPrivateDocument());
		rg = docserv.update(rg);
		return ResponseEntity.noContent().build();
	}

	// ==========>Titulo Eleitor<==========

	@PostMapping(value = "eleitor")
	public ResponseEntity<Void> insert(@RequestBody TituloEleitorDTO obj) {
		TituloEleitor newObj = docserv.eleitorDtoFromEleitor(obj);
		newObj = docserv.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		responseServ.setHeader("access-control-expose-headers", "*");
		responseServ.setHeader("idDocument", newObj.getId().toString());
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "eleitor/img/{id}")
	public ResponseEntity<Void> insertPhotoTituloEleitor(@PathVariable Integer id, @RequestParam(required = false) MultipartFile photo1, @RequestParam(required = false) MultipartFile photo2) {
		TituloEleitor newObj = (TituloEleitor) docserv.find(id);
		try {
			if (photo1 != null) {
				if (!photo1.isEmpty()) {
					byte[] bytes1 = photo1.getBytes();
					Path path1 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "f" + photo1.getOriginalFilename());
					Files.write(path1, bytes1);
					newObj.setPhoto1(String.valueOf(newObj.getId() + "f" + photo1.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
			if (photo2 != null) {
				if (!photo2.isEmpty()) {
					byte[] bytes2 = photo2.getBytes();
					Path path2 = Paths.get("C:\\Cursos\\TCC\\front\\uni\\uni\\src\\assets\\img\\documents\\" + newObj.getId() + "v" + photo2.getOriginalFilename());
					Files.write(path2, bytes2);
					newObj.setPhoto2(String.valueOf(newObj.getId() + "v" + photo2.getOriginalFilename()));
					newObj = docserv.update(newObj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "eleitor/{id}")
	public ResponseEntity<Void> update(@RequestBody TituloEleitorDTO obj, @PathVariable Integer id) {
		TituloEleitor eleitor = new TituloEleitor();
		eleitor = (TituloEleitor) docserv.find(id);
		eleitor.setNumberDocument(obj.getNumberDocument() == null ? eleitor.getNumberDocument() : obj.getNumberDocument());
		eleitor.setMunicipio(obj.getMunicipio() == null ? eleitor.getMunicipio() : obj.getMunicipio());
		eleitor.setDataNascimento(obj.getDataNascimento() == null ? eleitor.getDataNascimento() : obj.getDataNascimento());
		eleitor.setDataEmissao(obj.getDataEmissao() == null ? eleitor.getDataEmissao() : obj.getDataEmissao());
		eleitor.setZona(obj.getZona() == null ? eleitor.getZona() : obj.getZona());
		eleitor.setSecao(obj.getSecao() == null ? eleitor.getSecao() : obj.getSecao());
		eleitor.setPrivateDocument(obj.getPrivateDocument() == null ? eleitor.getPrivateDocument() : obj.getPrivateDocument());
		eleitor = docserv.update(eleitor);
		return ResponseEntity.noContent().build();
	}
	
}

package com.unifica.documentos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

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
import com.unifica.documentos.repositories.CasamentoRepositories;
import com.unifica.documentos.repositories.CpfRepositories;
import com.unifica.documentos.repositories.DocumentRepositories;
import com.unifica.documentos.repositories.EleitorRepositories;
import com.unifica.documentos.repositories.EnderecoRepositories;
import com.unifica.documentos.repositories.MotoristaRepositories;
import com.unifica.documentos.repositories.NascimentoRepositories;
import com.unifica.documentos.repositories.OutrosRepositories;
import com.unifica.documentos.repositories.RgRepositories;
import com.unifica.documentos.repositories.TrabalhoRepositories;
import com.unifica.documentos.services.exceptions.DataIntegrityException;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepositories documentRepositories;

	@Autowired
	private MotoristaRepositories motoristaRepositories;

	@Autowired
	private TrabalhoRepositories trabalhoRepositories;

	@Autowired
	private CasamentoRepositories casamentoRepositories;

	@Autowired
	private NascimentoRepositories nascimentoRepositories;

	@Autowired
	private EnderecoRepositories enderecoRepositories;

	@Autowired
	private OutrosRepositories outrosRepositories;

	@Autowired
	private RgRepositories rgRepositories;

	@Autowired
	private EleitorRepositories eleitorRepositories;

	@Autowired
	private CpfRepositories cpfRepositories;

	@Autowired
	private UserService userService;

	public Document find(Integer id) {
		Optional<Document> obj = documentRepositories.findById(id);
		return obj.orElse(null);
	}

	public void deleteDocument(Integer id) {
		find(id);
		try {

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir o documento");
		}
	}

	public CarteiraMotorista MotoristaDtoFromMotorista(CarteiraMotoristaDTO dto) {
		return new CarteiraMotorista(null, dto.getType(), dto.getNumberDocument(), dto.getPhotoDocument(),
				userService.find(dto.getUser()), dto.getValidade(), dto.getPrimeiraHabilitacao(), dto.getCategoria(),
				dto.getPermissao(), dto.getAcc());
	}

	public CarteiraTrabalho TrabalhoDtoFromTrabalho(CarteiraTrabalhoDTO dto) {
		return new CarteiraTrabalho(null, dto.getType(), dto.getNumberDocument(), dto.getPhotoDocument(),
				userService.find(dto.getUser()), dto.getPis(), dto.getSerie(), dto.getUf());
	}

	public CertidaoCasamento CasamentoDtoFromCasamento(CertidaoCasamentoDTO dto) {
		return new CertidaoCasamento(null, dto.getType(), dto.getNumberDocument(), dto.getPhotoDocument(),
				userService.find(dto.getUser()), dto.getNomeConjuge(), dto.getCpfConjuge(), dto.getNascimentoConjuge(),
				dto.getCidadeNascimentoConjuge(), dto.getPaiConjunge(), dto.getMaeConjuge(), dto.getDataCasamento(),
				dto.getRegimeBens(), dto.getObservacoes());
	}

	public CertidaoNascimento NascimentoDtoFromNascimento(CertidaoNascimentoDTO dto) {
		return new CertidaoNascimento(null, dto.getType(), dto.getNumberDocument(), dto.getPhotoDocument(),
				userService.find(dto.getUser()), dto.getTipo(), dto.getCpf(), dto.getDataNascimento(),
				dto.getLocalNascimento(), dto.getSexo(), dto.getFiliacao(), dto.getAvosPaternos(),
				dto.getAvosMaternos(), dto.getNumeroDnv(), dto.getObservacao(), dto.getMunicipioDeRegistro(),
				dto.getNaturalidade());

	}

	public Cpf cpfDtoFromCpf(CpfDTO dto) {
		return new Cpf(null, dto.getType(), dto.getNumberDocument(), dto.getPhotoDocument(),
				userService.find(dto.getUser()), dto.getDataNascimento());
	}

	public Endereco enderecoDtoFromEndereco(EnderecoDTO dto) {
		return new Endereco(null, dto.getType(), dto.getNumberDocument(), dto.getPhotoDocument(),
				userService.find(dto.getUser()), dto.getEndereco(), dto.getComplemento(), dto.getCep(), dto.getNumero(),
				dto.getCidade(), dto.getUf());
	}

	public Outros outrosDtoFromOutros(OutrosDTO dto) {
		return new Outros(null, dto.getType(), dto.getNumberDocument(), dto.getPhotoDocument(),
				userService.find(dto.getUser()), dto.getNomeDocumento(), dto.getDados());
	}

	public Rg rgDtoFromRg(RgDTO dto) {
		return new Rg(null, dto.getType(), dto.getNumberDocument(), dto.getPhotoDocument(),
				userService.find(dto.getUser()), dto.getDataExpedicao(), dto.getDataNascimento(), dto.getNaturalidade(),
				dto.getNomePai(), dto.getNomeMae(), dto.getOrgaoExpedidor());
	}

	public TituloEleitor eleitorDtoFromEleitor(TituloEleitorDTO dto) {
		return new TituloEleitor(null, dto.getType(), dto.getNumberDocument(), dto.getPhotoDocument(),
				userService.find(dto.getUser()), dto.getDataNascimento(), dto.getDataEmissao(), dto.getZona(),
				dto.getSecao(), dto.getMunicipio());
	}

	// ==========>CPF<==========
	public Cpf insert(Cpf obj) {
		obj.setId(null);
		// objCpf.setUser(objCpf.getUser());
		return cpfRepositories.save(obj);
	}

	public Cpf update(Cpf obj) {
		find(obj.getId());
		return cpfRepositories.save(obj);
	}

	// ==========>Motorista<==========
	public CarteiraMotorista insert(CarteiraMotorista obj) {
		obj.setId(null);
		return motoristaRepositories.save(obj);
	}

	public CarteiraMotorista update(CarteiraMotorista obj) {
		find(obj.getId());
		return motoristaRepositories.save(obj);
	}

	// ==========>Carteira de Trabalho<==========
	public CarteiraTrabalho insert(CarteiraTrabalho obj) {
		obj.setId(null);
		return trabalhoRepositories.save(obj);
	}

	public CarteiraTrabalho update(CarteiraTrabalho obj) {
		find(obj.getId());
		return trabalhoRepositories.save(obj);
	}

	// ==========>Certidao de Casamento<==========
	public CertidaoCasamento insert(CertidaoCasamento obj) {
		obj.setId(null);
		return casamentoRepositories.save(obj);
	}

	public CertidaoCasamento update(CertidaoCasamento obj) {
		find(obj.getId());
		return casamentoRepositories.save(obj);
	}

	// ==========>Certidao de Nascimento<==========
	public CertidaoNascimento insert(CertidaoNascimento obj) {
		obj.setId(null);
		return nascimentoRepositories.save(obj);
	}

	public CertidaoNascimento update(CertidaoNascimento obj) {
		find(obj.getId());
		return nascimentoRepositories.save(obj);
	}

	// ==========>Endereco<==========
	public Endereco insert(Endereco obj) {
		obj.setId(null);
		return enderecoRepositories.save(obj);
	}

	public Endereco update(Endereco obj) {
		find(obj.getId());
		return enderecoRepositories.save(obj);
	}

	// ==========>OUTROs<==========
	public Outros insert(Outros obj) {
		obj.setId(null);
		return outrosRepositories.save(obj);
	}

	public Outros update(Outros obj) {
		find(obj.getId());
		return outrosRepositories.save(obj);
	}

	// ==========>RG<==========
	public Rg insert(Rg obj) {
		obj.setId(null);
		return rgRepositories.save(obj);
	}

	public Rg update(Rg obj) {
		find(obj.getId());
		return rgRepositories.save(obj);
	}

	// ==========>Titulo Eleitor<==========
	public TituloEleitor insert(TituloEleitor obj) {
		obj.setId(null);
		return eleitorRepositories.save(obj);
	}

	public TituloEleitor update(TituloEleitor obj) {
		find(obj.getId());
		return eleitorRepositories.save(obj);
	}
}

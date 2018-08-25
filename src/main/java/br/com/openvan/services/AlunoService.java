package br.com.openvan.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.openvan.domain.Aluno;
import br.com.openvan.domain.Colegio;
import br.com.openvan.domain.Contato;
import br.com.openvan.domain.Endereco;
import br.com.openvan.domain.Veiculo;
import br.com.openvan.domain.enums.PeriodoAluno;
import br.com.openvan.domain.enums.StatusAluno;
import br.com.openvan.dto.AlunoDTO;
import br.com.openvan.dto.AlunoNewDTO;
import br.com.openvan.repositories.AlunoRepository;
import br.com.openvan.repositories.ColegioRepository;
import br.com.openvan.repositories.ContatoRepository;
import br.com.openvan.repositories.EnderecoRepository;
import br.com.openvan.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private ColegioRepository colegioRepository;
	
	public Aluno find(Long id) {
		Optional<Aluno> obj = repo.findById(id);
	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
	}
	
	@Transactional
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		contatoRepository.saveAll(obj.getContatos());
		
		return obj;
	}
	
	public Aluno update(Aluno obj) {
		Aluno newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Long id) {
		find(id);
		try {

			repo.deleteById(id);	
		 
		} catch(DataIntegrityViolationException e){ 
			// Nunca vai entrar nesta exceção pois o Aluno não depende de nenhuma outra classe para ser criada
			throw new DataIntegrityViolationException("Não é possivel excluir o Aluno");
		}
	}
	
	public List<Aluno> findAll(){
		return repo.findAll();
	}
	
	public Page<Aluno> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	public Aluno fromDTO(AlunoDTO objDTO) {
		Colegio clg = new Colegio(null, 3, "Newton Guimarães", "R. Guarujá", 228, "(43) 3324-2263", "nenhum", new Date());
		Veiculo vel = new Veiculo(null, "João Guilherme de Souza", 1, "Renault Master", 2013, "ATIVO", null, new Date());
		
		return new Aluno(objDTO.getId(), objDTO.getNome(), objDTO.getPai(), objDTO.getMae(), objDTO.getPeriodo(), objDTO.getCelular(), objDTO.getStatus(), objDTO.getRecado(), objDTO.getValor(), objDTO.getVencimentoMensalidade(), new Date(), clg, vel);
	}

	public Aluno fromDTO(AlunoNewDTO objDTO) {
		Colegio clg = new Colegio(null, 3, "Newton Guimarães", "R. Guarujá", 228, "(43) 3324-2263", "nenhum", new Date());
		Veiculo vel = new Veiculo(null, "João Guilherme de Souza", 1, "Renault Master", 2013, "ATIVO", null, new Date());
		
		Aluno aln = new Aluno(null, objDTO.getNome(), objDTO.getPai(), objDTO.getMae(), PeriodoAluno.toEnum(objDTO.getPeriodo()), objDTO.getCelular(), StatusAluno.toEnum(objDTO.getStatus()), objDTO.getRecado(), objDTO.getValor(), objDTO.getVencimentoMensalidade(), objDTO.getRegistro(), clg, vel);
		Endereco end = new Endereco(null, objDTO.getEndereco(), objDTO.getNumero(), objDTO.getBairro(), objDTO.getComplemento(), aln);
		Contato cont = new Contato(null, objDTO.getReferencia(), objDTO.getCelular_contato(), objDTO.getComercial(), objDTO.getResidencial(), aln);
		aln.getEnderecos().add(end);
		aln.getContatos().add(cont);
		
		return aln;
		//return new Aluno(objDTO.getId(), objDTO.getNome(), objDTO.getPai(), objDTO.getMae(), objDTO.getPeriodo(), objDTO.getCelular(), objDTO.getStatus(), objDTO.getRecado(), objDTO.getValor(), objDTO.getVencimentoMensalidade(), null, null, null);
	}

	
	private void updateData(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setPai(obj.getPai());
		newObj.setMae(obj.getMae());
		newObj.setPeriodo(obj.getPeriodo());
		newObj.setRecado(obj.getRecado());
		newObj.setCelular(obj.getCelular());
		newObj.setStatus(obj.getStatus());
		newObj.setValor(obj.getValor());
		newObj.setVencimentoMensalidade(obj.getVencimentoMensalidade());
	//	newObj.setRegistro(obj.getRegistro());
	}
	
	public Page<Aluno> search(String nome, List<Long> ids, Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Colegio> colegios = colegioRepository.findAllById(ids);
				
		return repo.search(nome, (Colegio) colegios, pageRequest);
		
	}
}

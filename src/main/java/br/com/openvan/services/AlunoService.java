package br.com.openvan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.openvan.domain.Aluno;
import br.com.openvan.dto.AlunoDTO;
import br.com.openvan.repositories.AlunoRepository;
import br.com.openvan.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;

	public Aluno find(Long id) {
		Optional<Aluno> obj = repo.findById(id);
	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
	}
	
	
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
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

		return new Aluno(objDTO.getId(), objDTO.getNome(), objDTO.getPai(), objDTO.getMae(), objDTO.getPeriodo(), objDTO.getCelular(), objDTO.getStatus(), objDTO.getRecado(), objDTO.getValor(), objDTO.getVencimentoMensalidade(), null, null, null);
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
}

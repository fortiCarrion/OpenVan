package br.com.openvan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.openvan.domain.Colegio;
import br.com.openvan.repositories.ColegioRepository;
import br.com.openvan.services.exceptions.ObjectNotFoundException;

@Service
public class ColegioService {
	
	@Autowired
	private ColegioRepository repo;

	public Colegio find(Long id) {
		Optional<Colegio> obj = repo.findById(id);
	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
	}
	
	public Colegio insert(Colegio obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Colegio update(Colegio obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		try {

			repo.deleteById(id);	
		 
		} catch(DataIntegrityViolationException e){ 
			// Nunca vai entrar nesta exceção pois o Colegio não depende de nenhuma outra classe para ser criada
			throw new DataIntegrityViolationException("Não é possivel excluir o Colegio");
		}
	}
	
	public List<Colegio> findAll(){
		return repo.findAll();
	}
	
	public Page<Colegio> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
}

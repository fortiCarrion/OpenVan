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

import br.com.openvan.domain.Veiculo;
import br.com.openvan.dto.VeiculoDTO;
import br.com.openvan.repositories.VeiculoRepository;
import br.com.openvan.services.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;

	public Veiculo find(Long id) {
		Optional<Veiculo> obj = repo.findById(id);
	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
	}
	

	public Veiculo insert(Veiculo obj) {
		obj.setId(null);
		obj.setRegistro(new Date());
		return repo.save(obj);
	}
	
	public Veiculo update(Veiculo obj) {
		Veiculo newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Long id) {
		find(id);
		try {

			repo.deleteById(id);	
		 
		} catch(DataIntegrityViolationException e){ 
			// Nunca vai entrar nesta exceção pois o Veiculo não depende de nenhuma outra classe para ser criada
			throw new DataIntegrityViolationException("Não é possivel excluir o Veiculo");
		}
	}
	
	public List<Veiculo> findAll(){
		return repo.findAll();
	}
	
	public Page<Veiculo> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	public Veiculo fromDTO(VeiculoDTO objDTO) {

		//throw new UnsupportedOperationException();
		return new Veiculo(objDTO.getId(), objDTO.getCondutor(), objDTO.getNumero(), objDTO.getModelo(), objDTO.getAno(), objDTO.getStatus(), objDTO.getRecado(), objDTO.getRegistro());
	}
	
	private void updateData(Veiculo newObj, Veiculo obj) {
		newObj.setCondutor(obj.getCondutor());
		newObj.setStatus(obj.getStatus());
		newObj.setNumero(obj.getNumero());
		newObj.setModelo(obj.getModelo());
		newObj.setAno(obj.getAno());
		newObj.setRecado(obj.getRecado());
	}

}

package br.com.openvan.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.openvan.domain.Colegio;
import br.com.openvan.dto.ColegioDTO;
import br.com.openvan.services.ColegioService;

@RestController
@RequestMapping(value = "/colegios")
public class ColegioResource {
	
	@Autowired
	private ColegioService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Colegio> find(@PathVariable Long id) {
		
		Colegio obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ColegioDTO objDTO){
		Colegio obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ColegioDTO objDTO, @PathVariable Long id){
		Colegio obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ColegioDTO>> findAll() {
		
		List<Colegio> list = service.findAll();
		List<ColegioDTO> listDTO = list.stream().map(obj -> new ColegioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Colegio>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		
		Page<Colegio> list = service.findPage(page, linesPerPage, direction, orderBy);
		
		return ResponseEntity.ok().body(list);
	}
	
	
}

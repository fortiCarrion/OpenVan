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

import br.com.openvan.domain.Aluno;
import br.com.openvan.dto.AlunoDTO;
import br.com.openvan.dto.AlunoNewDTO;
import br.com.openvan.resources.util.URL;
import br.com.openvan.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> find(@PathVariable Long id) {
		
		Aluno obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Aluno obj){
//		Aluno obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Aluno obj, @PathVariable Long id){
		//Aluno obj = service.fromDTO(objDTO);
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
	public ResponseEntity<List<AlunoDTO>> findAll() {
		
		List<Aluno> list = service.findAll();
		List<AlunoDTO> listDTO = list.stream().map(obj -> new AlunoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<AlunoDTO>> findPage(
			@RequestParam(value = "colegio", defaultValue = "") String colegio, 
			@RequestParam(value = "veiculo", defaultValue = "") String veiculo, 
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		String nomeDecode = URL.decodeParam(colegio);
		List<Long> ids = URL.decodeIntList(colegio);
		Page<Aluno> list = service.search(nomeDecode, ids, page, linesPerPage, direction, orderBy);
		Page<AlunoDTO> listDTO = list.map(obj -> new AlunoDTO(obj));
		
		return ResponseEntity.ok().body(listDTO);
	}
	

}

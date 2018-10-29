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

import br.com.openvan.domain.Mensalidade;
import br.com.openvan.dto.MensalidadeDTO;
import br.com.openvan.services.MensalidadeService;

@RestController
@RequestMapping(value = "/mensalidades")
public class MensalidadeResource {
	
	@Autowired
	private MensalidadeService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Mensalidade> find(@PathVariable Long id) {
		
		Mensalidade obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MensalidadeDTO objDTO){
		Mensalidade obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody MensalidadeDTO objDTO, @PathVariable Long id){
		Mensalidade obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MensalidadeDTO>> findAll() {
		
		List<Mensalidade> list = service.findAll();
		List<MensalidadeDTO> listDTO = list.stream().map(obj -> new MensalidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
	public ResponseEntity<List<MensalidadeDTO>> findByStatus(@PathVariable int status) {
		List<Mensalidade> list = service.findByStatus(status);
		List<MensalidadeDTO> listDTO = list.stream().map(obj -> new MensalidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	

}

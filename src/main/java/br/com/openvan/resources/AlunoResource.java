package br.com.openvan.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.openvan.domain.Aluno;
import br.com.openvan.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;

	private Date today = new Date();

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		
		Aluno obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
}

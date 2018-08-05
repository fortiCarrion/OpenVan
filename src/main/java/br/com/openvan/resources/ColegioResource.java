package br.com.openvan.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.openvan.domain.Colegio;
import br.com.openvan.services.ColegioService;

@RestController
@RequestMapping(value = "/colegios")
public class ColegioResource {
	
	@Autowired
	private ColegioService service;

	private Date today = new Date();

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		
		Colegio obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
}

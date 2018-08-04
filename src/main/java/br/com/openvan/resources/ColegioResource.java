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
		
//		Colegio c1 = new Colegio(1L, "particular", "maxi", "av. duque caxias", 1589, "33 96559356", "https:\\www.maxi.com.br", today); 
//		Colegio c2 = new Colegio(1L, "publica", "benetida", "av. maritacas", 125, "33 96559356", "nenhum", today); 
		
//		List<Colegio> lista = new ArrayList<>();
//		lista.add(c1);
//		lista.add(c2);
		
//		return lista;
	}
}

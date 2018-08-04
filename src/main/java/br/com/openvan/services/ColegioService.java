package br.com.openvan.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.openvan.domain.Colegio;
import br.com.openvan.repositories.ColegioRepository;

@Service
public class ColegioService {
	
	@Autowired
	private ColegioRepository repo;

	public Colegio buscar(Long id) {
		Optional<Colegio> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
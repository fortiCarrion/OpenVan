package br.com.openvan.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.openvan.domain.Veiculo;
import br.com.openvan.repositories.VeiculoRepository;
import br.com.openvan.services.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;

	public Veiculo buscar(Long id) {
		Optional<Veiculo> obj = repo.findById(id);
	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
	}
}

package br.com.openvan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.openvan.repositories.AlunoRepository;
import br.com.openvan.repositories.ContatoRepository;

@Service
public class ContatosService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;
}

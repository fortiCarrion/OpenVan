package br.com.openvan;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.openvan.domain.Aluno;
import br.com.openvan.domain.Colegio;
import br.com.openvan.domain.Veiculo;
import br.com.openvan.repositories.AlunoRepository;
import br.com.openvan.repositories.ColegioRepository;
import br.com.openvan.repositories.VeiculoRepository;

@SpringBootApplication
public class OpenvanProjectApplication implements CommandLineRunner {
	
	@Autowired
	private ColegioRepository colegioRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	private Date today = new Date();

	public static void main(String[] args) {
		SpringApplication.run(OpenvanProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Colegio c1 = new Colegio(null, "particular", "maxi", "av. duque caxias", 1589, "33 96559356", "https:\\www.maxi.com.br", today); 
		Colegio c2 = new Colegio(null, "publica", "benetida", "av. maritacas", 125, "33 96559356", "nenhum", today); 
		
		Veiculo v1 = new Veiculo(null, "João Guilherme de Souza", 1, "Renault Master", 2013, "ATIVO", null , today);
		Veiculo v2 = new Veiculo(null, "Pedro Mauro", 2, "Mercedez Skyline", 2015, "ATIVO", null , today);
		
		Aluno a1 = new Aluno(null, "Douglas Andrade Junior", "Victor Andrade Rico", "Alessandra Andrade Mattielo", "NOTURNO" , "43 96559384", "ATIVO", "Esta doente só volta dia 15/08", 100.00f, 5, today, c1, v2);
		
		colegioRepository.saveAll(Arrays.asList(c1, c2));
		veiculoRepository.saveAll(Arrays.asList(v1, v2));
		alunoRepository.saveAll(Arrays.asList(a1));
	}
}

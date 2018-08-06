package br.com.openvan;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.openvan.domain.Aluno;
import br.com.openvan.domain.Colegio;
import br.com.openvan.domain.Endereco;
import br.com.openvan.domain.Veiculo;
import br.com.openvan.repositories.AlunoRepository;
import br.com.openvan.repositories.ColegioRepository;
import br.com.openvan.repositories.EnderecoRepository;
import br.com.openvan.repositories.VeiculoRepository;

@SpringBootApplication
public class OpenvanProjectApplication implements CommandLineRunner {
	
	@Autowired
	private ColegioRepository colegioRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
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
		Aluno a2 = new Aluno(null, "Marcos Antonio", "Emanuel Antonio de Lima", "Jessica Meneguel Lima", "MATUTINO" , "43 96559384", "ATIVO", null, 95.50f, 10, today, c2, v2);
		Aluno a3 = new Aluno(null, "Arthur Cronita", "Ricardo Cronita Meneguel", "Carla de Souza Cronita", "NOTURNO" , "43 96559384", "ATIVO", null, 95.99f, 5, today, c1, v2);
		
		Endereco e1 = new Endereco(null, "Rua Leopoldina", 579, "aeroporto", a1);
		Endereco e2 = new Endereco(null, "Rua Fransico Bode", 345, "salvador", a2);
		Endereco e3 = new Endereco(null, "Av. São João", 1458, "cervejada", a3);
		Endereco e4 = new Endereco(null, "Av. Tiradentes", 3451, "madeiro", a1);
		
		a1.getEnderecos().addAll(Arrays.asList(e1, e4));
		a2.getEnderecos().addAll(Arrays.asList(e2));
		a3.getEnderecos().addAll(Arrays.asList(e3));
				
		colegioRepository.saveAll(Arrays.asList(c1, c2));
		veiculoRepository.saveAll(Arrays.asList(v1, v2));
		alunoRepository.saveAll(Arrays.asList(a1, a2, a3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
	}
}

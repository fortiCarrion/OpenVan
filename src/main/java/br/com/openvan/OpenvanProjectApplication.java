package br.com.openvan;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.openvan.domain.Colegio;
import br.com.openvan.repositories.ColegioRepository;

@SpringBootApplication
public class OpenvanProjectApplication implements CommandLineRunner {
	
	@Autowired
	private ColegioRepository colegioRepository;
	
	private Date today = new Date();

	public static void main(String[] args) {
		SpringApplication.run(OpenvanProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Colegio c1 = new Colegio(null, "particular", "maxi", "av. duque caxias", 1589, "33 96559356", "https:\\www.maxi.com.br", today); 
		Colegio c2 = new Colegio(null, "publica", "benetida", "av. maritacas", 125, "33 96559356", "nenhum", today); 
		
		
		colegioRepository.saveAll(Arrays.asList(c1, c2));
		
	}
}

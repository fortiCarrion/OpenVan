package br.com.openvan;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.openvan.domain.Aluno;
import br.com.openvan.domain.Colegio;
import br.com.openvan.domain.Contato;
import br.com.openvan.domain.Endereco;
import br.com.openvan.domain.Mensalidade;
import br.com.openvan.domain.Veiculo;
import br.com.openvan.repositories.AlunoRepository;
import br.com.openvan.repositories.ColegioRepository;
import br.com.openvan.repositories.ContatoRepository;
import br.com.openvan.repositories.EnderecoRepository;
import br.com.openvan.repositories.MensalidadeRepository;
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

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private MensalidadeRepository mensalidadeRepository;

	private Date today = new Date();
	private Calendar vencimento = Calendar.getInstance();

	public static void main(String[] args) {
		SpringApplication.run(OpenvanProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Colegio c1 = new Colegio(null, "particular", "maxi", "av. duque caxias", 1589, "33 96559356",
				"https:\\www.maxi.com.br", today);
		Colegio c2 = new Colegio(null, "publica", "benetida", "av. maritacas", 125, "33 96559356", "nenhum", today);

		Veiculo v1 = new Veiculo(null, "João Guilherme de Souza", 1, "Renault Master", 2013, "ATIVO", null, today);
		Veiculo v2 = new Veiculo(null, "Pedro Mauro", 2, "Mercedez Skyline", 2015, "ATIVO", null, today);

		Aluno a1 = new Aluno(null, "Douglas Andrade Junior", "Victor Andrade Rico", "Alessandra Andrade Mattielo",
				"NOTURNO", "43 96559384", "ATIVO", "Esta doente só volta dia 15/08", 100.00f, 5, today, c1, v2);
		Aluno a2 = new Aluno(null, "Marcos Antonio", "Emanuel Antonio de Lima", "Jessica Meneguel Lima", "MATUTINO",
				"43 96559384", "ATIVO", null, 95.50f, 10, today, c2, v2);
		Aluno a3 = new Aluno(null, "Arthur Cronita", "Ricardo Cronita Meneguel", "Carla de Souza Cronita", "NOTURNO",
				"43 96559384", "ATIVO", null, 95.99f, 5, today, c1, v2);

		Endereco e1 = new Endereco(null, "Rua Leopoldina", 579, "aeroporto", a1);
		Endereco e2 = new Endereco(null, "Rua Fransico Bode", 345, "salvador", a2);
		Endereco e3 = new Endereco(null, "Av. São João", 1458, "cervejada", a3);
		Endereco e4 = new Endereco(null, "Av. Tiradentes", 3451, "madeiro", a1);

		Contato con1 = new Contato(null, "pai", "43 9655-9548", "3339-2978", "3334-8958", a1);
		Contato con2 = new Contato(null, "mãe", "43 9655-9548", "3339-2978", "3334-8958", a1);
		Contato con3 = new Contato(null, "irmão", "43 9655-9548", "3339-2978", "3334-8958", a2);
		Contato con4 = new Contato(null, "vó", "43 9655-9548", "3339-2978", "3334-8958", a3);

		vencimento.setTime(today);
		int ano = vencimento.get(Calendar.YEAR);
		int mes = vencimento.get(Calendar.MONTH) + 1;
		vencimento.set(ano, mes, a1.getVencimentoMensalidade());

		Mensalidade men1 = new Mensalidade(null, today, vencimento.getTime(), null, "PENDENTE", a1.getValor(), a1);

		a1.getEnderecos().addAll(Arrays.asList(e1, e4));
		a2.getEnderecos().addAll(Arrays.asList(e2));
		a3.getEnderecos().addAll(Arrays.asList(e3));

		a1.getContatos().addAll(Arrays.asList(con1, con2));
		a2.getContatos().addAll(Arrays.asList(con3));
		a3.getContatos().addAll(Arrays.asList(con4));

		a1.getMensalidades().addAll(Arrays.asList(men1));

		colegioRepository.saveAll(Arrays.asList(c1, c2));
		veiculoRepository.saveAll(Arrays.asList(v1, v2));
		alunoRepository.saveAll(Arrays.asList(a1, a2, a3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
		contatoRepository.saveAll(Arrays.asList(con1, con2, con3, con4));
		mensalidadeRepository.saveAll(Arrays.asList(men1));

	}
}

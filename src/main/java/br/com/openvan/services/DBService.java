package br.com.openvan.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.openvan.domain.Aluno;
import br.com.openvan.domain.Colegio;
import br.com.openvan.domain.Contato;
import br.com.openvan.domain.Endereco;
import br.com.openvan.domain.Mensalidade;
import br.com.openvan.domain.Veiculo;
import br.com.openvan.domain.enums.PeriodoAluno;
import br.com.openvan.domain.enums.StatusAluno;
import br.com.openvan.domain.enums.StatusPagamento;
import br.com.openvan.domain.enums.StatusVeiculo;
import br.com.openvan.repositories.AlunoRepository;
import br.com.openvan.repositories.ColegioRepository;
import br.com.openvan.repositories.ContatoRepository;
import br.com.openvan.repositories.EnderecoRepository;
import br.com.openvan.repositories.MensalidadeRepository;
import br.com.openvan.repositories.VeiculoRepository;

@Service
public class DBService {
	

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


	public void instantiateTestDataBase() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Colegio c1 = new Colegio(null, 1, "Maxi", "av. duque caxias", 1589, "(43) 3372-5555", "https:\\www.maxi.com.br", sdf.parse("02/07/2018 23:50"));
		Colegio c2 = new Colegio(null, 2, "Benedita Rosa Rezende", "av. maritacas", 125, "33 96559356", "nenhum", sdf.parse("15/07/2018 12:16"));
		Colegio c3 = new Colegio(null, 3, "Uninorte Junior", "Av. Santos Dumont", 1565, "33 96559356", "nenhum", sdf.parse("15/07/2018 12:16"));
		Colegio c4 = new Colegio(null, 1, "Outro", "av. maritacas", 125, "33 96559356", "nenhum", sdf.parse("15/07/2018 12:20"));
		Colegio c5 = new Colegio(null, 2, "Ética", "Av. Santos Dumont", 1200, "(43) 3326-8572", "nenhum", sdf.parse("16/05/2018 13:16"));
		Colegio c6 = new Colegio(null, 1, "Nossa Senhora de Lourdes", "Av. São João", 965, "(43) 3337-6226", "http://www.ldanslourdes.seed.pr.gov.br/modules/liaise/", sdf.parse("15/07/2018 12:16"));
		Colegio c7 = new Colegio(null, 1, "Mãe de Deus", "Av. Rio de Janeiro", 670, "(43) 3878-6800", "http://www.maededeus.edu.br/", sdf.parse("19/06/2018 10:21"));
		Colegio c8 = new Colegio(null, 3, "Machado de Assis", "R. Jaú", 148, "(43) 3325-8549", "http://www.ldamachadodeassis.seed.pr.gov.br/modules/conteudo/conteudo.php?conteudo=1", sdf.parse("20/06/2018 12:11"));
		Colegio c9 = new Colegio(null, 2, "Educar", "av. maritacas", 125, "33 96559356", "nenhum", sdf.parse("25/06/2018 12:36"));
		Colegio c10 = new Colegio(null, 1, "Marista", "Rua Maringá", 78, "(43) 3374-3600", "https://londrina.colegiosmaristas.com.br/", sdf.parse("01/07/2018 08:16"));
		Colegio c11 = new Colegio(null, 3, "Margarida de Barros Lisboa", "R. Finlândia", 150, "(43) 3341-7841", "nenhum", sdf.parse("02/07/2018 14:42"));
		Colegio c12 = new Colegio(null, 3, "Newton Guimarães", "R. Guarujá", 228, "(43) 3324-2263", "nenhum", sdf.parse("02/07/2018 18:30"));
		
		Veiculo v1 = new Veiculo(null, "João Guilherme de Souza", 1, "Renault Master", 2013, StatusVeiculo.ATIVO, null, sdf.parse("22/07/2018 11:30"));
		Veiculo v2 = new Veiculo(null, "Pedro Mauro", 2, "Mercedez Skyline", 2015, StatusVeiculo.ATIVO, null, sdf.parse("02/08/2018 09:21"));
		Veiculo v3 = new Veiculo(null, "Momonga", 3, "Mercedez Skyline", 2015, StatusVeiculo.ATIVO, null, sdf.parse("02/08/2018 09:21"));
		Veiculo v4 = new Veiculo(null, "Albedo", 4, "Mercedez Skyline", 2015, StatusVeiculo.INATIVO, null, sdf.parse("02/08/2018 09:21"));
		Veiculo v5 = new Veiculo(null, "Cocytus ", 5, "Mercedez Skyline", 2017, StatusVeiculo.MANUTENÇÃO, null, sdf.parse("02/08/2018 09:21"));
		Veiculo v6 = new Veiculo(null, "Shalltear Bloodfallen", 6, "Mercedez Skyline", 2015, StatusVeiculo.ATIVO, null, sdf.parse("02/08/2018 09:21"));
		Veiculo v7 = new Veiculo(null, "Demiurge", 7, "Mercedez Skyline", 2017, StatusVeiculo.ATIVO, null, sdf.parse("02/08/2018 09:21"));
		Veiculo v8 = new Veiculo(null, "Aura Bella Fiora", 8, "Mercedez Skyline", 2016, StatusVeiculo.INATIVO, null, sdf.parse("02/08/2018 09:21"));
		Veiculo v9 = new Veiculo(null, "Gazef Stronoff", 9, "Mercedez Skyline", 2013, StatusVeiculo.ATIVO, null, sdf.parse("02/08/2018 09:21"));
		Veiculo v10 = new Veiculo(null, "Nigun Grid Luin", 10, "Mercedez Skyline", 2018, StatusVeiculo.ATIVO, null, sdf.parse("02/08/2018 09:21"));
		
		Aluno a1 = new Aluno(null, "Douglas Andrade Junior", "Victor Andrade Rico", "Alessandra Andrade Mattielo", PeriodoAluno.NOTURNO, "43 96559384", StatusAluno.ATIVO, "Esta doente só volta dia 15/08", 100.00, 5, sdf.parse("03/08/2018 13:30"), c3, v2);
		Aluno a2 = new Aluno(null, "Marcos Antonio", "Emanuel Antonio de Lima", "Jessica Meneguel Lima", PeriodoAluno.MATUTINO, "43 96559384", StatusAluno.ATIVO, null, 95.50, 10, sdf.parse("03/08/2018 13:50"), c1, v1);
		Aluno a3 = new Aluno(null, "Arthur Cronita", "Ricardo Cronita Meneguel", "Carla de Souza Cronita", PeriodoAluno.VESPERTINO, "43 96559384", StatusAluno.ATIVO, null, 95.99, 5, sdf.parse("04/08/2018 14:30"), c6, v8);

		Endereco e1 = new Endereco(null, "Rua Leopoldina", 579, "aeroporto", null, a1);
		Endereco e2 = new Endereco(null, "Rua Fransico Bode", 345, "salvador", null, a2);
		Endereco e3 = new Endereco(null, "Av. São João", 1458, "cervejada", null, a3);
		Endereco e4 = new Endereco(null, "Av. Tiradentes", 3451, "madeiro", null, a1);

		Contato con1 = new Contato(null, "pai", "43 9655-9548", "3339-2978", "3334-8958", a1);
		Contato con2 = new Contato(null, "mãe", "43 9655-9548", "3339-2978", "3334-8958", a1);
		Contato con3 = new Contato(null, "irmão", "43 9655-9548", "3339-2978", "3334-8958", a2);
		Contato con4 = new Contato(null, "vó", "43 9655-9548", "3339-2978", "3334-8958", a3);
		
		vencimento.setTime(today);
		int ano = vencimento.get(Calendar.YEAR);
		int mes = vencimento.get(Calendar.MONTH) + 1;
		vencimento.set(ano, mes, a1.getVencimentoMensalidade());

		//Mensalidade men1 = new Mensalidade(null, sdf.parse("12/08/2018 10:55"), vencimento.getTime(), null, StatusPagamento.PENDENTE, a1.getValor(), a1);
		//Mensalidade men2 = new Mensalidade(null, sdf.parse("15/08/2018 18:12"), vencimento.getTime(), sdf.parse("20/08/2018 22:30"), StatusPagamento.QUITADO, a2.getValor(), a2);

		a1.getEnderecos().addAll(Arrays.asList(e1, e4));
		a2.getEnderecos().addAll(Arrays.asList(e2));
		a3.getEnderecos().addAll(Arrays.asList(e3));

		a1.getContatos().addAll(Arrays.asList(con1, con2));
		a2.getContatos().addAll(Arrays.asList(con3));
		a3.getContatos().addAll(Arrays.asList(con4));

		//a1.getMensalidades().addAll(Arrays.asList(men1));

		colegioRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));
		veiculoRepository.saveAll(Arrays.asList(v1, v2, v3,v4,v5,v6,v7,v8,v9,v10));
		alunoRepository.saveAll(Arrays.asList(a1, a2, a3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
		contatoRepository.saveAll(Arrays.asList(con1, con2, con3, con4));
		//mensalidadeRepository.saveAll(Arrays.asList(men1, men2));

	}
}

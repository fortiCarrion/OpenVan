package br.com.openvan.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.openvan.domain.Aluno;
import br.com.openvan.domain.Colegio;
import br.com.openvan.domain.Contato;
import br.com.openvan.domain.Endereco;
import br.com.openvan.domain.Veiculo;
import br.com.openvan.domain.enums.PeriodoAluno;
import br.com.openvan.domain.enums.StatusAluno;
import br.com.openvan.domain.enums.StatusVeiculo;
import br.com.openvan.dto.AlunoDTO;
import br.com.openvan.dto.AlunoNewDTO;
import br.com.openvan.repositories.AlunoRepository;
import br.com.openvan.repositories.ColegioRepository;
import br.com.openvan.repositories.ContatoRepository;
import br.com.openvan.repositories.EnderecoRepository;
import br.com.openvan.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private ColegioRepository colegioRepository;

	@Autowired
	private ColegioService colegioService;

	@Autowired
	private VeiculoService veiculoService;
	
	public Aluno find(Long id) {
		Optional<Aluno> obj = repo.findById(id);
	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
	}
	
	@Transactional
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		obj.setColegio(colegioService.find(obj.getColegio().getId()));
		obj.setVeiculo(veiculoService.find(obj.getVeiculo().getId()));
		obj.setRegistro(new Date());
		obj = repo.save(obj);
		
		for(Endereco x : obj.getEnderecos()) {
			x.setId(null);
			x.setEndereco(x.getEndereco());
			x.setBairro(x.getBairro());
			x.setNumero(x.getNumero());
			x.setComplemento(x.getComplemento());
			x.setAluno(obj);
			
			enderecoRepository.saveAll(Arrays.asList(x));
						
		}
		
		for(Contato x : obj.getContatos()) {
			x.setId(null);
			x.setReferencia(x.getReferencia());
			x.setResidencial(x.getResidencial());
			x.setCelular(x.getCelular());
			x.setComercial(x.getComercial());
			x.setAluno(obj);
			
			contatoRepository.saveAll(Arrays.asList(x));
				
		}
		
		return obj;
	}
	
	public Aluno update(Aluno obj) {
		Aluno newObj = find(obj.getId());
//		newObj.setColegio(colegioService.find(obj.getColegio().getId()));
//		newObj.setVeiculo(veiculoService.find(obj.getVeiculo().getId()));
//		
		System.out.println(newObj.toString());
		updateData(newObj, obj);
		return repo.save(newObj);	
	}
	
	public Aluno update2(Aluno obj) {
		Aluno newObj = find(obj.getId());
		StatusAluno statusAluno;
		
		newObj.setStatus(obj.getStatus());

		for(Contato x : obj.getContatos()) {
			if(x.getId() == null) {
				x.setId(null); 
			} else {x.setId(x.getId());
			}
			x.setReferencia(x.getReferencia());
			x.setResidencial(x.getResidencial());
			x.setCelular(x.getCelular());
			x.setComercial(x.getComercial());
			x.setAluno(obj);
			
			contatoRepository.saveAll(Arrays.asList(x));
				
		}

		System.out.println("newObj" + newObj.toString());
				
		for(Endereco x : obj.getEnderecos()) {
			if(x.getId() == null) {
				x.setId(null); 
			} else {x.setId(x.getId());
			}
			x.setEndereco(x.getEndereco());
			x.setBairro(x.getBairro());
			x.setNumero(x.getNumero());
			x.setComplemento(x.getComplemento());
			x.setAluno(obj);
			
			enderecoRepository.saveAll(Arrays.asList(x));
						
		}
		
		System.out.println("newObj2" + newObj.toString());
		
		updateData(newObj, obj);
		repo.save(newObj);
		return newObj;
	}
	
	public void delete(Long id) {
		find(id);
		try {

			repo.deleteById(id);	
		 
		} catch(DataIntegrityViolationException e){ 
			throw new DataIntegrityViolationException("Não é possivel excluir porque há mensalidades relacionadas");
		}
	}
	
	public List<Aluno> findAll(){
		return repo.findAll();
	}
	
	public Page<Aluno> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	public Aluno fromDTO(AlunoDTO objDTO) {
		//Colegio clg = new Colegio(null, 3, "Newton Guimarães", "R. Guarujá", 228, "(43) 3324-2263", "nenhum", new Date());
		//Veiculo vel = new Veiculo(null, "João Guilherme de Souza", 1, "Renault Master", 2013, StatusVeiculo.ATIVO, null, new Date());
		Colegio clg = objDTO.getColegio();
		Veiculo vel = objDTO.getVeiculo();
		
		return new Aluno(objDTO.getId(), objDTO.getNome(), objDTO.getPai(), objDTO.getMae(), objDTO.getPeriodo(), objDTO.getCelular(), objDTO.getStatus(), objDTO.getRecado(), objDTO.getValor(), objDTO.getVencimentoMensalidade(), objDTO.getRegistro(), clg, vel);
	}

	public Aluno fromDTO(AlunoNewDTO objDTO) {
		//Colegio clg = new Colegio(null, colegioService.find(objDTO.getColegio().getId()), "Newton Guimarães", "R. Guarujá", 228, "(43) 3324-2263", "nenhum", new Date());
		//Veiculo vel = new Veiculo(null, "João Guilherme de Souza", 1, "Renault Master", 2013, "ATIVO", null, new Date());
//		objDTO.setColegio(colegioService.find(objDTO.getColegio().getId()));
//		objDTO.setVeiculo(veiculoService.find(objDTO.getVeiculo().getId()));
//		
		
		Aluno aln = new Aluno(null, objDTO.getNome(), objDTO.getPai(), objDTO.getMae(), PeriodoAluno.toEnum(objDTO.getPeriodo()), objDTO.getCelular(), 
				StatusAluno.toEnum(objDTO.getStatus()), objDTO.getRecado(), objDTO.getValor(), objDTO.getVencimentoMensalidade(), null, 
				null, null);
		//List<Endereco> enderecos;
		for(Endereco x : objDTO.getEnderecos()) {
			x.setId(null);
			x.setEndereco(x.getEndereco());
			x.setNumero(x.getNumero());
			x.setBairro(x.getBairro());
			x.setComplemento(x.getComplemento());
			x.setAluno(aln);
		}
		List<Contato> contatos = objDTO.getContatos();
		
		aln.getEnderecos().addAll(objDTO.getEnderecos());
		//aln.getContatos().addAll(contatos);
		
		return aln;
		//return new Aluno(objDTO.getId(), objDTO.getNome(), objDTO.getPai(), objDTO.getMae(), objDTO.getPeriodo(), objDTO.getCelular(), objDTO.getStatus(), objDTO.getRecado(), objDTO.getValor(), objDTO.getVencimentoMensalidade(), null, null, null);
	}

	
	private void updateData(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setPai(obj.getPai());
		newObj.setMae(obj.getMae());
		newObj.setPeriodo(obj.getPeriodo());
		newObj.setRecado(obj.getRecado());
		newObj.setCelular(obj.getCelular());
		newObj.setStatus(obj.getStatus());
		newObj.setValor(obj.getValor());
		newObj.setVencimentoMensalidade(obj.getVencimentoMensalidade());
		
		newObj.setColegio(colegioService.find(obj.getColegio().getId()));
		newObj.setVeiculo(veiculoService.find(obj.getVeiculo().getId()));

		System.out.println(obj.getContatos().toString());
//		
//		Contato con = new Contato(obj.get);
//		
//		ArrayList<Contato> newContatos;
//		
//		newObj.setContatos(contatoRepository.saveAll(obj.getContatos()));
		
//		ArrayList<Contato> newContatos = null;
		
		for(Contato x : obj.getContatos()) {
//			newContatos.add(new Contato(obj.getId(), x.getReferencia(), x.getResidencial(), x.getCelular(), x.getComercial(), obj));
			x.setId(x.getId());
			x.setReferencia(x.getReferencia());
			x.setResidencial(x.getResidencial());
			x.setCelular(x.getCelular());
			x.setComercial(x.getComercial());
			x.setAluno(obj);
			
//			System.out.println("1--"+x);
//			System.out.println(newContatos.toString());
			newObj.setContatos(contatoRepository.saveAll(obj.getContatos()));
//			System.out.println("2--"+obj.getContatos().toString());
		}
		
		//List<Contato> newContatos = obj.getContatos();
		
		//updateData(newObj.getContatos(), obj.getContatos());
		
	}
	
	public Page<Aluno> search(String nome, List<Long> ids, Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Colegio> colegios = colegioRepository.findAllById(ids);
				
		return repo.search(nome, (Colegio) colegios, pageRequest);
		
	}
}

package br.com.openvan.services;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.com.openvan.domain.Mensalidade;
import br.com.openvan.domain.enums.StatusPagamento;
import br.com.openvan.dto.MensalidadeDTO;
import br.com.openvan.repositories.MensalidadeRepository;
import br.com.openvan.services.exceptions.ObjectNotFoundException;

@Service
public class MensalidadeService {
	
	@Autowired
	private MensalidadeRepository repo;

	public Mensalidade find(Long id) {
		Optional<Mensalidade> obj = repo.findById(id);
	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
	}
	
	public List<Mensalidade> findAll(){
		return repo.findAll();
	}

	public List<Mensalidade> findByStatus(int status){
		return repo.findByStatus(status);
	}
	
	public Mensalidade insert(Mensalidade obj) {
		obj.setId(null);
		obj.setEmissao(new Date());
		return repo.save(obj);
	}
	
	public Mensalidade update(Mensalidade obj) {
		Mensalidade newObj = find(obj.getId());
		StatusPagamento status;
		
		switch (obj.getStatus()) {
		case QUITADO:
			newObj.setPagamento(new Date());	
			break;
		case CANCELADO:
			newObj.setCancelamento(new Date());
			break;
		default:
			break;
			
		}
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	public Mensalidade fromDTO(MensalidadeDTO objDTO) {

		return new Mensalidade(objDTO.getId(), objDTO.getEmissao(), objDTO.getPagamento(), objDTO.getCancelamento(), objDTO.getVencimento(), objDTO.getStatus(), objDTO.getValor(), objDTO.getAluno());
	}
	
	private void updateData(Mensalidade newObj, Mensalidade obj) {
		newObj.setStatus(obj.getStatus());
	}

}

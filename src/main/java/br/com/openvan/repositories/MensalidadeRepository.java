package br.com.openvan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.openvan.domain.Mensalidade;

@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long> {

	List<Mensalidade> findByStatus(int status);
}

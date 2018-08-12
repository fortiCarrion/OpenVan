package br.com.openvan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.openvan.domain.Mensalidade;

@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long> {

}

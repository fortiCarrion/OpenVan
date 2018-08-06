package br.com.openvan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.openvan.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}

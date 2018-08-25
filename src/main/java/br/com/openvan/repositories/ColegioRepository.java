package br.com.openvan.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.openvan.domain.Colegio;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Long>{

}

package br.com.openvan.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.openvan.domain.Aluno;
import br.com.openvan.domain.Colegio;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Aluno obj INNER JOIN obj.colegio cat WHERE obj.nome LIKE %:nome% AND cat IN :colegio")
	Page<Aluno> search(@Param("nome") String nome, @Param("colegio") Colegio colegio,Pageable pageRequest);

}

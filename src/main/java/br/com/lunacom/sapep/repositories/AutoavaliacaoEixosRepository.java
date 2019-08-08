package br.com.lunacom.sapep.repositories;

import br.com.lunacom.sapep.domain.AutoavaliacaoEixos;
import br.com.lunacom.sapep.domain.Conceito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoavaliacaoEixosRepository extends JpaRepository<AutoavaliacaoEixos, Integer> { }

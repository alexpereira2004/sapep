package br.com.lunacom.sapep.repositories;

import br.com.lunacom.sapep.domain.Conceito;
import br.com.lunacom.sapep.domain.Eixo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EixoRepository extends JpaRepository<Eixo, Integer> { }

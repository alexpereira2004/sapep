package br.com.lunacom.sapep.repositories;

import br.com.lunacom.sapep.domain.Conceito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceitoRepository extends JpaRepository<Conceito, Integer> { }

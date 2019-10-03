package br.com.lunacom.sapep.repositories;

import br.com.lunacom.sapep.domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> { }

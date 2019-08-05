package br.com.lunacom.sapep.repositories;

import br.com.lunacom.sapep.domain.Autoavaliacao;
import br.com.lunacom.sapep.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoavaliacaoRepository extends JpaRepository<Autoavaliacao, Integer> { }


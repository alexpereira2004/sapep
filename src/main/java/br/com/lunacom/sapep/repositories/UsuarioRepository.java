package br.com.lunacom.sapep.repositories;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> { }

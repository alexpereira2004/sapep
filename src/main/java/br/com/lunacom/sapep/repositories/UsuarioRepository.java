package br.com.lunacom.sapep.repositories;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Transactional(readOnly=true)
    Usuario findByEmail(String email);
}

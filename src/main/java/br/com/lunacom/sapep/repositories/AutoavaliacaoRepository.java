package br.com.lunacom.sapep.repositories;

import br.com.lunacom.sapep.domain.Autoavaliacao;
import br.com.lunacom.sapep.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutoavaliacaoRepository extends JpaRepository<Autoavaliacao, Integer> {
    public Optional<Autoavaliacao> findByIdAndCurso_Responsaveis_Usuario_Id(int idCurso, int idUsuario);

    public List<Autoavaliacao> findAllByCurso_Responsaveis_Usuario_Id(int IdUsuario);
}


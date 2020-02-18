package br.com.lunacom.sapep.repositories;

import br.com.lunacom.sapep.domain.Eixo;
import br.com.lunacom.sapep.domain.Meta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetaRepository extends JpaRepository<Meta, Integer> {
    List<Meta> findByEixo(Eixo eixo);

    List<Meta> findByEixo_Autoavaliacao_Id(int idAutoavaliacao);
}
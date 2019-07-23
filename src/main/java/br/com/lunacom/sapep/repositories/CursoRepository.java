package br.com.lunacom.sapep.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.lunacom.sapep.domain.Curso;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}

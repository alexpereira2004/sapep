package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.dto.CursoNovoDTO;
import br.com.lunacom.sapep.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repo;

    public Curso insert(Curso obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Curso fromDTO(CursoNovoDTO objDto) {
        ModelMapper mapper = new ModelMapper();
        Curso curso = mapper.map(objDto, Curso.class);
        return curso;
    }
}

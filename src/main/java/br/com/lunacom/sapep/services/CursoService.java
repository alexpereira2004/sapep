package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.dto.CursoDTO;
import br.com.lunacom.sapep.domain.dto.CursoNovoDTO;
import br.com.lunacom.sapep.repositories.CursoRepository;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repo;

    public Curso insert(Curso obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public List<Curso> findAll() {
        return repo.findAll();
    }

    public Curso fromDTO(CursoNovoDTO objDto) {
        ModelMapper mapper = new ModelMapper();
        Curso curso = mapper.map(objDto, Curso.class);
        return curso;
    }
    public CursoDTO toDTO(Curso obj) {
        ModelMapper mapper = new ModelMapper();
//        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CursoDTO cursoDTO = mapper.map(obj, CursoDTO.class);
        return cursoDTO;
    }
}

package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.dto.CursoDTO;
import br.com.lunacom.sapep.domain.dto.CursoDetalheDTO;
import br.com.lunacom.sapep.domain.dto.CursoNovoDTO;
import br.com.lunacom.sapep.repositories.CursoRepository;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repo;

    private ModelMapper mapper = new ModelMapper();

    public Curso insert(Curso obj) {
        obj.setId(null);
        obj.setCriacao(new Date());
        return repo.save(obj);
    }

    public List<Curso> findAll() {
        return repo.findAll();
    }

    public Curso find (Integer id) {
        Optional<Curso> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado um curso"));
    }

    public CursoDetalheDTO findDetailed (Integer id) {
        Optional<Curso> obj = repo.findById(id);
        obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado um curso"));
        CursoDetalheDTO cursoDetalheDTO = mapper.map(obj.get(), CursoDetalheDTO.class);
        return cursoDetalheDTO;
    }

    public Curso update(Curso obj) {
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    public Curso fromDTO(CursoNovoDTO objDto) {
        objDto.setCriacao(new Date());
        Curso curso = mapper.map(objDto, Curso.class);
        return curso;
    }

    public Curso fromDTO(CursoDTO objDto) {
        Curso curso = mapper.map(objDto, Curso.class);
        return curso;
    }

    public CursoDTO toDTO(Curso obj) {
        CursoDTO cursoDTO = mapper.map(obj, CursoDTO.class);
        return cursoDTO;
    }
}

package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Conceito;
import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.dto.ConceitoNovoDTO;
import br.com.lunacom.sapep.repositories.ConceitoRepository;
import br.com.lunacom.sapep.services.exceptions.DataIntegrityException;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ConceitoService {

    @Autowired
    private ConceitoRepository repo;

    @Autowired
    private CursoService cursoService;

    public Conceito insert(ConceitoNovoDTO objDTO) {
        Conceito obj = fromDTO(objDTO);
        Curso c1 = cursoService.find(objDTO.getCurso_id());
        obj.setId(null);
        obj.setCurso(c1);
        obj.setCriacao(new Date());
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }

    public Conceito find(Integer id) {
        Optional<Conceito> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Conceito não encontrado! Cod: " + id ));
    }

    public Conceito fromDTO(ConceitoNovoDTO objDTO) {
        ModelMapper mapper = new ModelMapper();
        Conceito obj = mapper.map(objDTO, Conceito.class);
        return obj;
    }
}

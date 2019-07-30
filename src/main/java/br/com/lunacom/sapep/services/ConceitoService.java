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

    public Conceito insert(Conceito obj) {
        obj.setId(null);
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
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id ));
    }

    public Conceito fromDTO(ConceitoNovoDTO objDTO) {
        ModelMapper mapper = new ModelMapper();
        objDTO.setCriacao(new Date());
        Conceito obj = mapper.map(objDTO, Conceito.class);
        return obj;
    }
}

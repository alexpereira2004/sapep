package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.Responsavel;
import br.com.lunacom.sapep.domain.Usuario;
import br.com.lunacom.sapep.domain.dto.ResponsavelNovoDTO;
import br.com.lunacom.sapep.repositories.ConceitoRepository;
import br.com.lunacom.sapep.repositories.ResponsavelRepository;
import br.com.lunacom.sapep.services.exceptions.DataIntegrityException;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository repo;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    public Responsavel insert(ResponsavelNovoDTO objDTO) {
        Responsavel obj = new Responsavel(); // fromDTO(objDTO);
        Curso c = cursoService.find(objDTO.getCod_curso());
        Usuario u = usuarioService.find(objDTO.getCod_usuario());
        obj.setId(null);
        obj.setCurso(c);
        obj.setUsuario(u);
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

    public Responsavel find(Integer id) {
        Optional<Responsavel> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Responsável não encontrado! Cod: " + id ));
    }

    public Responsavel fromDTO(ResponsavelNovoDTO objDTO) {
        ModelMapper mapper = new ModelMapper();
        Responsavel obj = mapper.map(objDTO, Responsavel.class);
        return obj;
    }
}

package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Autoavaliacao;
import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.Responsavel;
import br.com.lunacom.sapep.domain.dto.AutoavaliacaoDTO;
import br.com.lunacom.sapep.domain.dto.AutoavaliacaoNovoDTO;
import br.com.lunacom.sapep.domain.dto.Dto;
import br.com.lunacom.sapep.repositories.AutoavaliacaoRepository;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AutoavaliacaoService {

    @Autowired
    private AutoavaliacaoRepository repo;

    @Autowired
    private CursoService cursoService;

    public Autoavaliacao insert(AutoavaliacaoNovoDTO objDTO) {
        Autoavaliacao obj = fromDTO(objDTO);
        obj.setId(null);
        obj.setCriacao(new Date());
        Curso c = cursoService.find(objDTO.getCod_curso());
        obj.setCurso(c);
        return repo.save(obj);
    }

    public List<Autoavaliacao> findAll() {
        return repo.findAll();
    }

    public Autoavaliacao find (Integer id) {
        Optional<Autoavaliacao> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada nenhuma autoavaliação"));
    }

    public Autoavaliacao update(AutoavaliacaoNovoDTO objDto) {
        Autoavaliacao obj = fromDTO(objDto);
        obj.setCurso(cursoService.find(objDto.getCod_curso()));
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

//    public Autoavaliacao fromDTO(AutoavaliacaoNovoDTO objDto) {
//        ModelMapper mapper = new ModelMapper();
//        Autoavaliacao Autoavaliacao = mapper.map(objDto, Autoavaliacao.class);
//        return Autoavaliacao;
//    }

    public Autoavaliacao fromDTO(Dto objDto) {
        ModelMapper mapper = new ModelMapper();
        Autoavaliacao Autoavaliacao = mapper.map(objDto, Autoavaliacao.class);
        return Autoavaliacao;
    }

    public AutoavaliacaoDTO toDTO(Autoavaliacao obj) {
        ModelMapper mapper = new ModelMapper();
        AutoavaliacaoDTO AutoavaliacaoDTO = mapper.map(obj, AutoavaliacaoDTO.class);
        return AutoavaliacaoDTO;
    }
}

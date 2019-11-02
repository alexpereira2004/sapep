package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Autoavaliacao;
import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.Eixo;
import br.com.lunacom.sapep.domain.dto.Dto;
import br.com.lunacom.sapep.domain.dto.EixoNovoDTO;
import br.com.lunacom.sapep.repositories.EixoRepository;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EixoService {
    @Autowired
    private EixoRepository repo;

    @Autowired
    private AutoavaliacaoService autoavaliacaoService;

    @Transactional(propagation = Propagation.REQUIRED)
    public Eixo insert(EixoNovoDTO objDto) {
        Eixo obj = fromDTO(objDto);
        obj.setId(null);
        obj.setCriacao(new Date());

        Autoavaliacao autoavaliacao = autoavaliacaoService.find(objDto.getCod_autoavaliacao());
        obj.setAutoavaliacao(autoavaliacao);

        return repo.save(obj);
    }

    public List<Eixo> findAll() {
        return repo.findAll();
    }

    public Eixo find (Integer id) {
        Optional<Eixo> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada nenhuma autoavaliação"));
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    public Eixo fromDTO(Dto objDto) {
        ModelMapper mapper = new ModelMapper();
        Eixo Eixo = mapper.map(objDto, Eixo.class);
        return Eixo;
    }

    public Eixo update(int id, EixoNovoDTO objDto) {
        Eixo obj = fromDTO(objDto);
        Autoavaliacao autoavaliacao = autoavaliacaoService.find(objDto.getCod_autoavaliacao());
        obj.setId(id);
        obj.setAutoavaliacao(autoavaliacao);
        return repo.save(obj);
    }
}

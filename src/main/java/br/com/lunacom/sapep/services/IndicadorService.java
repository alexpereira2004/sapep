package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.Eixo;
import br.com.lunacom.sapep.domain.Indicador;
import br.com.lunacom.sapep.domain.dto.Dto;
import br.com.lunacom.sapep.domain.dto.IndicadorDTO;
import br.com.lunacom.sapep.repositories.IndicadorRepository;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IndicadorService {

    @Autowired
    private IndicadorRepository repo;

    @Autowired
    private EixoService eixoService;

    public Indicador insert(IndicadorDTO objDTO) {
        Indicador obj = fromDTO(objDTO);
        obj.setId(null);
        obj.setCriacao(new Date());
        Eixo e = eixoService.find(objDTO.getCod_eixo());
        obj.setEixo(e);
        return repo.save(obj);
    }

    public List<Indicador> findAll() {
        return repo.findAll();
    }

    public Indicador find (Integer id) {
        Optional<Indicador> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada a autoavaliação com o código informado"));
    }

    public IndicadorDTO findDetailed (Integer id) {
        Optional<Indicador> optionalObj = repo.findById(id);
        Optional<IndicadorDTO> optionalIndicadorDTO = Optional.ofNullable(toDTO(optionalObj.get()));
        return optionalIndicadorDTO.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada a autoavaliação com o código informado"));
    }

    public Indicador update(IndicadorDTO objDto) {
        Indicador obj = fromDTO(objDto);
        obj.setEixo(eixoService.find(objDto.getCod_eixo()));
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    public Indicador fromDTO(Dto objDto) {
        ModelMapper mapper = new ModelMapper();
        Indicador Indicador = mapper.map(objDto, Indicador.class);
        return Indicador;
    }

    public IndicadorDTO toDTO(Indicador obj) {
        ModelMapper mapper = new ModelMapper();
        IndicadorDTO IndicadorDTO = mapper.map(obj, IndicadorDTO.class);
        return IndicadorDTO;
    }
}

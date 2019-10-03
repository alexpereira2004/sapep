package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Eixo;
import br.com.lunacom.sapep.domain.Indicador;
import br.com.lunacom.sapep.domain.Resposta;
import br.com.lunacom.sapep.domain.dto.Dto;
import br.com.lunacom.sapep.domain.dto.RespostaDTO;
import br.com.lunacom.sapep.repositories.RespostaRepository;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository repo;

    @Autowired
    private IndicadorService indicadorService;

    public Resposta insert(RespostaDTO objDTO) {
        Resposta obj = fromDTO(objDTO);
        obj.setId(null);
        obj.setCriacao(new Date());
        Indicador i = indicadorService.find(objDTO.getCod_indicador());
        obj.setIndicador(i);
        return repo.save(obj);
    }

    public List<Resposta> findAll() {
        return repo.findAll();
    }

    public Resposta find (Integer id) {
        Optional<Resposta> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada a autoavaliação com o código informado"));
    }

    public RespostaDTO findDetailed (Integer id) {
        Optional<Resposta> optionalObj = repo.findById(id);
        Optional<RespostaDTO> optionalRespostaDTO = Optional.ofNullable(toDTO(optionalObj.get()));
        return optionalRespostaDTO.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada a autoavaliação com o código informado"));
    }

    public Resposta update(RespostaDTO objDto) {
        Resposta obj = fromDTO(objDto);
        obj.setIndicador(indicadorService.find(objDto.getCod_indicador()));
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    public Resposta fromDTO(Dto objDto) {
        ModelMapper mapper = new ModelMapper();
        Resposta Resposta = mapper.map(objDto, Resposta.class);
        return Resposta;
    }

    public RespostaDTO toDTO(Resposta obj) {
        ModelMapper mapper = new ModelMapper();
        RespostaDTO RespostaDTO = mapper.map(obj, RespostaDTO.class);
        return RespostaDTO;
    }
}
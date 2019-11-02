package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.Eixo;
import br.com.lunacom.sapep.domain.Meta;
import br.com.lunacom.sapep.domain.dto.Dto;
import br.com.lunacom.sapep.domain.dto.MetaDTO;
import br.com.lunacom.sapep.repositories.MetaRepository;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private MetaRepository repo;

    @Autowired
    private EixoService eixoService;

    public Meta insert(MetaDTO objDTO) {
        Meta obj = fromDTO(objDTO);
        obj.setId(null);
        obj.setCriacao(new Date());
        Eixo e = eixoService.find(objDTO.getCod_eixo());
        obj.setEixo(e);
        return repo.save(obj);
    }

    public List<Meta> findAll() {
        return repo.findAll();
    }

    public Meta find (Integer id) {
        Optional<Meta> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada a Meta com o código informado"));
    }

    public List<Meta> findByEixo (Integer id) {
        Eixo eixo = eixoService.find(id);
        List<Meta> metas = repo.findByEixo(eixo);
        return metas;
    }

    public Meta update(MetaDTO objDto) {
        Meta obj = fromDTO(objDto);
        obj.setEixo(eixoService.find(objDto.getCod_eixo()));
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    public Meta fromDTO(Dto objDto) {
        ModelMapper mapper = new ModelMapper();
        Meta Meta = mapper.map(objDto, Meta.class);
        return Meta;
    }

    public MetaDTO toDTO(Meta obj) {
        ModelMapper mapper = new ModelMapper();
        MetaDTO MetaDTO = mapper.map(obj, MetaDTO.class);
        return MetaDTO;
    }
}

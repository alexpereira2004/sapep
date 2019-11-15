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

import java.util.*;
import java.util.stream.Collectors;

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

    public List<Meta> findByAutoavaliacao (Integer idAutoavaliacao) {
        List<Meta> metas = repo.findByEixo_Autoavaliacao_Id(idAutoavaliacao);
        return metas;
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

    public HashMap<String, Integer> findGlobalStatus(Integer idAutoavaliacao) {
        List<Meta> metas = repo.findByEixo_Autoavaliacao_Id(idAutoavaliacao);
        HashMap<String, Integer> totais = new HashMap<String, Integer>();

        totais.put("concluidos", (int) metas.stream().filter(meta -> meta.getAlcancado() >= 100).count());
        totais.put("andamentos", (int) metas.stream()
                .filter(meta -> meta.getAlcancado() < 100)
                .filter(meta -> meta.getAlcancado() > 0)
                .count());
        totais.put("nao_iniciados", (int) metas.stream().filter(meta -> meta.getAlcancado() <= 0).count());;
        return totais;
    }

//    public List<Meta> findIndividualStatus(Integer idAutoavaliacao) {
////        ModelMapper mapper = new ModelMapper();
//        List<Meta> metas = repo.findByEixo_Autoavaliacao_Id(idAutoavaliacao);
////        List<MetaStatusDTO> status = mapper.map(metas, MetaStatusDTO.class);
////        HashMap<String, Integer> totais = new HashMap<String, Integer>();
////        metas.stream().map(meta -> {
////            if (meta.getAlcancado() > 0) {
////
////            }
////        }).collect(Collectors.toList());
//
//
//
//        return repo.findByEixo_Autoavaliacao_Id(idAutoavaliacao);
//    }


}

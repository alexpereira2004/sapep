package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.*;
import br.com.lunacom.sapep.domain.dto.*;
import br.com.lunacom.sapep.domain.enums.Perfil;
import br.com.lunacom.sapep.repositories.AutoavaliacaoRepository;
import br.com.lunacom.sapep.security.UserSS;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import br.com.lunacom.sapep.util.DataUtil;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AutoavaliacaoService {

    @Autowired
    private AutoavaliacaoRepository repo;

    @Autowired
    private CursoService cursoService;

    private ModelMapper mapper = new ModelMapper();

    public Autoavaliacao insert(AutoavaliacaoNovoDTO objDTO) {
        Autoavaliacao obj = fromDTO(objDTO);
        obj.setId(null);
        if (obj.getSituacao().isEmpty()) {
            obj.setSituacao(automaticStatus(obj));
        }
        obj.setCriacao(new Date());
        Curso c = cursoService.find(objDTO.getCod_curso());
        obj.setCurso(c);
        return repo.save(obj);
    }

    public List<AutoavaliacaoResumoDTO> findAll() {
        UserSS user = UserService.authenticated();
        List<Autoavaliacao> autoavaliacoes = new ArrayList<>();

        if (user.hasRole(Perfil.PROPPI)) {
            autoavaliacoes = repo.findAll();
        } else {
            autoavaliacoes = repo.findAllByCurso_Responsaveis_Usuario_Id(user.getId());
        }

        List<AutoavaliacaoResumoDTO> autoavaliacaoResumoDTO = autoavaliacoes.stream()
                .map(autoavaliacao -> mapper.map(autoavaliacao, AutoavaliacaoResumoDTO.class))
                .collect(Collectors.toList());

        return autoavaliacaoResumoDTO;
    }

    public Autoavaliacao find (Integer id) {

        //@TODO - Só permitir que usuário com permissão ao curso da autoavaliação acesse os dados

        Optional<Autoavaliacao> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada a autoavaliação com o código informado"));
    }

    public AutoavaliacaoDTO findDetailed (Integer id) {
        UserSS user = UserService.authenticated();

        Optional<Autoavaliacao> optionalObj;
        if (user.hasRole(Perfil.PROPPI)) {
            optionalObj = repo.findById(id);
        } else {
            optionalObj = repo.findByIdAndCurso_Responsaveis_Usuario_Id(id, user.getId());
        }

        Autoavaliacao autoavaliacao = optionalObj.orElseThrow(
                () -> new ObjectNotFoundException("Não foi encontrada a autoavaliação com o código informado"));

        AutoavaliacaoDTO autoavaliacaoDTO = toDTO(autoavaliacao);

        final List<Eixo> eixoList = autoavaliacao.getEixos();
        autoavaliacaoDTO.setTotalEixos(eixoList.size());

        int totalIndicadores = eixoList
                .stream()
                .mapToInt(e -> e.getIndicadores().size())
                .sum();

        autoavaliacaoDTO.setAnos(getListaAnosDaAutoavaliacao(
                autoavaliacaoDTO.getInicio(),
                autoavaliacaoDTO.getTermino()
        ));

        autoavaliacaoDTO.getEixos().stream().forEach(eixoDTO -> {
            Map<Integer, List<Indicador>> group;
            group = eixoDTO.getIndicadores().stream().collect(
                    Collectors.groupingBy(Indicador::getAgrupamento)
            );
            eixoDTO.setIndicadoresAgrupados(group);
        });

        autoavaliacaoDTO.setTotalIndicadores(totalIndicadores);

        return autoavaliacaoDTO;
    }

    public Autoavaliacao update(AutoavaliacaoEdicaoDTO objDto) {
        Autoavaliacao obj = fromDTO(objDto);
        if (obj.getSituacao().isEmpty()) {
            obj.setSituacao(automaticStatus(obj));
        }
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
        Autoavaliacao Autoavaliacao = mapper.map(objDto, Autoavaliacao.class);
        return Autoavaliacao;
    }

    public AutoavaliacaoDTO toDTO(Autoavaliacao obj) {
        AutoavaliacaoDTO AutoavaliacaoDTO = mapper.map(obj, AutoavaliacaoDTO.class);
        return AutoavaliacaoDTO;
    }


    private String automaticStatus(Autoavaliacao obj) {
        String ret = "IN";
        if (DataUtil.isWithinRange(
                DataUtil.getCurrentDate(),
                obj.getInicio(),
                obj.getTermino())) {
            ret = "AT";
        }
        return ret;
    }

    public List<Integer> getListaAnosDaAutoavaliacao(Autoavaliacao a) {
        return getListaAnosDaAutoavaliacao(a.getInicio(), a.getTermino());
    }

    private List<Integer> getListaAnosDaAutoavaliacao(Date inicio, Date termino) {
        final LocalDate localDateInicio = DataUtil.convertDateToLocalDate(inicio);
        final LocalDate localDateTermino = DataUtil.convertDateToLocalDate(termino);
        List<Integer> anos = new ArrayList<>();

        for (int i = localDateInicio.getYear(); i <= localDateTermino.getYear(); i++) {
            anos.add(i);
        }
        return anos;
    }
}

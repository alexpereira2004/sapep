package br.com.lunacom.sapep.domain.dto;

import br.com.lunacom.sapep.domain.Indicador;
import br.com.lunacom.sapep.domain.Meta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class EixoDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer ordem;
    private List<Indicador> indicadores;
    Map<Integer, List<Indicador>> indicadoresAgrupados;
    private List<Meta> metas;
}

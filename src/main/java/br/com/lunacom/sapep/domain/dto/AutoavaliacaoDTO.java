package br.com.lunacom.sapep.domain.dto;

import br.com.lunacom.sapep.domain.Eixo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AutoavaliacaoDTO implements Serializable, Dto {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String objetivo;
    private String situacao;
    private Date inicio;
    private Date termino;
    private Integer cod_curso;
//    private Set<AutoavaliacaoEixos> autoavaliacaoEixos = new HashSet<>();
    private List<Eixo> eixos;
}

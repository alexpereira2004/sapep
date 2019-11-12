package br.com.lunacom.sapep.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AutoavaliacaoResumoDTO implements Serializable, Dto {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String objetivo;
    private String situacao;
    private Date inicio;
    private Date termino;
    private CursoDTO curso;
}

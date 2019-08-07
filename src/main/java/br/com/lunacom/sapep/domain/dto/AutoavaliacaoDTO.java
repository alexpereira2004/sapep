package br.com.lunacom.sapep.domain.dto;

import br.com.lunacom.sapep.domain.Curso;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AutoavaliacaoDTO implements Serializable, Dto {
    private static final long serialVersionUID = 1L;

    private String nome;
    private Curso curso;
    private String Status;
    private Date inicio;
    private Date termino;
    private Date Criacao;
}

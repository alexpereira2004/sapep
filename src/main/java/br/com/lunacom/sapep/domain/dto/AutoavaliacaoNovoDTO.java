package br.com.lunacom.sapep.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AutoavaliacaoNovoDTO implements Serializable, Dto {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Informe o nome do processo de autoavaliação")
    private String nome;
    private String objetivo;
    private String situacao;

    @NotNull
    private Date inicio;

    @NotNull
    private Date termino;
    private Date Criacao;

    @Min(1)
    private Integer cod_curso;
}
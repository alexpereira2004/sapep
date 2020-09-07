package br.com.lunacom.sapep.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AutoavaliacaoCloneDTO implements Serializable, Dto {
    private static final long serialVersionUID = 1L;

    @Min(1)
    private Integer id;

    private String nome;

    @NotNull
    private Date inicio;

    @NotNull
    private Date termino;
}

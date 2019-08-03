package br.com.lunacom.sapep.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class ResponsavelNovoDTO implements Serializable, Dto {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(1)
    private Integer cod_curso;

    @NotNull
    @Min(1)
    private Integer cod_usuario;
}

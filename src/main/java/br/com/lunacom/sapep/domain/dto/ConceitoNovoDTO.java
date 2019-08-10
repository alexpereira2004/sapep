package br.com.lunacom.sapep.domain.dto;

import br.com.lunacom.sapep.domain.Curso;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class ConceitoNovoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull
    @Min(1900)
    @Max(2050)
    private Integer ano;

    @NotEmpty(message="Informe a nota do conceito")
    private String nota;

    @NotNull
    @Min(1)
    private Integer cod_curso;

    public ConceitoNovoDTO(@NotNull @Min(1900) @Max(2050) Integer ano, @NotEmpty(message = "Informe a nota do conceito") String nota, @NotNull @Min(1) Integer cod_curso) {
        this.ano = ano;
        this.nota = nota;
        this.cod_curso = cod_curso;
    }
}

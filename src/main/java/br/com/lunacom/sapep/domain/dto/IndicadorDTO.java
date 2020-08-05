package br.com.lunacom.sapep.domain.dto;

import br.com.lunacom.sapep.domain.Eixo;
import br.com.lunacom.sapep.domain.Resposta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class IndicadorDTO implements Serializable, Dto {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=200, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String titulo;
    private String detalhe;

    @Min(1)
    private Integer agrupamento;

    @Min(1)
    private Integer ordem;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=2, max=100, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String temporalidade;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=2, max=2, message="O tamanho deve conter 2 caracteres")
    private String tipo;

    private Date criacao;

    @Min(1)
    private Integer cod_eixo;
}

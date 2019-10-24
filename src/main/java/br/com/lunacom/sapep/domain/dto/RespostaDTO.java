package br.com.lunacom.sapep.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class RespostaDTO implements Serializable, Dto {
    private Integer id;
    private Integer ano;

//    @Length(min=5, max=500, message="O tamanho deve ser entre 5 e 500 caracteres")
    private String descritiva;
    private float valor;
    private Date criacao;

    @Min(1)
    private Integer cod_indicador;
}

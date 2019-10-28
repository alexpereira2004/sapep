package br.com.lunacom.sapep.domain.dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class MetaDTO implements Serializable, Dto {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String meta;
    private String pontoFraco;
    private String pontoForte;
    private String ameacaInterna;
    private String ameacaExterna;
    private String viabilidade;
    private String prioridade;
    private double alcancado;

    @Min(1)
    private Integer cod_eixo;
}

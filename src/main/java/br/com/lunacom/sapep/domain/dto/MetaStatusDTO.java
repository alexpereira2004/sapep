package br.com.lunacom.sapep.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class MetaStatusDTO {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String meta;
    private double alcancado;
}

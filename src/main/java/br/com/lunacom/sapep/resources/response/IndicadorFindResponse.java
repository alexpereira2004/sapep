package br.com.lunacom.sapep.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class IndicadorFindResponse {
    private Integer id;
    private String titulo;
    private String detalhe;
    private Integer agrupamento;
    private Integer ordem;
    private String temporalidade;
    private boolean dashboard;
    private String tipo;
    private Date criacao;

    @JsonProperty("eixo")
    private IndicadorFindEixoResponse eixo;
}

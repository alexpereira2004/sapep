package br.com.lunacom.sapep.domain.dto;

import br.com.lunacom.sapep.domain.Conceito;
import br.com.lunacom.sapep.domain.Responsavel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class CursoDetalheDTO {
        private static final long serialVersionUID = 1L;

        private Integer id;
        private String nome;
        private String situacao;
        private List<Conceito> conceitos;
        private List<Responsavel> responsaveis;
    }


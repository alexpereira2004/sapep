package br.com.lunacom.sapep.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class AutoavaliacaoEixosPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "autoavaliacao_id")
    private Autoavaliacao autoavaliacao;

    @ManyToOne
    @JoinColumn(name = "eixo_id")
    private Eixo eixo;

}

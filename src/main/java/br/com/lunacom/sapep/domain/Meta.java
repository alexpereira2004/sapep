package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Meta {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(length=400)
    private String meta;
    private String pontoFraco;
    private String pontoForte;
    private String ameacaInterna;
    private String ameacaExterna;
    private String viabilidade;
    private String prioridade;
    private double alcancado;
    private Date criacao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="eixo_id")
    private Eixo eixo;

    public Meta(String meta, double alcancado, Eixo eixo) {
        this.meta = meta;
        this.alcancado = alcancado;
        this.eixo = eixo;
    }
}

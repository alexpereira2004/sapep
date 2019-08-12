package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Indicador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String detalhe;
    private Integer agrupamento;
    private Integer ordem;
    private String temporalidade;
    private String tipo;
    private Date criacao;

    @ManyToOne
    @JoinColumn(name="eixo_id")
    private Eixo eixo;

    @JsonIgnore
    @OneToMany(mappedBy = "indicador")
    List<Resposta> respostas;
}

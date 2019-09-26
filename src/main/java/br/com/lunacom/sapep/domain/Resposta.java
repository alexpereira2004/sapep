package br.com.lunacom.sapep.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer ano;
    private String descritiva;
    private float valor;
    private Date criacao;

    @ManyToOne
    @JoinColumn(name="indicador_id")
    private Indicador indicador;

    public Resposta(Integer ano, String descritiva, float valor, Indicador indicador) {
        this.ano = ano;
        this.descritiva = descritiva;
        this.valor = valor;
        this.indicador = indicador;
    }
}

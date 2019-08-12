package br.com.lunacom.sapep.domain;

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
}

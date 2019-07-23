package br.com.lunacom.sapep.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

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
    private Time hora;

    @ManyToOne
    @JoinColumn(name="indicador_id")
    private Indicador indicador;
}

package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
public class Autoavaliacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String objetivo;
    private String Status;
    private Date inicio;
    private Date termino;
    private Date Criacao;
    private Time Hora;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;

}

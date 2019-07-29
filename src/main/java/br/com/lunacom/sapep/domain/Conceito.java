package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Setter
@Getter
public class Conceito implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private Integer ano;
    private String nota;
    private Date criacao;
    private Time hora;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;

    public Conceito(Integer id, Integer ano, String nota) {
        this.id = id;
        this.ano = ano;
        this.nota = nota;
    }
}

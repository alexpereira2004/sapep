package br.com.lunacom.sapep.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String status;
    private Date criacao;

    // https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
    @OneToMany
    @JoinColumn(name = "curso_id")
    private List<Conceito> conceitos;

    @OneToMany(mappedBy = "curso")
    private List<Autoavaliacao> autoavaliacoes;

    @OneToMany(mappedBy = "curso")
    private List<Responsavel> responsaveis;

    public Curso() {}

    public Curso(String nome, String status) {
        this.nome = nome;
        this.status = status;
    }

}

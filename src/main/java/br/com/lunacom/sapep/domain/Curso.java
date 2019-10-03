package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String situacao;
    private Date criacao;

    // https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
    @OneToMany
    @JoinColumn(name = "curso_id")
    private List<Conceito> conceitos;

    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<Autoavaliacao> autoavaliacoes;

    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<Responsavel> responsaveis;

    public Curso() {}

    public Curso(String nome, String situacao, Date criacao) {
        this.nome = nome;
        this.situacao = situacao;
        this.criacao = criacao;
    }

}

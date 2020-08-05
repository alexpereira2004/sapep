package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@Entity
public class Autoavaliacao implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String objetivo;
    private String situacao;
    private Date inicio;
    private Date termino;
    private Date criacao;

    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;

    @JsonIgnore
    @OneToMany(mappedBy = "autoavaliacao", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Eixo> eixos;

    public Autoavaliacao() {}

    public Autoavaliacao(String nome, String objetivo, String situacao, Date inicio, Date termino) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.situacao = situacao;
        this.inicio = inicio;
        this.termino = termino;
    }

    public Autoavaliacao(String nome, String objetivo, String situacao, Date inicio, Date termino, Date criacao, Curso curso) {
            this.nome = nome;
            this.objetivo = objetivo;
            this.situacao = situacao;
            this.inicio = inicio;
            this.termino = termino;
            this.criacao = criacao;
            this.curso = curso;
        }

    public Autoavaliacao(String nome, String objetivo, Date criacao, Curso curso) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.criacao = criacao;
        this.curso = curso;
    }

    //    @JsonIgnore
//    public List<Eixo> getEixos() {
//        List<Eixo> lista = new ArrayList<>();
//        for (AutoavaliacaoEixos x : autoavaliacaoEixos) {
//            lista.add(x.getEixo());
//        }
//        return lista;
//    }

    public Object clone() {
        return new Autoavaliacao(this.nome+ " (Clone)", this.objetivo, this.criacao, this.curso);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.*;

@Getter
@Setter
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;

    @JsonIgnore
    @OneToMany(mappedBy = "id.autoavaliacao")
    private Set<AutoavaliacaoEixos> autoavaliacaoEixos = new HashSet<>();

    public Autoavaliacao() {}

    public Autoavaliacao(String nome, String objetivo, String status, Date inicio, Date termino) {
        this.nome = nome;
        this.objetivo = objetivo;
        Status = status;
        this.inicio = inicio;
        this.termino = termino;
    }

    @JsonIgnore
    public List<Eixo> getEixos() {
        List<Eixo> lista = new ArrayList<>();
        for (AutoavaliacaoEixos x : autoavaliacaoEixos) {
            lista.add(x.getEixo());
        }
        return lista;
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

package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Eixo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Date criacao;

    @JsonIgnore
    @OneToMany(mappedBy = "id.eixo")
    private Set<AutoavaliacaoEixos> autoavaliacaoEixos = new HashSet<>();

    @OneToMany(mappedBy = "eixo")
    private List<Indicador> indicadores;

    public Eixo() {}

    public Eixo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }


    public Set<AutoavaliacaoEixos> getAutoavaliacaoEixos() {
        return autoavaliacaoEixos;
    }

    public void setAutoavaliacaoEixos(Set<AutoavaliacaoEixos> autoavaliacaoEixos) {
        this.autoavaliacaoEixos = autoavaliacaoEixos;
    }

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

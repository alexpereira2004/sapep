package br.com.lunacom.sapep.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String status;
    private Date criacao;
    private Time hora;

    @OneToMany
    @JoinColumn(name = "conceito_id")
    private List<Conceito> conceitos;

    @OneToMany
    @JoinColumn(name = "responsavel_id")
    private List<Responsavel> responsaveis;

    public Curso() {}

    public Curso(String nome, String status) {
        this.nome = nome;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public List<Conceito> getConceitos() {
        return conceitos;
    }

    public void setConceitos(List<Conceito> conceitos) {
        this.conceitos = conceitos;
    }

    public List<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }
}

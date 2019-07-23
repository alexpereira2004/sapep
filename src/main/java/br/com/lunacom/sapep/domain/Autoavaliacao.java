package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.*;

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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public Date getCriacao() {
        return Criacao;
    }

    public void setCriacao(Date criacao) {
        Criacao = criacao;
    }

    public Time getHora() {
        return Hora;
    }

    public void setHora(Time hora) {
        Hora = hora;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Set<AutoavaliacaoEixos> getAutoavaliacaoEixos() {
        return autoavaliacaoEixos;
    }

    public void setAutoavaliacaoEixos(Set<AutoavaliacaoEixos> autoavaliacaoEixos) {
        this.autoavaliacaoEixos = autoavaliacaoEixos;
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

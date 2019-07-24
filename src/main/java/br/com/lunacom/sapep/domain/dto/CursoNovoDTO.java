package br.com.lunacom.sapep.domain.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class CursoNovoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;
    private String status;
    private Date criacao;
    private Time hora;

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
}

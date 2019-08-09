package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "autoavaliacao_eixos")
public class AutoavaliacaoEixos implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private AutoavaliacaoEixosPK id = new AutoavaliacaoEixosPK();

    private Integer ordem;
    private Date criacao;

    public AutoavaliacaoEixos(Autoavaliacao autoavaliacao,
                              Eixo eixo,
                              Integer ordem,
                              Date criacao) {
        super();
        id.setAutoavaliacao(autoavaliacao);
        id.setEixo(eixo);
        this.ordem = ordem;
        this.criacao = criacao;
    }

    public Autoavaliacao getAutoavaliacao() {
        return id.getAutoavaliacao();
    }

    public void setAutoavaliacao(Autoavaliacao autoavaliacao) {
        id.setAutoavaliacao(autoavaliacao);
    }

    public Eixo getEixo() {
        return id.getEixo();
    }

    public void setEixo(Eixo eixo) {
        id.setEixo(eixo);
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AutoavaliacaoEixos other = (AutoavaliacaoEixos) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AutoavaliacaoEixos> ");
        builder.append("ordem");
        builder.append(ordem);
        return builder.toString();
    }
}

package br.com.lunacom.sapep.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AutoavaliacaoEixosPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "autoavaliacao_id")
    private Autoavaliacao autoavaliacao;

    @ManyToOne
    @JoinColumn(name = "eixo_id")
    private Eixo eixo;

    public Autoavaliacao getAutoavaliacao() {
        return autoavaliacao;
    }

    public void setAutoavaliacao(Autoavaliacao autoavaliacao) {
        this.autoavaliacao = autoavaliacao;
    }

    public Eixo getEixo() {
        return eixo;
    }

    public void setEixo(Eixo eixo) {
        this.eixo = eixo;
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

package br.com.lunacom.sapep.domain;

import br.com.lunacom.sapep.domain.dto.AutoavaliacaoCloneDTO;
import br.com.lunacom.sapep.domain.dto.EixoNovoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class Eixo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Integer ordem;
    private Date criacao;

    @ManyToOne
    @JoinColumn(name="autoavaliacao_id")
    private Autoavaliacao autoavaliacao;

    @JsonIgnore
    @OneToMany(mappedBy = "eixo")
    private List<Indicador> indicadores;

    @JsonIgnore
    @OneToMany(mappedBy = "eixo")
    private List<Meta> metas;

    public Eixo() {}

    public Eixo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Object clone() {
        return new EixoNovoDTO(this.nome, this.descricao, this.autoavaliacao.getId(), this.ordem);
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

    public Eixo(String nome, String descricao, Integer ordem, Date criacao, Autoavaliacao autoavaliacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.ordem = ordem;
        this.criacao = criacao;
        this.autoavaliacao = autoavaliacao;
    }
}

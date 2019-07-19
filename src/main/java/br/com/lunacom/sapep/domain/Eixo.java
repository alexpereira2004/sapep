package br.com.lunacom.sapep.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class Eixo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Date criacao;
    private Time hora;

    @OneToMany(mappedBy = "eixo")
    private List<Indicador> indicadores;
}

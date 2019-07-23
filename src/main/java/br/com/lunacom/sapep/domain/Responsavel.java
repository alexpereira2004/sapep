package br.com.lunacom.sapep.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
public class Responsavel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Date criacao;
    private Time hora;

    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;

    private Usuario usuario;
}

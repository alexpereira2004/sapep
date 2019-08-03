package br.com.lunacom.sapep.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@Entity
public class Responsavel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Date criacao;

    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
}

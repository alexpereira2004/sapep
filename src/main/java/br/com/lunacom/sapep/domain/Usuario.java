package br.com.lunacom.sapep.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @Column(unique=true)
    private String email;
    private String telefone;
    private boolean reitoria;
    private boolean admin;
    private String senha;
    private String status;
    private Date criacao;
    private Time hora;

}

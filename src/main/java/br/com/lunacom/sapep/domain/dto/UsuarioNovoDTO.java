package br.com.lunacom.sapep.domain.dto;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class UsuarioNovoDTO implements Serializable, Dto {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    @Column(unique=true)
    private String email;
    private String telefone;
    private boolean reitoria;
    private boolean admin;
    private String senha;
    private String status;
}

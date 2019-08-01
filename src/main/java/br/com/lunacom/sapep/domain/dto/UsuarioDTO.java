package br.com.lunacom.sapep.domain.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class UsuarioDTO implements Serializable, Dto {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private boolean reitoria;
    private boolean admin;
    private String status;
    private Date criacao;
}

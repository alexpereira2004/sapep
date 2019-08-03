package br.com.lunacom.sapep.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
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

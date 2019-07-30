package br.com.lunacom.sapep.domain.dto;

import br.com.lunacom.sapep.domain.Curso;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ConceitoNovoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Informe o ano do conceito")
    private Integer ano;

    @NotEmpty(message="Informe a nota do conceito")
    private String nota;

    private Date criacao;


}

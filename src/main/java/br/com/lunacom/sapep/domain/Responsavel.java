package br.com.lunacom.sapep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Responsavel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Date criacao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="curso_id")
    @NonNull private Curso curso;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="usuario_id")
    @NonNull private Usuario usuario;
}

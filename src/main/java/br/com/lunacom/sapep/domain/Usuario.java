package br.com.lunacom.sapep.domain;

import br.com.lunacom.sapep.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @JsonIgnore
    private String senha;
    private String situacao;
    private Date criacao;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    @OneToMany(mappedBy = "usuario")
    public List<Responsavel> responsabilidades;

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }

    public Usuario(String nome, String email, String senha, String situacao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.situacao = situacao;
    }
}

package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Usuario;
import br.com.lunacom.sapep.domain.dto.Dto;
import br.com.lunacom.sapep.domain.dto.UsuarioDTO;
import br.com.lunacom.sapep.domain.dto.UsuarioNovoDTO;
import br.com.lunacom.sapep.repositories.UsuarioRepository;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private UsuarioRepository repo;

    public Usuario insert(Usuario obj) {
        obj.setId(null);
        obj.setCriacao(new Date());
        obj.setSenha(pe.encode(obj.getSenha()));
        return repo.save(obj);
    }

    public List<Usuario> findAll() {
        return repo.findAll();
    }

    public Usuario find (Integer id) {
        Optional<Usuario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado um usuário"));
    }

    public Usuario update(Usuario obj) {
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    public Usuario fromDTO(UsuarioNovoDTO objDto) {
        ModelMapper mapper = new ModelMapper();
        Usuario Usuario = mapper.map(objDto, Usuario.class);
        return Usuario;
    }

    public Usuario fromDTO(Dto objDto) {
        ModelMapper mapper = new ModelMapper();
        Usuario Usuario = mapper.map(objDto, Usuario.class);
        return Usuario;
    }

    public UsuarioDTO toDTO(Usuario obj) {
        ModelMapper mapper = new ModelMapper();
        UsuarioDTO UsuarioDTO = mapper.map(obj, UsuarioDTO.class);
        return UsuarioDTO;
    }
}

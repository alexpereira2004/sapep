package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Usuario;
import br.com.lunacom.sapep.domain.dto.UsuarioDTO;
import br.com.lunacom.sapep.domain.dto.UsuarioNovoDTO;
import br.com.lunacom.sapep.security.UserSS;
import br.com.lunacom.sapep.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @PreAuthorize("hasAnyRole('ADMINISTRADOR')")
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNovoDTO objDto) {
        Usuario obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR')")
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> list = service.findAll();
        List<UsuarioDTO> listDTO = list
                .stream()
                .map(obj -> service.toDTO(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR')")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Usuario> find(@PathVariable Integer id) {
        Usuario obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
//
    @RequestMapping(value = "/detalhes", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'PROPPI', 'COORDENADOR')")
    @ResponseBody
    public Integer currentUserName(Authentication authentication) {
        UserSS i = (UserSS) authentication.getPrincipal();
        return i.getId();
    }


//    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'PROPPI', 'COORDENADOR')")
//    @RequestMapping(value="/mail/{mail}", method=RequestMethod.GET)
//    public ResponseEntity<Usuario> findByEmail(@PathVariable String email) {
//        Usuario obj = service.findByEmail(email);
//        return ResponseEntity.ok().body(obj);
//    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR')")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO objDto, @PathVariable Integer id) {
        Usuario obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR')")
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

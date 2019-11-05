package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.Eixo;
import br.com.lunacom.sapep.domain.dto.CursoDTO;
import br.com.lunacom.sapep.domain.dto.EixoNovoDTO;
import br.com.lunacom.sapep.services.EixoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/eixo")
public class EixoResource {

    @Autowired
    private EixoService service;

    @RequestMapping(method= RequestMethod.POST)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Void> insert(@Valid @RequestBody EixoNovoDTO objDto) {
        Eixo obj = service.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Eixo>> findAll() {
        List<Eixo> list = service.findAll();
//        List<EixoDTO> listDTO = list
//                .stream()
//                .map(obj -> service.toDTO(obj))
//                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Eixo> find(@PathVariable Integer id) {
        Eixo obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Void> update(@Valid @RequestBody EixoNovoDTO obj, @PathVariable Integer id) {
        service.update(id, obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

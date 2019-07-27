package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.dto.CursoDTO;
import br.com.lunacom.sapep.domain.dto.CursoNovoDTO;
import br.com.lunacom.sapep.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/curso")
public class CursoResource {

    @Autowired
    private CursoService service;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CursoNovoDTO objDto) {
        Curso obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<CursoDTO>> findAll() {
        List<Curso> list = service.findAll();
        List<CursoDTO> listDTO = list
                .stream()
                .map(obj -> service.toDTO(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<CursoDTO> find(@PathVariable Integer id) {
        Curso obj = service.find(id);
        CursoDTO objDTO = service.toDTO(obj);
        return ResponseEntity.ok().body(objDTO);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody CursoDTO objDto, @PathVariable Integer id) {
        Curso obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

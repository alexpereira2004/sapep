package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Indicador;
import br.com.lunacom.sapep.domain.dto.IndicadorDTO;
import br.com.lunacom.sapep.services.IndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/indicador")
public class IndicadorResource {

    @Autowired
    private IndicadorService service;

    @RequestMapping(method= RequestMethod.POST)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Void> insert(@Valid @RequestBody IndicadorDTO objDto) {
        Indicador obj = service.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Indicador>> findAll() {
        List<Indicador> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Indicador> find(@PathVariable Integer id) {
        Indicador obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/detalhado/{id}", method=RequestMethod.GET)
    public ResponseEntity<IndicadorDTO> findDetailed(@PathVariable Integer id) {
        IndicadorDTO objDto = service.findDetailed(id);
        return ResponseEntity.ok().body(objDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Void> update(@Valid @RequestBody IndicadorDTO objDto, @PathVariable Integer id) {
        objDto.setId(id);
        service.update(objDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
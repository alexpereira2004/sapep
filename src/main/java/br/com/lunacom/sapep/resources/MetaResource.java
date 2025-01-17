package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Meta;
import br.com.lunacom.sapep.domain.dto.MetaDTO;
import br.com.lunacom.sapep.services.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/meta")
public class MetaResource {

    @Autowired
    private MetaService service;

    @RequestMapping(method= RequestMethod.POST)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Meta> insert(@Valid @RequestBody MetaDTO objDto) {
        Meta obj = service.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Meta>> findAll() {
        List<Meta> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Meta> find(@PathVariable Integer id) {
        Meta obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Void> update(@Valid @RequestBody MetaDTO objDto, @PathVariable Integer id) {
        objDto.setId(id);
        service.update(objDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/por-eixo/{id}", method=RequestMethod.GET)
    public ResponseEntity<List<Meta>> findDetailed(@PathVariable Integer id) {
        List<Meta> metas = service.findByEixo(id);
        return ResponseEntity.ok().body(metas);
    }

    @RequestMapping(value="/por-autoavaliacao/{id}", method=RequestMethod.GET)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<List<Meta>> findByAutoavaliacao(@PathVariable Integer id) {
        List<Meta> metas = service.findByAutoavaliacao(id);
        return ResponseEntity.ok().body(metas);
    }

    @RequestMapping(value="/por-status-global/{id}", method=RequestMethod.GET)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<HashMap<String, Integer>> findGlobalStatus(@PathVariable Integer id) {
        HashMap<String, Integer> metas = service.findGlobalStatus(id);
        return ResponseEntity.ok().body(metas);
    }

//    @RequestMapping(value="/por-status-individual/{id}", method=RequestMethod.GET)
//    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
//    public ResponseEntity<List<Meta>> findIndividualStatus(@PathVariable Integer id) {
//        List<Meta> metas = service.findIndividualStatus(id);
//        return ResponseEntity.ok().body(metas);
//    }


    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
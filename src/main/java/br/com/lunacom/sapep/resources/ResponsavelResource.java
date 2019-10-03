package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Responsavel;
import br.com.lunacom.sapep.domain.dto.ResponsavelNovoDTO;
import br.com.lunacom.sapep.services.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="/responsavel")
public class ResponsavelResource {

    @Autowired
    ResponsavelService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ResponsavelNovoDTO objDTO) {

        Responsavel obj = service.insert(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

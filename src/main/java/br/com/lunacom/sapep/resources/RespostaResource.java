package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Resposta;
import br.com.lunacom.sapep.domain.dto.RespostaDTO;
import br.com.lunacom.sapep.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/resposta")
public class RespostaResource {

    @Autowired
    private RespostaService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody RespostaDTO objDto) {
        Resposta obj = service.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Resposta>> findAll() {
        List<Resposta> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Resposta> find(@PathVariable Integer id) {
        Resposta obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/detalhado/{id}", method=RequestMethod.GET)
    public ResponseEntity<RespostaDTO> findDetailed(@PathVariable Integer id) {
        RespostaDTO objDto = service.findDetailed(id);
        return ResponseEntity.ok().body(objDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody RespostaDTO objDto, @PathVariable Integer id) {
        objDto.setId(id);
        service.update(objDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody List<RespostaDTO> objDtoList) {
        service.update(objDtoList);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

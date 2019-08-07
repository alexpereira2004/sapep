package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Autoavaliacao;
import br.com.lunacom.sapep.domain.dto.AutoavaliacaoDTO;
import br.com.lunacom.sapep.domain.dto.AutoavaliacaoNovoDTO;
import br.com.lunacom.sapep.services.AutoavaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/autoavaliacao")
public class AutoavaliacaoResource {

    @Autowired
    private AutoavaliacaoService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody AutoavaliacaoNovoDTO objDto) {
        Autoavaliacao obj = service.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Autoavaliacao>> findAll() {
        List<Autoavaliacao> list = service.findAll();
//        List<AutoavaliacaoDTO> listDTO = list
//                .stream()
//                .map(obj -> service.toDTO(obj))
//                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Autoavaliacao> find(@PathVariable Integer id) {
        Autoavaliacao obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody AutoavaliacaoDTO objDto, @PathVariable Integer id) {
        objDto.setId(id);
        service.update(objDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

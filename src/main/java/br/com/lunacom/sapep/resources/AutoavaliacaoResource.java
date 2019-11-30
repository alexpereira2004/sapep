package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Autoavaliacao;
import br.com.lunacom.sapep.domain.dto.AutoavaliacaoDTO;
import br.com.lunacom.sapep.domain.dto.AutoavaliacaoEdicaoDTO;
import br.com.lunacom.sapep.domain.dto.AutoavaliacaoNovoDTO;
import br.com.lunacom.sapep.domain.dto.AutoavaliacaoResumoDTO;
import br.com.lunacom.sapep.services.AutoavaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/autoavaliacao")
public class AutoavaliacaoResource {

    @Autowired
    private AutoavaliacaoService service;

    @RequestMapping(method= RequestMethod.POST)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Void> insert(@Valid @RequestBody AutoavaliacaoNovoDTO objDto) {
        Autoavaliacao obj = service.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<AutoavaliacaoResumoDTO>> findAll() {
        List<AutoavaliacaoResumoDTO> list = service.findAll();
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

    @RequestMapping(value="/detalhado/{id}", method=RequestMethod.GET)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<AutoavaliacaoDTO> findDetailed(@PathVariable Integer id) {
        AutoavaliacaoDTO objDto = service.findDetailed(id);
        return ResponseEntity.ok().body(objDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @PreAuthorize("hasAnyRole('PROPPI', 'COORDENADOR')")
    public ResponseEntity<Void> update(@Valid @RequestBody AutoavaliacaoEdicaoDTO objDto, @PathVariable Integer id) {
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

    @RequestMapping(value="/periodo/{id}", method=RequestMethod.GET)
    public ResponseEntity<List<Integer>> getPeriodo(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.getListaAnosDaAutoavaliacaoPorId(id));
    }
}

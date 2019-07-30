package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Conceito;
import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.dto.ConceitoNovoDTO;
import br.com.lunacom.sapep.repositories.CursoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ConceitoResource.class, CursoResource.class})
@EnableConfigurationProperties
public class TestConceitoResource {

//    @Autowired
//    ConceitoResource resource;
//
//    @Autowired
//    CursoResource cursoResource;

    @Test
    public void inserir() {
        ConceitoResource resource = new ConceitoResource();
        CursoResource cursoResource = new CursoResource();

        ResponseEntity<Curso> curso = cursoResource.find(5);

        ConceitoNovoDTO objDTO = new ConceitoNovoDTO();
        objDTO.setAno(2019);
        objDTO.setNota("B");

        assertEquals(resource.insert(objDTO), true);
    }
}

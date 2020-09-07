package br.com.lunacom.sapep.resources;

import br.com.lunacom.sapep.domain.Conceito;
import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.dto.ConceitoNovoDTO;
import br.com.lunacom.sapep.repositories.CursoRepository;
import br.com.lunacom.sapep.services.CursoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Date;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ConceitoResource.class, CursoResource.class})
@ActiveProfiles("test")
public class TestConceitoResource {

    @MockBean
    ConceitoResource resource;

    @MockBean
    CursoService cursoService;

    @Before
    public void setup() {
        Curso c1 = new Curso("Sistemas", "AT", new Date());
        cursoService.insert(c1);
    }

    @Test
    public void inserir() {
//        ConceitoResource resource = new ConceitoResource();
//        CursoResource cursoResource = new CursoResource();

        Curso curso = cursoService.find(1);

        ConceitoNovoDTO objDTO = new ConceitoNovoDTO();
        objDTO.setAno(2019);
        objDTO.setNota("B");

        assertEquals(true, resource.insert(objDTO));
    }

    @Test
    public void primeiro() {
        assertEquals("ok","ok");
    }
}

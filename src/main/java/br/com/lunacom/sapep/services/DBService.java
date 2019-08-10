package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CursoRepository cursoRepository;

    public void instantiateData() throws ParseException {
        Curso c1 = new Curso("Sistemas para Internet", "AT");
        cursoRepository.saveAll(Arrays.asList(c1));
    }
}
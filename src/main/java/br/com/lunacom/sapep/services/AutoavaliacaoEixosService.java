package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.AutoavaliacaoEixos;
import br.com.lunacom.sapep.repositories.AutoavaliacaoEixosRepository;
import br.com.lunacom.sapep.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutoavaliacaoEixosService {

    @Autowired
    private AutoavaliacaoEixosRepository repo;

    public AutoavaliacaoEixos find (Integer id) {
        Optional<AutoavaliacaoEixos> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada nenhuma autoavaliação"));
    }

}

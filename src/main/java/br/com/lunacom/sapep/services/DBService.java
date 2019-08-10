package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Autoavaliacao;
import br.com.lunacom.sapep.domain.Conceito;
import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.dto.ConceitoNovoDTO;
import br.com.lunacom.sapep.repositories.AutoavaliacaoRepository;
import br.com.lunacom.sapep.repositories.ConceitoRepository;
import br.com.lunacom.sapep.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ConceitoRepository conceitoRepository;

    @Autowired
    private AutoavaliacaoRepository autoavaliacaoRepository;

    public void instantiateData() throws ParseException {
        Curso c1 = new Curso("Sistemas para Internet", "AT");
        Curso c2 = new Curso("Especialização em Direito do Trabalho e Processo do Trabalho", "AT");
        Curso c3 = new Curso("Especialização em Cosmetologia Estética", "AT");
        Curso c4 = new Curso("MBA em Finanças Corporativas", "AT");
        Curso c5 = new Curso("Especialização em Governança em Tecnologia da Informação e Inovação", "AT");
        Curso c6 = new Curso("MBA em Psicologia Organizacional", "AT");
        cursoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

        Conceito ca1 = new Conceito(2014, "A", new Date(), c1);
        Conceito ca2 = new Conceito(2015, "B", new Date(), c1);
        Conceito ca3 = new Conceito(2016, "A", new Date(), c1);
        Conceito ca4 = new Conceito(2017, "C", new Date(), c1);
        Conceito ca5 = new Conceito(2018, "A", new Date(), c1);
        Conceito ca6 = new Conceito(2019, "A", new Date(), c1);
        Conceito cb1 = new Conceito(2017, "C", new Date(), c2);
        Conceito cb2 = new Conceito(2018, "A", new Date(), c2);
        Conceito cb3 = new Conceito(2019, "A", new Date(), c2);
        Conceito cc1 = new Conceito(2017, "C", new Date(), c3);
        Conceito cc2 = new Conceito(2018, "A", new Date(), c3);
        Conceito cc3 = new Conceito(2019, "A", new Date(), c3);

        conceitoRepository.saveAll(Arrays.asList(ca1, ca2, ca3, ca4, ca5, ca6,
                cb1, cb2, cb3, cc1, cc2, cc3));

//        Autoavaliacao aa1 = new Autoavaliacao(
//                "Autoavaliação e Planejamento período 2015/2018",
//                "Realizar planejamento do curso no período de 2015/2018",
//                "AT",
//                new Date("2015-01-01"),
//                new Date("2018-12-31"),
//                new Date(), c1);
//        Autoavaliacao aa2 = new Autoavaliacao(
//                "Autoavaliação e Planejamento período 2019/2022",
//                "Realizar planejamento do curso no período de 2019/2022",
//                "AT", new Date("2019-01-01"),new Date("2022-12-31"),new Date(), c1);
//        Autoavaliacao ab1 = new Autoavaliacao(
//                "Autoavaliação e Planejamento período 2019/2022",
//                "Realizar planejamento do curso no período de 2019/2022",
//                "AT", new Date("2019-01-01"),new Date("2022-12-31"),new Date(), c2);
//        Autoavaliacao ac1 = new Autoavaliacao(
//                "Autoavaliação e Planejamento período 2019/2022",
//                "Realizar planejamento do curso no período de 2019/2022",
//                "AT", new Date("2019-01-01"),new Date("2022-12-31"),new Date(), c3);
//        Autoavaliacao ad1 = new Autoavaliacao(
//                "Autoavaliação e Planejamento período 2019/2022",
//                "Realizar planejamento do curso no período de 2019/2022",
//                "AT", new Date("2019-01-01"),new Date("2022-12-31"),new Date(), c4);
//        Autoavaliacao ae1 = new Autoavaliacao(
//                "Autoavaliação e Planejamento período 2019/2022",
//                "Realizar planejamento do curso no período de 2019/2022",
//                "AT", new Date("2019-01-01"),new Date("2022-12-31"),new Date(), c5);
//        Autoavaliacao af1 = new Autoavaliacao(
//                "Autoavaliação e Planejamento período 2019/2022",
//                "Realizar planejamento do curso no período de 2019/2022",
//                "AT", new Date("2019-01-01"),new Date("2022-12-31"),new Date(), c6);

//        autoavaliacaoRepository.saveAll(Arrays.asList(aa1,aa2, ab1, ac1, ad1, ae1, af1));


    }
}
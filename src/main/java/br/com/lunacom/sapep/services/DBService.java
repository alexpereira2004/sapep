package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.Autoavaliacao;
import br.com.lunacom.sapep.domain.Conceito;
import br.com.lunacom.sapep.domain.Curso;
import br.com.lunacom.sapep.domain.Eixo;
import br.com.lunacom.sapep.domain.dto.ConceitoNovoDTO;
import br.com.lunacom.sapep.repositories.AutoavaliacaoRepository;
import br.com.lunacom.sapep.repositories.ConceitoRepository;
import br.com.lunacom.sapep.repositories.CursoRepository;
import br.com.lunacom.sapep.repositories.EixoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class DBService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ConceitoRepository conceitoRepository;

    @Autowired
    private AutoavaliacaoRepository autoavaliacaoRepository;

    @Autowired
    private EixoRepository eixoRepository;

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

        Date dtIniPassado = new GregorianCalendar(2011, Calendar.JANUARY, 01).getTime();
        Date dtFimPassado = new GregorianCalendar(2014, Calendar.DECEMBER, 31).getTime();
        Date dtIni = new GregorianCalendar(2015, Calendar.JANUARY, 01).getTime();
        Date dtFim = new GregorianCalendar(2019, Calendar.DECEMBER, 31).getTime();

        Autoavaliacao aa1 = new Autoavaliacao(
                "Autoavaliação e Planejamento período 2015/2018",
                "Realizar planejamento do curso no período de 2015/2018",
                "IN", dtIniPassado, dtFimPassado, new Date(), c1);
        Autoavaliacao aa2 = new Autoavaliacao(
                "Autoavaliação e Planejamento período 2019/2022",
                "Realizar planejamento do curso no período de 2019/2022",
                "AT", dtIni, dtFim, new Date(), c1);
        Autoavaliacao ab1 = new Autoavaliacao(
                "Autoavaliação e Planejamento período 2019/2022",
                "Realizar planejamento do curso no período de 2019/2022",
                "AT", dtIni, dtFim, new Date(), c2);
        Autoavaliacao ac1 = new Autoavaliacao(
                "Autoavaliação e Planejamento período 2019/2022",
                "Realizar planejamento do curso no período de 2019/2022",
                "AT", dtIni, dtFim, new Date(), c3);
        Autoavaliacao ad1 = new Autoavaliacao(
                "Autoavaliação e Planejamento período 2019/2022",
                "Realizar planejamento do curso no período de 2019/2022",
                "AT", dtIni, dtFim, new Date(), c4);
        Autoavaliacao ae1 = new Autoavaliacao(
                "Autoavaliação e Planejamento período 2019/2022",
                "Realizar planejamento do curso no período de 2019/2022",
                "AT", dtIni, dtFim, new Date(), c5);
        Autoavaliacao af1 = new Autoavaliacao(
                "Autoavaliação e Planejamento período 2019/2022",
                "Realizar planejamento do curso no período de 2019/2022",
                "AT", dtIni, dtFim, new Date(), c6);

        autoavaliacaoRepository.saveAll(Arrays.asList(aa1,aa2, ab1, ac1, ad1, ae1, af1));

        Eixo ea1 = new Eixo("Eixo 1", "Trabalhos Externos", 3, new Date(), aa1);
        Eixo ea2 = new Eixo("Eixo 2", "Envolvimento Professores", 1, new Date(), aa1);
        Eixo ea3 = new Eixo("Eixo 3", "Envolvimento Alunos", 2, new Date(), aa1);
        Eixo ea4 = new Eixo("Eixo 1", "Proposta do Programa", 1, new Date(), aa2);
        Eixo ea5 = new Eixo("Eixo 2", "Corpo Docente", 2, new Date(), aa2);
        Eixo ea6 = new Eixo("Eixo 3", "Atividades de Pesquisa", 3, new Date(), aa2);
        Eixo ea7 = new Eixo("Eixo 4", "Produção Intelectual", 4, new Date(), aa2);
        Eixo ea8 = new Eixo("Eixo 5", "Atividades de Formação", 5, new Date(), aa2);
        Eixo ea9 = new Eixo("Eixo 6", "Destino dos Mestres Egressos", 6, new Date(), aa2);
        Eixo ea10 = new Eixo("Eixo 7", "Análise do Ambiente Interno", 7, new Date(), aa2);
        Eixo ea11 = new Eixo("Eixo 8", "Infraestrutura", 8, new Date(), aa2);
        eixoRepository.saveAll(Arrays.asList(ea1,ea2,ea3,ea4,ea5,ea6,ea7,ea8,ea9,ea10,ea11));

        Eixo eb1 = new Eixo("Eixo 1", "Proposta do Programa", 1, new Date(), ab1);
        Eixo eb2 = new Eixo("Eixo 2", "Corpo Docente", 2, new Date(), ab1);
        Eixo eb3 = new Eixo("Eixo 3", "Atividades de Pesquisa", 3, new Date(), ab1);
        Eixo eb4 = new Eixo("Eixo 4", "Produção Intelectual", 4, new Date(), ab1);
        Eixo eb5 = new Eixo("Eixo 5", "Atividades de Formação", 5, new Date(), ab1);
        Eixo eb6 = new Eixo("Eixo 6", "Destino dos Mestres Egressos", 6, new Date(), ab1);
        Eixo eb7 = new Eixo("Eixo 7", "Análise do Ambiente Interno", 7, new Date(), ab1);
        Eixo eb8 = new Eixo("Eixo 8", "Infraestrutura", 8, new Date(), ab1);
        eixoRepository.saveAll(Arrays.asList(eb1,eb2,eb3,eb4,eb5,eb6,eb7,eb8));

        Eixo ec1 = new Eixo("Eixo 1", "Proposta do Programa", 1, new Date(), ac1);
        Eixo ec7 = new Eixo("Eixo 7", "Análise do Ambiente Interno", 7, new Date(), ac1);
        Eixo ec4 = new Eixo("Eixo 4", "Produção Intelectual", 4, new Date(), ac1);
        Eixo ec8 = new Eixo("Eixo 8", "Infraestrutura", 8, new Date(), ac1);
        Eixo ec5 = new Eixo("Eixo 5", "Atividades de Formação", 5, new Date(), ac1);
        Eixo ec2 = new Eixo("Eixo 2", "Corpo Docente", 2, new Date(), ac1);
        Eixo ec3 = new Eixo("Eixo 3", "Atividades de Pesquisa", 3, new Date(), ac1);
        Eixo ec6 = new Eixo("Eixo 6", "Destino dos Mestres Egressos", 6, new Date(), ac1);
        eixoRepository.saveAll(Arrays.asList(ec5,ec7,ec6,ec4,ec1,ec2,ec8,ec3));

    }
}
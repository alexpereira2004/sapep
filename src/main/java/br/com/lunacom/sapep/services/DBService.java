package br.com.lunacom.sapep.services;

import br.com.lunacom.sapep.domain.*;
import br.com.lunacom.sapep.domain.dto.ConceitoNovoDTO;
import br.com.lunacom.sapep.domain.enums.Perfil;
import br.com.lunacom.sapep.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

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

    @Autowired
    private IndicadorRepository indicadorRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public void instantiateData() throws ParseException {
        Usuario u1 = new Usuario("Alex L", "alex@gmail.com", "123456", "AT");
        u1.addPerfil(Perfil.ADMINISTRADOR);

        Usuario u2 = new Usuario("Silvia B", "silvia@gmail.com", "123456", "AT");
        u2.addPerfil(Perfil.ADMINISTRADOR);
        u2.addPerfil(Perfil.COORDENADOR);

        Usuario u3 = new Usuario("Evandro M", "evandro@gmail.com", "123456", "AT");
        u3.addPerfil(Perfil.COORDENADOR);

        Usuario u4 = new Usuario("Maria M", "maria@gmail.com", "123456", "AT");
        u4.addPerfil(Perfil.PROPPI);

        Usuario u5 = new Usuario("Pedro F", "pedro@gmail.com", "123456", "AT");
        u5.addPerfil(Perfil.PROPPI);


        usuarioService.insert(u1);
        usuarioService.insert(u2);
        usuarioService.insert(u3);
        usuarioService.insert(u4);
        usuarioService.insert(u5);

        Curso c1 = new Curso("Mestrado Profissional em Educação Profissional e Tecnológica (ProfEPT)", "AT", new Date());
        Curso c2 = new Curso("Mestrado Profissional em Informática na Educação (MPIE)", "AT", new Date());
        Curso c3 = new Curso("Mestrado Profissional em Propriedade Intelectual e Transferência de Tecnologia para a Inovação (ProfNit)", "AT", new Date());
//        Curso c4 = new Curso("MBA em Finanças Corporativas", "AT", new Date());
//        Curso c5 = new Curso("Especialização em Governança em Tecnologia da Informação e Inovação", "AT", new Date());
//        Curso c6 = new Curso("MBA em Psicologia Organizacional", "AT", new Date());
        cursoRepository.saveAll(Arrays.asList(c1, c2, c3));
//        cursoRepository.saveAll(Arrays.asList(c4, c5, c6));

        Conceito ca1 = new Conceito(2014, "5", new Date(), c1);
        Conceito ca2 = new Conceito(2015, "4", new Date(), c1);
        Conceito ca3 = new Conceito(2016, "3", new Date(), c1);
        Conceito ca4 = new Conceito(2017, "4", new Date(), c1);
        Conceito ca5 = new Conceito(2018, "5", new Date(), c1);
        Conceito ca6 = new Conceito(2019, "5", new Date(), c1);
        Conceito cb1 = new Conceito(2017, "4", new Date(), c2);
        Conceito cb2 = new Conceito(2018, "3", new Date(), c2);
        Conceito cb3 = new Conceito(2019, "3", new Date(), c2);
        Conceito cc1 = new Conceito(2017, "4", new Date(), c3);
        Conceito cc2 = new Conceito(2018, "5", new Date(), c3);
        Conceito cc3 = new Conceito(2019, "5", new Date(), c3);

        conceitoRepository.saveAll(Arrays.asList(ca1, ca2, ca3, ca4, ca5, ca6,
                cb1, cb2, cb3, cc1, cc2, cc3));

        Date dtIniPassado = new GregorianCalendar(2011, Calendar.JANUARY, 01).getTime();
        Date dtFimPassado = new GregorianCalendar(2014, Calendar.DECEMBER, 31).getTime();
        Date dtIni = new GregorianCalendar(2015, Calendar.JANUARY, 01).getTime();
        Date dtFim = new GregorianCalendar(2019, Calendar.DECEMBER, 31).getTime();

        Autoavaliacao aa1 = new Autoavaliacao(
                "Planejamento período 2015/2018",
                "Realizar planejamento do curso no período de 2015/2018",
                "IN", dtIniPassado, dtFimPassado, new Date(), c1);
        Autoavaliacao aa2 = new Autoavaliacao(
                "Autoavaliação do curso Quadriênio 2019/2022",
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
//        Autoavaliacao ad1 = new Autoavaliacao(
//                "Autoavaliação e Planejamento período 2019/2022",
//                "Realizar planejamento do curso no período de 2019/2022",
//                "AT", dtIni, dtFim, new Date(), c4);
//        Autoavaliacao ae1 = new Autoavaliacao(
//                "Autoavaliação e Planejamento período 2019/2022",
//                "Realizar planejamento do curso no período de 2019/2022",
//                "AT", dtIni, dtFim, new Date(), c5);
//        Autoavaliacao af1 = new Autoavaliacao(
//                "Autoavaliação e Planejamento período 2019/2022",
//                "Realizar planejamento do curso no período de 2019/2022",
//                "AT", dtIni, dtFim, new Date(), c6);

        autoavaliacaoRepository.saveAll(Arrays.asList(aa1,aa2, ab1, ac1));
//        autoavaliacaoRepository.saveAll(Arrays.asList(ad1, ae1, af1));

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

        Indicador idc1 = new Indicador("Relato breve das condições disponíveis",
                null, 1, "QD", "TX", ea11);
        Indicador idc2 = new Indicador("Houve alterações relevantes de infraestrutura nos últimos 2 anos?",
                null, 2, "QD", "CH", ea11);
        Indicador idc3 = new Indicador("Pontos fortes",
                null, 3, "QD","TX", ea11);
        Indicador idc4 = new Indicador("Pontos fracos",
                null, 3, "QD","TX", ea11);
        Indicador idc5 = new Indicador("Meta",
                1, 1, "ML","TX", ea11);
        Indicador idc6 = new Indicador("Viabilidade",
                1, 2, "ML","TX", ea11);
        Indicador idc7 = new Indicador("Ameaças Internas",
                1, 3, "ML","TX", ea11);
        Indicador idc8 = new Indicador("Ameaças Externas",
                1, 4, "ML","TX", ea11);
        Indicador idc9 = new Indicador("Prioridade",
                1, 4, "ML","TX", ea11);

        indicadorRepository.saveAll(Arrays.asList(idc1, idc2, idc3, idc4, idc5, idc6, idc7, idc8, idc9));

        Resposta resp1 = new Resposta(null, "As condições eram ruins, goteiras nas salas de aula, máquinas com limite de memória, dentre outras dificuldades", 0.00f, idc1);
        Resposta resp2 = new Resposta(null, "Não e os investimentos cairam cerca de 90%", 0.00f, idc2);
        Resposta resp3 = new Resposta(null, "Existe uma equipe de manutenção que consegue realizar diversas manutenções", 0.00f, idc3);
        Resposta resp4 = new Resposta(null, "Falta de peças para reposição, demora na compra de novos itens", 0.00f, idc4);

        Resposta resp5 = new Resposta(null, "Nova rede wireless", 0.00f, idc5);
        Resposta resp6 = new Resposta(null, "Aquisição de sotware", 0.00f, idc5);
        Resposta resp7 = new Resposta(null, "Aumento do espaço físico", 0.00f, idc5);

        Resposta resp8 = new Resposta(null, "Grande possibilidade", 0.00f, idc6);
        Resposta resp9 = new Resposta(null, "Melhor pensar em Open source", 0.00f, idc6);
        Resposta resp10 = new Resposta(null, "Possível, temos áreas livres para uso", 0.00f, idc6);

        Resposta resp11 = new Resposta(null, "N/a", 0.00f, idc7);
        Resposta resp12 = new Resposta(null, "Falta cultura para aquisição de software proprietário", 0.00f, idc7);
        Resposta resp13 = new Resposta(null, "Salas pequenas", 0.00f, idc7);

        Resposta resp14 = new Resposta(null, "N/a", 0.00f, idc8);
        Resposta resp15 = new Resposta(null, "Preço do dólar", 0.00f, idc8);
        Resposta resp16 = new Resposta(null, "N/a", 0.00f, idc8);

        Resposta resp17 = new Resposta(null, "5", 0.00f, idc9);
        Resposta resp18 = new Resposta(null, "3", 0.00f, idc9);
        Resposta resp19 = new Resposta(null, "2", 0.00f, idc9);

        respostaRepository.saveAll(Arrays.asList(
                resp1, resp2, resp3, resp4,
                resp5, resp8, resp11, resp14, resp17,
                resp6, resp9, resp12, resp15, resp18,
                resp7, resp10, resp13, resp16, resp19
        ));
    }
}
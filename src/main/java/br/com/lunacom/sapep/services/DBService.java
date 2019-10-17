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

        // Perguntas do Curso 1 - Eixo 8
        Indicador idc1 = new Indicador("Relato breve das condições disponíveis",
                1, 1, "QD", "TX", ea11);
        Indicador idc2 = new Indicador("Houve alterações relevantes de infraestrutura nos últimos 2 anos?",
                2, 1, "QD", "CH", ea11);
        Indicador idc3 = new Indicador("Pontos fortes",
                3, 1, "QD","TX", ea11);
        Indicador idc4 = new Indicador("Pontos fracos",
                4, 1, "QD","TX", ea11);
        Indicador idc5 = new Indicador("Meta",
                5, 1, "ML","TX", ea11);
        Indicador idc6 = new Indicador("Viabilidade",
                5, 2, "ML","TX", ea11);
        Indicador idc7 = new Indicador("Ameaças Internas",
                5, 3, "ML","TX", ea11);
        Indicador idc8 = new Indicador("Ameaças Externas",
                5, 4, "ML","TX", ea11);
        Indicador idc9 = new Indicador("Prioridade",
                5, 4, "ML","TX", ea11);
        indicadorRepository.saveAll(Arrays.asList(idc1, idc2, idc3, idc4, idc5, idc6, idc7, idc8, idc9));

        // Perguntas do Curso 1 - Eixo 1
        Indicador idc10 = new Indicador("Objetivos do Programa",1, 1, "QD","TA", ea4);
        Indicador idc11 = new Indicador("Meta",2, 1, "ML","TA", ea4);
        Indicador idc12 = new Indicador("Viabilidade",2, 2, "ML","TA", ea4);
        Indicador idc13 = new Indicador("Ameaças Internas",2, 3, "ML","TA", ea4);
        Indicador idc14 = new Indicador("Ameaças Externas",2, 4, "ML","TA", ea4);
        Indicador idc15 = new Indicador("Prioridade (de 1 a 5)",2, 5, "ML","NU", ea4);
        indicadorRepository.saveAll(Arrays.asList(idc10, idc11, idc12, idc13, idc14, idc15));

        // Perguntas do Curso 1 - Eixo 2
        Indicador idc16 = new Indicador("Número de Professores Permanentes",1, 1, "AN","NU", ea5);
        Indicador idc17 = new Indicador("Número de Professores Colaboradores ",2, 1, "AN","NU", ea5);
        Indicador idc18 = new Indicador("Número de Professores com Bolsa de Produtividade em Pesquisa do CNPq",3, 1, "AN","NU", ea5);
        Indicador idc19 = new Indicador("Pontos fortes",4, 1, "AN","TA", ea5);
        Indicador idc20 = new Indicador("Pontos fracos",5, 1, "AN","TA", ea5);
        Indicador idc21 = new Indicador("Meta",6, 1, "ML","TA", ea5);
        Indicador idc22 = new Indicador("Viabilidade",6, 2, "ML","TA", ea5);
        Indicador idc23 = new Indicador("Ameaças Internas",6, 3, "ML","TA", ea5);
        Indicador idc24 = new Indicador("Ameaças Externas",6, 4, "ML","TA", ea5);
        Indicador idc25 = new Indicador("Prioridade (de 1 a 5)",6, 5, "ML","NU", ea5);
        indicadorRepository.saveAll(Arrays.asList(idc16,idc17,idc18,idc19,idc20,idc21,idc22,idc23,idc24,idc25));

        // Perguntas do Curso 1 - Eixo 3
        Indicador idc26 = new Indicador("Número de Linhas de pesquisa do programa",1, 1, "AN","NU", ea6);
        Indicador idc27 = new Indicador("Número de Projetos de Pesquisa",2, 1, "AN","NU", ea6);
        Indicador idc28 = new Indicador("Pontos fortes",3, 1, "AN","TA", ea6);
        Indicador idc29 = new Indicador("Pontos fracos",4, 1, "AN","TA", ea6);
        Indicador idc30 = new Indicador("Meta",5, 1, "ML","TA", ea6);
        Indicador idc31 = new Indicador("Viabilidade",5, 2, "ML","TA", ea6);
        Indicador idc32 = new Indicador("Ameaças Internas",5, 3, "ML","TA", ea6);
        Indicador idc33 = new Indicador("Ameaças Externas",5, 4, "ML","TA", ea6);
        Indicador idc34 = new Indicador("Prioridade (de 1 a 5)",5, 5, "ML","NU", ea6);
        indicadorRepository.saveAll(Arrays.asList(idc26,idc27,idc28,idc29,idc30,idc31,idc32,idc33,idc34));

        // Perguntas do Curso 1 - Eixo 4
        Indicador idc35 = new Indicador("Trabalhos completos em periódicos",1, 1, "AN","NU", ea7);
        Indicador idc36 = new Indicador("Trabalhos completos em periódicos com autores discentes",1, 2, "AN","NU", ea7);
        Indicador idc37 = new Indicador("Anais Completos",1, 3, "AN","NU", ea7);
        Indicador idc38 = new Indicador("Produção Artística",1, 4, "AN","NU", ea7);
        Indicador idc39 = new Indicador("Produção Técnica",1, 5, "AN","NU", ea7);
        Indicador idc40 = new Indicador("Livro",1, 6, "AN","NU", ea7);
        Indicador idc41 = new Indicador("Capítulo de Livro",1, 7, "AN","NU", ea7);
        Indicador idc42 = new Indicador("Solicitação de Depósito de Patente",1, 8, "AN","NU", ea7);
        Indicador idc43 = new Indicador("Produto Educacional",1, 9, "AN","NU", ea7);
        Indicador idc44 = new Indicador("Relação percentual existente entre o número de dissertações e trabalhos publicados em periódicos com a participação de discentes",2, 1, "AN","TA", ea7);
        Indicador idc45 = new Indicador("Pontos fortes",3, 1, "AN","TA", ea7);
        Indicador idc46 = new Indicador("Pontos fracos",4, 1, "AN","TA", ea7);
        Indicador idc47 = new Indicador("Meta",5, 1, "ML","TA", ea7);
        Indicador idc48 = new Indicador("Viabilidade",5, 2, "ML","TA", ea7);
        Indicador idc49 = new Indicador("Ameaças Internas",5, 3, "ML","TA", ea7);
        Indicador idc50 = new Indicador("Ameaças Externas",5, 4, "ML","TA", ea7);
        Indicador idc51 = new Indicador("Prioridade (de 1 a 5)",5, 5, "ML","NU", ea7);
        indicadorRepository.saveAll(Arrays.asList(idc35,idc36,idc37,idc38,idc39,idc40,idc41,idc42,idc43,idc44,idc45,idc46,idc47,idc48,idc49,idc50,idc51));

        // Perguntas do Curso 1 - Eixo 5
        Indicador idc52 = new Indicador("Número de candidatos inscritos para seleção",1, 1, "AN","NU", ea8);
        Indicador idc53 = new Indicador("Número de discentes com matrícula regular (total)",1, 2, "AN","NU", ea8);
        Indicador idc54 = new Indicador("Número de discentes com matrícula especial (total)",1, 3, "AN","NU", ea8);
        Indicador idc55 = new Indicador("Número de discentes titulados",1, 4, "AN","NU", ea8);
        Indicador idc56 = new Indicador("Pontos fortes",2, 1, "AN","TA", ea8);
        Indicador idc57 = new Indicador("Pontos fracos",3, 1, "AN","TA", ea8);
        Indicador idc58 = new Indicador("Meta",4, 1, "ML","TA", ea8);
        Indicador idc59 = new Indicador("Viabilidade",4, 2, "ML","TA", ea8);
        Indicador idc60 = new Indicador("Ameaças Internas",4, 3, "ML","TA", ea8);
        Indicador idc61 = new Indicador("Ameaças Externas",4, 4, "ML","TA", ea8);
        Indicador idc62 = new Indicador("Prioridade (de 1 a 5)",4, 5, "ML","NU", ea8);
        indicadorRepository.saveAll(Arrays.asList(idc52,idc53,idc54,idc55,idc56,idc57,idc58,idc59,idc60,idc61,idc62));

        // Perguntas do Curso 1 - Eixo 6
        Indicador idc63 = new Indicador("Total de egressos",1, 1, "AN","TX", ea9);
        Indicador idc64 = new Indicador("Informar demais destinos relevantes dos egressos",2, 1, "AN","TA", ea9);
        indicadorRepository.saveAll(Arrays.asList(idc63, idc64));

        // Perguntas do Curso 1 - Eixo 7
        Indicador idc65 = new Indicador("Pontos fortes",1, 1, "AN","TA", ea10);
        Indicador idc66 = new Indicador("Pontos fracos",2, 1, "AN","TA", ea10);
        indicadorRepository.saveAll(Arrays.asList(idc65, idc66));

        // Respostas
        Resposta resp1 = new Resposta(null, "As condições eram ruins, goteiras nas salas de aula, máquinas com limite de memória, dentre outras dificuldades", 0.00f, idc1);
        Resposta resp2 = new Resposta(null, "Não e os investimentos cairam cerca de 90%", 0.00f, idc2);
        Resposta resp3 = new Resposta(null, "Existe uma equipe de manutenção que consegue realizar diversas manutenções", 0.00f, idc3);
        Resposta resp4 = new Resposta(null, "Falta de peças para reposição, demora na compra de novos itens", 0.00f, idc4);

        Resposta resp5 = new Resposta(null, "Nova rede wireless", 0.00f, idc5);
        Resposta resp8 = new Resposta(null, "Grande possibilidade", 0.00f, idc6);
        Resposta resp11 = new Resposta(null, "N/a", 0.00f, idc7);
        Resposta resp14 = new Resposta(null, "N/a", 0.00f, idc8);
        Resposta resp17 = new Resposta(null, "5", 0.00f, idc9);

        Resposta resp6 = new Resposta(null, "Aquisição de sotware", 0.00f, idc5);
        Resposta resp9 = new Resposta(null, "Melhor pensar em Open source", 0.00f, idc6);
        Resposta resp12 = new Resposta(null, "Falta cultura para aquisição de software proprietário", 0.00f, idc7);
        Resposta resp15 = new Resposta(null, "Preço do dólar", 0.00f, idc8);
        Resposta resp18 = new Resposta(null, "3", 0.00f, idc9);

        Resposta resp7 = new Resposta(null, "Aumento do espaço físico", 0.00f, idc5);
        Resposta resp10 = new Resposta(null, "Possível, temos áreas livres para uso", 0.00f, idc6);
        Resposta resp13 = new Resposta(null, "Salas pequenas", 0.00f, idc7);
        Resposta resp16 = new Resposta(null, "N/a", 0.00f, idc8);
        Resposta resp19 = new Resposta(null, "2", 0.00f, idc9);

        respostaRepository.saveAll(Arrays.asList(
                resp1, resp2, resp3, resp4,
                resp5, resp8, resp11, resp14, resp17,
                resp6, resp9, resp12, resp15, resp18,
                resp7, resp10, resp13, resp16, resp19
        ));
    }
}
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
import java.util.stream.Collectors;

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

    @Autowired
    private ResponsavelRepository responsavelRepository;

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

        Usuario u6 = new Usuario("Clarice Monteiro Escott", "clarice@gmail.com", "123456", "AT");
        u3.addPerfil(Perfil.COORDENADOR);

        Usuario u7 = new Usuario("Cristina M. Quintella", "cristina@gmail.com", "123456", "AT");
        u3.addPerfil(Perfil.COORDENADOR);


        usuarioService.insert(u1);
        usuarioService.insert(u2);
        usuarioService.insert(u3);
        usuarioService.insert(u4);
        usuarioService.insert(u5);
        usuarioService.insert(u6);
        usuarioService.insert(u7);


        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Mestrado Profissional em Educação Profissional e Tecnológica (ProfEPT)", "AT", new Date()));
        cursos.add(new Curso("Mestrado Profissional em Informática na Educação (MPIE)", "AT", new Date()));
        cursos.add(new Curso("Mestrado Profissional em Propriedade Intelectual e Transferência de Tecnologia para a Inovação (ProfNit)", "AT", new Date()));
        cursos.add(new Curso("Alimentação, Nutrição e Saúde", "AT", new Date()));
        cursos.add(new Curso("Antropologia Social", "AT", new Date()));
        cursos.add(new Curso("Arquitetura", "AT", new Date()));
        cursos.add(new Curso("Artes Cênicas", "AT", new Date()));
        cursos.add(new Curso("Artes Visuais", "AT", new Date()));
        cursos.add(new Curso("Assistência Farmacêutica", "AT", new Date()));
        cursos.add(new Curso("Biologia Animal", "AT", new Date()));
        cursos.add(new Curso("Biologia Celular e Molecular", "AT", new Date()));
        cursos.add(new Curso("Bioquímica", "AT", new Date()));
        cursos.add(new Curso("Botânica", "AT", new Date()));
        cursos.add(new Curso("Cardiologia e Ciências Cardiovasculares", "AT", new Date()));
        cursos.add(new Curso("Cirurgia", "AT", new Date()));
        cursos.add(new Curso("Ciência Política", "AT", new Date()));
        cursos.add(new Curso("Ciência da Informação", "AT", new Date()));
        cursos.add(new Curso("Ciência do Solo", "AT", new Date()));
        cursos.add(new Curso("Ciência dos Materiais", "AT", new Date()));
        cursos.add(new Curso("Ciência e Tecnologia de Alimentos", "AT", new Date()));
        cursos.add(new Curso("Ciências Biológicas: Farmacologia e Terapêutica", "AT", new Date()));
        cursos.add(new Curso("Ciências Farmacêuticas", "AT", new Date()));
        cursos.add(new Curso("Ciências Médicas", "AT", new Date()));
        cursos.add(new Curso("Ciências Veterinárias", "AT", new Date()));
        cursos.add(new Curso("Ciências da Saúde: Ginecologia e Obstetrícia", "AT", new Date()));
        cursos.add(new Curso("Ciências do Movimento Humano", "AT", new Date()));
        cursos.add(new Curso("Ciências do Movimento Humano Interinstitucional", "AT", new Date()));
        cursos.add(new Curso("Ciências em Gastroenterologia", "AT", new Date()));
        cursos.add(new Curso("Computação", "AT", new Date()));
        cursos.add(new Curso("Comunicação", "AT", new Date()));
        cursos.add(new Curso("Comunicação e Informação", "AT", new Date()));
        cursos.add(new Curso("Controladoria e Contabilidade", "AT", new Date()));
        cursos.add(new Curso("Desenvolvimento Rural", "AT", new Date()));
        cursos.add(new Curso("Design", "AT", new Date()));
        cursos.add(new Curso("Dinâmicas Regionais e Desenvolvimento", "AT", new Date()));
        cursos.add(new Curso("Direito", "AT", new Date()));
        cursos.add(new Curso("Ecologia", "AT", new Date()));
        cursos.add(new Curso("Economia", "AT", new Date()));
        cursos.add(new Curso("Educação", "AT", new Date()));
        cursos.add(new Curso("Endocrinologia", "AT", new Date()));
        cursos.add(new Curso("Enfermagem", "AT", new Date()));
        cursos.add(new Curso("Engenharia Civil", "AT", new Date()));
        cursos.add(new Curso("Engenharia Civil Interinstitucional", "AT", new Date()));
        cursos.add(new Curso("Engenharia Civil: Construção e Infraestrutura", "AT", new Date()));
        cursos.add(new Curso("Engenharia Elétrica", "AT", new Date()));
        cursos.add(new Curso("Engenharia Mecânica", "AT", new Date()));
        cursos.add(new Curso("Engenharia Química", "AT", new Date()));
        cursos.add(new Curso("Engenharia de Minas, Metalúrgica e de Materiais", "AT", new Date()));
        cursos.add(new Curso("Engenharia de Produção", "AT", new Date()));
        cursos.add(new Curso("Ensino de Física", "AT", new Date()));
        cursos.add(new Curso("Ensino de Matemática", "AT", new Date()));
        cursos.add(new Curso("Epidemiologia", "AT", new Date()));
        cursos.add(new Curso("Estatística", "AT", new Date()));
        cursos.add(new Curso("Estudos Estratégicos Internacionais", "AT", new Date()));
        cursos.add(new Curso("Filosofia", "AT", new Date()));
        cursos.add(new Curso("Fisiologia", "AT", new Date()));
        cursos.add(new Curso("Fitotecnia", "AT", new Date()));
        cursos.add(new Curso("Física", "AT", new Date()));
        cursos.add(new Curso("Genética e Biologia Molecular", "AT", new Date()));
        cursos.add(new Curso("Geociências", "AT", new Date()));
        cursos.add(new Curso("Geografia", "AT", new Date()));
        cursos.add(new Curso("História", "AT", new Date()));
        cursos.add(new Curso("Letras", "AT", new Date()));
        cursos.add(new Curso("Letras Interinstitucional", "AT", new Date()));
        cursos.add(new Curso("Matemática", "AT", new Date()));
        cursos.add(new Curso("Matemática Aplicada", "AT", new Date()));
        cursos.add(new Curso("Medicina Animal: Equinos", "AT", new Date()));
        cursos.add(new Curso("Microbiologia Agrícola e do Ambiente", "AT", new Date()));
        cursos.add(new Curso("Microeletronica", "AT", new Date()));
        cursos.add(new Curso("Museologia e Patrimônio", "AT", new Date()));
        cursos.add(new Curso("Música", "AT", new Date()));
        cursos.add(new Curso("Neurociências", "AT", new Date()));
        cursos.add(new Curso("Odontologia", "AT", new Date()));
        cursos.add(new Curso("Planejamento Urbano e Regional", "AT", new Date()));
        cursos.add(new Curso("Planejamento Urbano e Regional Interinstitucional", "AT", new Date()));
        cursos.add(new Curso("Pneumologia", "AT", new Date()));
        cursos.add(new Curso("Política Social e Serviço Social", "AT", new Date()));
        cursos.add(new Curso("Políticas Públicas", "AT", new Date()));
        cursos.add(new Curso("Psicanálise: Clínica e Cultura", "AT", new Date()));
        cursos.add(new Curso("Psicologia", "AT", new Date()));
        cursos.add(new Curso("Psicologia Social e Institucional", "AT", new Date()));
        cursos.add(new Curso("Psiquiatria", "AT", new Date()));
        cursos.add(new Curso("Química", "AT", new Date()));
        cursos.add(new Curso("Química da Vida e Saúde - Associação de Ies", "AT", new Date()));
        cursos.add(new Curso("Recursos Hídricos e Saneamento Ambiental", "AT", new Date()));
        cursos.add(new Curso("Recursos Hídricos e Saneamento Ambiental Interinstitucional", "AT", new Date()));
        cursos.add(new Curso("Saúde Coletiva", "AT", new Date()));
        cursos.add(new Curso("Saúde da Criança e do Adolescente", "AT", new Date()));
        cursos.add(new Curso("Sensoriamento Remoto", "AT", new Date()));
        cursos.add(new Curso("Sociologia", "AT", new Date()));


        cursoRepository.saveAll(cursos);

        Curso c1 = cursos.get(1);
        Curso c2 = cursos.get(2);
        Curso c3 = cursos.get(3);
        Curso c4 = cursos.get(50);
        Responsavel r1 = new Responsavel(c1, u6);
        Responsavel r2 = new Responsavel(c2, u2);
        Responsavel r2a = new Responsavel(c4, u2);
        Responsavel r3 = new Responsavel(c2, u3);
        Responsavel r4 = new Responsavel(c3, u7);
        responsavelRepository.saveAll(Arrays.asList(r1, r2, r2a, r3, r4));

        c1.setResponsaveis(Arrays.asList(r1));
        c2.setResponsaveis(Arrays.asList(r2, r3));
        c3.setResponsaveis(Arrays.asList(r4));
        cursoRepository.saveAll(Arrays.asList(c1, c2, c3));

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
        List<Indicador> indicadores = new ArrayList<>();
        indicadores.add(new Indicador("Relato breve das condições disponíveis", 1, 1, "RE", "TX", ea11));
        indicadores.add(new Indicador("Houve alterações relevantes de infraestrutura nos últimos 2 anos?", 2, 1, "RE", "CH", ea11));
        indicadores.add(new Indicador("Pontos fortes", 3, 1, "RE","TX", ea11));
        indicadores.add(new Indicador("Pontos fracos", 4, 1, "RE","TX", ea11));
        indicadores.add(new Indicador("Meta", 5, 1, "ML","TX", ea11));
        indicadores.add(new Indicador("Viabilidade", 5, 2, "ML","TX", ea11));
        indicadores.add(new Indicador("Ameaças Internas", 5, 3, "ML","TX", ea11));
        indicadores.add(new Indicador("Ameaças Externas", 5, 4, "ML","TX", ea11));
        indicadores.add(new Indicador("Prioridade", 5, 4, "ML","TX", ea11));
        indicadores.add(new Indicador("Prioridade", 5, 4, "ML","TX", ea11));


        // Perguntas do Curso 1 - Eixo 1
        indicadores.add(new Indicador("Objetivos do Programa",1, 1, "AN","TA", ea4));


        // Perguntas do Curso 1 - Eixo 2
        indicadores.add(new Indicador("Número de Professores Permanentes",1, 1, "RE","NU", ea5));
        indicadores.add(new Indicador("Número de Professores Colaboradores ",1, 2, "RE","NU", ea5));
        indicadores.add(new Indicador("Número de Professores com Bolsa de Produtividade em Pesquisa do CNPq",1, 3, "RE","NU", ea5));
        indicadores.add(new Indicador("Pontos fortes",4, 1, "AN","TA", ea5));
        indicadores.add(new Indicador("Pontos fracos",5, 1, "AN","TA", ea5));
        indicadores.add(new Indicador("Meta",6, 1, "ML","TA", ea5));
        indicadores.add(new Indicador("Viabilidade",6, 2, "ML","TA", ea5));
        indicadores.add(new Indicador("Ameaças Internas",6, 3, "ML","TA", ea5));
        indicadores.add(new Indicador("Ameaças Externas",6, 4, "ML","TA", ea5));
        indicadores.add(new Indicador("Prioridade (de 1 a 5)",6, 5, "ML","NU", ea5));


        // Perguntas do Curso 1 - Eixo 3
        indicadores.add(new Indicador("Número de Linhas de pesquisa do programa",1, 1, "RE","NU", ea6));
        indicadores.add(new Indicador("Número de Projetos de Pesquisa",1, 2, "RE","NU", ea6));
        indicadores.add(new Indicador("Pontos fortes",3, 1, "AN","TA", ea6));
        indicadores.add(new Indicador("Pontos fracos",4, 1, "AN","TA", ea6));
        indicadores.add(new Indicador("Meta",5, 1, "ML","TA", ea6));
        indicadores.add(new Indicador("Viabilidade",5, 2, "ML","TA", ea6));
        indicadores.add(new Indicador("Ameaças Internas",5, 3, "ML","TA", ea6));
        indicadores.add(new Indicador("Ameaças Externas",5, 4, "ML","TA", ea6));
        indicadores.add(new Indicador("Prioridade (de 1 a 5)",5, 5, "ML","NU", ea6));


        // Perguntas do Curso 1 - Eixo 4
        indicadores.add(new Indicador("Trabalhos completos em periódicos",1, 1, "RE","NU", ea7));
        indicadores.add(new Indicador("Trabalhos completos em periódicos com autores discentes",1, 2, "RE","NU", ea7));
        indicadores.add(new Indicador("Anais Completos",1, 3, "RE","NU", ea7));
        indicadores.add(new Indicador("Produção Artística",1, 4, "RE","NU", ea7));
        indicadores.add(new Indicador("Produção Técnica",1, 5, "RE","NU", ea7));
        indicadores.add(new Indicador("Livro",1, 6, "RE","NU", ea7));
        indicadores.add(new Indicador("Capítulo de Livro",1, 7, "RE","NU", ea7));
        indicadores.add(new Indicador("Solicitação de Depósito de Patente",1, 8, "RE","NU", ea7));
        indicadores.add(new Indicador("Produto Educacional",1, 9, "RE","NU", ea7));
        indicadores.add(new Indicador("Relação percentual existente entre o número de dissertações e trabalhos publicados em periódicos com a participação de discentes",2, 1, "AN","TA", ea7));
        indicadores.add(new Indicador("Pontos fortes",3, 1, "AN","TA", ea7));
        indicadores.add(new Indicador("Pontos fracos",4, 1, "AN","TA", ea7));
        indicadores.add(new Indicador("Meta",5, 1, "ML","TA", ea7));
        indicadores.add(new Indicador("Viabilidade",5, 2, "ML","TA", ea7));
        indicadores.add(new Indicador("Ameaças Internas",5, 3, "ML","TA", ea7));
        indicadores.add(new Indicador("Ameaças Externas",5, 4, "ML","TA", ea7));
        indicadores.add(new Indicador("Prioridade (de 1 a 5)",5, 5, "ML","NU", ea7));


        // Perguntas do Curso 1 - Eixo 5
        indicadores.add(new Indicador("Número de candidatos inscritos para seleção",1, 1, "RE","NU", ea8));
        indicadores.add(new Indicador("Número de discentes com matrícula regular (total)",1, 2, "RE","NU", ea8));
        indicadores.add(new Indicador("Número de discentes com matrícula especial (total)",1, 3, "RE","NU", ea8));
        indicadores.add(new Indicador("Número de discentes titulados",1, 4, "RE","NU", ea8));
        indicadores.add(new Indicador("Pontos fortes",2, 1, "AN","TA", ea8));
        indicadores.add(new Indicador("Pontos fracos",3, 1, "AN","TA", ea8));
        indicadores.add(new Indicador("Meta",4, 1, "ML","TA", ea8));
        indicadores.add(new Indicador("Viabilidade",4, 2, "ML","TA", ea8));
        indicadores.add(new Indicador("Ameaças Internas",4, 3, "ML","TA", ea8));
        indicadores.add(new Indicador("Ameaças Externas",4, 4, "ML","TA", ea8));
        indicadores.add(new Indicador("Prioridade (de 1 a 5)",4, 5, "ML","NU", ea8));


        // Perguntas do Curso 1 - Eixo 6
        indicadores.add(new Indicador("Total de egressos",1, 1, "AN","TX", ea9));
        indicadores.add(new Indicador("Informar demais destinos relevantes dos egressos",2, 1, "AN","TA", ea9));


        // Perguntas do Curso 1 - Eixo 7
        indicadores.add(new Indicador("Pontos fortes",1, 1, "AN","TA", ea10));
        indicadores.add(new Indicador("Pontos fracos",2, 1, "AN","TA", ea10));
        indicadorRepository.saveAll(indicadores);

        // Respostas
//        Resposta resp1 = new Resposta(null, "As condições eram ruins, goteiras nas salas de aula, máquinas com limite de memória, dentre outras dificuldades", 0.00f, idc1);


//        List<Resposta> respostas = new ArrayList<>();

//        List<Resposta> respostas = indicadores.stream().map(indicador -> {
//            Resposta r = new Resposta();
//            return r;
//        }).collect(Collectors.toList());
////        indicadores
////                .stream()
////                .map(indicador -> {
////                    respostas.add(new Resposta(null, null, 0.00f, indicador));
////                }).collect(Collectors.toList());
//
//        respostaRepository.saveAll(Arrays.asList());
    }
}
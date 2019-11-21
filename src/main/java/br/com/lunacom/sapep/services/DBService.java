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

    @Autowired
    private MetaRepository metaRepository;

    public void instantiateData() throws ParseException {
        Usuario u1 = new Usuario("Alex L", "alex@gmail.com", "123456", "AT");
        u1.addPerfil(Perfil.ADMINISTRADOR);

        Usuario u2 = new Usuario("Silvia B", "silvia.bertagnolli@poa.ifrs.edu.br", "123456", "AT");
        u2.addPerfil(Perfil.ADMINISTRADOR);
        u2.addPerfil(Perfil.COORDENADOR);

        Usuario u3 = new Usuario("Evandro M", "evandro.miletto@poa.ifrs.edu.br", "123456", "AT");
        u3.addPerfil(Perfil.COORDENADOR);

        Usuario u4 = new Usuario("Maria M", "maria@gmail.com", "123456", "AT");
        u4.addPerfil(Perfil.PROPPI);

        Usuario u5 = new Usuario("Pedro F", "pedro@gmail.com", "123456", "AT");
        u5.addPerfil(Perfil.PROPPI);

        Usuario u6 = new Usuario("Clarice Monteiro Escott", "clarice@gmail.com", "123456", "AT");
        u6.addPerfil(Perfil.COORDENADOR);

        Usuario u7 = new Usuario("Cristina M. Quintella", "cristina@gmail.com", "123456", "AT");
        u7.addPerfil(Perfil.COORDENADOR);


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


        cursoRepository.saveAll(cursos);

        Curso c1 = cursos.get(0);
        Curso c2 = cursos.get(1);
        Curso c3 = cursos.get(2);
        Responsavel r1 = new Responsavel(c1, u6);
        Responsavel r2 = new Responsavel(c2, u2);
        Responsavel r3 = new Responsavel(c2, u3);
        Responsavel r4 = new Responsavel(c3, u7);
        responsavelRepository.saveAll(Arrays.asList(r1, r2, r3, r4));

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
        Date dtIni = new GregorianCalendar(2017, Calendar.JANUARY, 01).getTime();
        Date dtFim = new GregorianCalendar(2021, Calendar.DECEMBER, 31).getTime();
        Date dtIniPeriodoReal = new GregorianCalendar(2017, Calendar.JANUARY, 01).getTime();
        Date dtFimPeriodoReal = new GregorianCalendar(2021, Calendar.DECEMBER, 31).getTime();

        Autoavaliacao aa1 = new Autoavaliacao(
                "Planejamento período 2015/2018 (ProfEPT)",
                "Realizar planejamento do curso no período de 2015/2018",
                "IN", dtIniPassado, dtFimPassado, new Date(), c1);
        Autoavaliacao aa2 = new Autoavaliacao(
                "Autoavaliação do curso Quadriênio 2019/2022 (ProfEPT)",
                "Realizar planejamento do curso no período de 2019/2022",
                "AT", dtIni, dtFim, new Date(), c1);
        Autoavaliacao ab1 = new Autoavaliacao(
                "Autoavaliação MPIE - 2017/2021",
                "Realizar planejamento do curso no período de 2019/2022",
                "AT", dtIniPeriodoReal, dtFimPeriodoReal, new Date(), c2);
        Autoavaliacao ac1 = new Autoavaliacao(
                "Autoavaliação [4] (ProfNit) 2019/2022",
                "Realizar planejamento do curso no período de 2019/2022",
                "AT", dtIni, dtFim, new Date(), c3);

        autoavaliacaoRepository.saveAll(Arrays.asList(aa1,aa2, ab1, ac1));


        List<Eixo> eixos = new ArrayList<>();
        // Eixos da Autoavaliacao 1 - Curso 1
        Eixo ea1 = new Eixo("Eixo 1", "Trabalhos Externos", 3, new Date(), aa1);
        Eixo ea2 = new Eixo("Eixo 2", "Envolvimento Professores", 1, new Date(), aa1);
        Eixo ea3 = new Eixo("Eixo 3", "Envolvimento Alunos", 2, new Date(), aa1);

        // Eixos da Autoavaliacao 2 - Curso 1
        Eixo ea4 = new Eixo("Eixo 1", "Proposta do Programa", 1, new Date(), aa2);
        Eixo ea5 = new Eixo("Eixo 2", "Corpo Docente", 2, new Date(), aa2);
        Eixo ea6 = new Eixo("Eixo 3", "Atividades de Pesquisa", 3, new Date(), aa2);
        Eixo ea7 = new Eixo("Eixo 4", "Produção Intelectual", 4, new Date(), aa2);
        Eixo ea8 = new Eixo("Eixo 5", "Atividades de Formação", 5, new Date(), aa2);
        Eixo ea9 = new Eixo("Eixo 6", "Destino dos Mestres Egressos", 6, new Date(), aa2);
        Eixo ea10 = new Eixo("Eixo 7", "Análise do Ambiente Interno", 7, new Date(), aa2);
        Eixo ea11 = new Eixo("Eixo 8", "Infraestrutura", 8, new Date(), aa2);
        eixoRepository.saveAll(Arrays.asList(ea1,ea2,ea3,ea4,ea5,ea6,ea7,ea8,ea9,ea10,ea11));

        // Eixos da Autoavaliacao 3 - Curso 2
        Eixo eb1 = new Eixo("Eixo 1", "Articulação interna do programa e caráter interdisciplinar", 1, new Date(), ab1);
        Eixo eb2 = new Eixo("Eixo 2", "Perfil do corpo docente e sua adequação ao PPG", 2, new Date(), ab1);
        Eixo eb3 = new Eixo("Eixo 3", "Qualidade das atividades docentes de pesquisa, produção intelectual e de formação", 3, new Date(), ab1);
        Eixo eb4 = new Eixo("Eixo 4", "Qualidade da produção intelectual de discentes e egressos", 4, new Date(), ab1);
        Eixo eb5 = new Eixo("Eixo 5", "Qualidade e relevância das teses e dissertações", 5, new Date(), ab1);
        Eixo eb6 = new Eixo("Eixo 6", "Programa: Gestão acadêmica e formação do quadro técnico-administrativo ", 6, new Date(), ab1);
        Eixo eb7 = new Eixo("Eixo 7", "Infraestrutura como suporte às ações interdisciplinares", 7, new Date(), ab1);
        Eixo eb8 = new Eixo("Eixo 8", "Acompanhamento de egressos", 8, new Date(), ab1);
        Eixo eb9 = new Eixo("Eixo 9", "Impacto social, econômico e cultural – internacional, nacional, regional, local ", 9, new Date(), ab1);
        Eixo eb10 = new Eixo("Eixo 10", "Impacto e caráter inovador da produção intelectual", 10, new Date(), ab1);
        Eixo eb11 = new Eixo("Eixo 11", "Políticas inclusivas, programas de apoio aos estudantes e ações afirmativas", 11, new Date(), ab1);
        Eixo eb12 = new Eixo("Eixo 12", "Internacionalização e visibilidade do PPG", 12, new Date(), ab1);
        eixoRepository.saveAll(Arrays.asList(eb1,eb2,eb3,eb4,eb5,eb6,eb7,eb8,eb9,eb10,eb11,eb12));


        // Eixos da Autoavaliacao 4 - Curso 3
        Eixo ec1 = new Eixo("Eixo 1", "Proposta do Programa", 1, new Date(), ac1);
        Eixo ec2 = new Eixo("Eixo 2", "Corpo Docente", 2, new Date(), ac1);
        Eixo ec3 = new Eixo("Eixo 3", "Atividades de Pesquisa", 3, new Date(), ac1);
        Eixo ec4 = new Eixo("Eixo 4", "Produção Intelectual", 4, new Date(), ac1);
        Eixo ec5 = new Eixo("Eixo 5", "Atividades de Formação", 5, new Date(), ac1);
        Eixo ec6 = new Eixo("Eixo 6", "Destino dos Mestres Egressos", 6, new Date(), ac1);
        Eixo ec7 = new Eixo("Eixo 7", "Análise do Ambiente Interno", 7, new Date(), ac1);
        Eixo ec8 = new Eixo("Eixo 8", "Infraestrutura", 8, new Date(), ac1);
        eixoRepository.saveAll(Arrays.asList(ec5,ec7,ec6,ec4,ec1,ec2,ec8,ec3));



        List<Indicador> indicadores = new ArrayList<>();
        List<Meta> metas = new ArrayList<>();

        // Curso 1
            // Autoavaliação 2 - Eixo 1
            indicadores.add(new Indicador("Objetivos do Programa",1, 1, "AN","TA", ea4));

            // Autoavaliação 2 - Eixo 8
            indicadores.add(new Indicador("Relato breve das condições disponíveis", 1, 1, "RE", "TX", ea11, true));
            indicadores.add(new Indicador("Houve alterações relevantes de infraestrutura nos últimos 2 anos?", 2, 1, "RE", "CH", ea11, true));
            indicadores.add(new Indicador("Pontos fortes", 3, 1, "RE","TX", ea11));
            indicadores.add(new Indicador("Pontos fracos", 4, 1, "RE","TX", ea11));
//            indicadores.add(new Indicador("Meta", 5, 1, "ML","TX", ea11));
//            indicadores.add(new Indicador("Viabilidade", 5, 2, "ML","TX", ea11));
//            indicadores.add(new Indicador("Ameaças Internas", 5, 3, "ML","TX", ea11));
//            indicadores.add(new Indicador("Ameaças Externas", 5, 4, "ML","TX", ea11));
//            indicadores.add(new Indicador("Prioridade", 5, 4, "ML","TX", ea11));
//            indicadores.add(new Indicador("Prioridade", 5, 4, "ML","TX", ea11));

            // Autoavaliação 2 - Eixo 2
            indicadores.add(new Indicador("Número de Professores Permanentes",1, 1, "RE","NU", ea5));
            indicadores.add(new Indicador("Número de Professores Colaboradores ",1, 2, "RE","NU", ea5));
            indicadores.add(new Indicador("Número de Professores com Bolsa de Produtividade em Pesquisa do CNPq",1, 3, "RE","NU", ea5));
            indicadores.add(new Indicador("Pontos fortes",4, 1, "AN","TA", ea5));
            indicadores.add(new Indicador("Pontos fracos",5, 1, "AN","TA", ea5));
//            indicadores.add(new Indicador("Meta",6, 1, "ML","TA", ea5));
//            indicadores.add(new Indicador("Viabilidade",6, 2, "ML","TA", ea5));
//            indicadores.add(new Indicador("Ameaças Internas",6, 3, "ML","TA", ea5));
//            indicadores.add(new Indicador("Ameaças Externas",6, 4, "ML","TA", ea5));
//            indicadores.add(new Indicador("Prioridade (de 1 a 5)",6, 5, "ML","NU", ea5));

            // Autoavaliação 2 - Eixo 3
            indicadores.add(new Indicador("Número de Linhas de pesquisa do programa",1, 1, "RE","NU", ea6));
            indicadores.add(new Indicador("Número de Projetos de Pesquisa",1, 2, "RE","NU", ea6));
            indicadores.add(new Indicador("Pontos fortes",3, 1, "AN","TA", ea6));
            indicadores.add(new Indicador("Pontos fracos",4, 1, "AN","TA", ea6));
//            indicadores.add(new Indicador("Meta",5, 1, "ML","TA", ea6));
//            indicadores.add(new Indicador("Viabilidade",5, 2, "ML","TA", ea6));
//            indicadores.add(new Indicador("Ameaças Internas",5, 3, "ML","TA", ea6));
//            indicadores.add(new Indicador("Ameaças Externas",5, 4, "ML","TA", ea6));
//            indicadores.add(new Indicador("Prioridade (de 1 a 5)",5, 5, "ML","NU", ea6));

            // Autoavaliação 2 - Eixo 4
            indicadores.add(new Indicador("Trabalhos completos em periódicos",1, 1, "RE","NU", ea7, true));
            indicadores.add(new Indicador("Trabalhos completos em periódicos com autores discentes",1, 2, "RE","NU", ea7, true));
            indicadores.add(new Indicador("Anais Completos",1, 3, "RE","NU", ea7, true));
            indicadores.add(new Indicador("Produção Artística",1, 4, "RE","NU", ea7, true));
            indicadores.add(new Indicador("Produção Técnica",1, 5, "RE","NU", ea7, true));
            indicadores.add(new Indicador("Livro",1, 6, "RE","NU", ea7, true));
            indicadores.add(new Indicador("Capítulo de Livro",1, 7, "RE","NU", ea7, true));
            indicadores.add(new Indicador("Solicitação de Depósito de Patente",1, 8, "RE","NU", ea7, true));
            indicadores.add(new Indicador("Produto Educacional",1, 9, "RE","NU", ea7, true));
            indicadores.add(new Indicador("Relação percentual existente entre o número de dissertações e trabalhos publicados em periódicos com a participação de discentes",2, 1, "AN","TA", ea7));
            indicadores.add(new Indicador("Pontos fortes",3, 1, "AN","TA", ea7));
            indicadores.add(new Indicador("Pontos fracos",4, 1, "AN","TA", ea7));
//            indicadores.add(new Indicador("Meta",5, 1, "ML","TA", ea7));
//            indicadores.add(new Indicador("Viabilidade",5, 2, "ML","TA", ea7));
//            indicadores.add(new Indicador("Ameaças Internas",5, 3, "ML","TA", ea7));
//            indicadores.add(new Indicador("Ameaças Externas",5, 4, "ML","TA", ea7));
//            indicadores.add(new Indicador("Prioridade (de 1 a 5)",5, 5, "ML","NU", ea7));

            // Autoavaliação 2 - Eixo 5
            indicadores.add(new Indicador("Número de candidatos inscritos para seleção",1, 1, "RE","NU", ea8));
            indicadores.add(new Indicador("Número de discentes com matrícula regular (total)",1, 2, "RE","NU", ea8));
            indicadores.add(new Indicador("Número de discentes com matrícula especial (total)",1, 3, "RE","NU", ea8));
            indicadores.add(new Indicador("Número de discentes titulados",1, 4, "RE","NU", ea8));
            indicadores.add(new Indicador("Pontos fortes",2, 1, "AN","TA", ea8));
            indicadores.add(new Indicador("Pontos fracos",3, 1, "AN","TA", ea8));
//            indicadores.add(new Indicador("Meta",4, 1, "ML","TA", ea8));
//            indicadores.add(new Indicador("Viabilidade",4, 2, "ML","TA", ea8));
//            indicadores.add(new Indicador("Ameaças Internas",4, 3, "ML","TA", ea8));
//            indicadores.add(new Indicador("Ameaças Externas",4, 4, "ML","TA", ea8));
//            indicadores.add(new Indicador("Prioridade (de 1 a 5)",4, 5, "ML","NU", ea8));

            // Autoavaliação 2 - Eixo 6
            indicadores.add(new Indicador("Total de egressos",1, 1, "AN","TX", ea9));
            indicadores.add(new Indicador("Informar demais destinos relevantes dos egressos",2, 1, "AN","TA", ea9));

            // Autoavaliação 2 - Eixo 7
            indicadores.add(new Indicador("Pontos fortes",1, 1, "AN","TA", ea10));
            indicadores.add(new Indicador("Pontos fracos",2, 1, "AN","TA", ea10));


        // Curso 2
            // Autoavaliação 3 - Eixo 1
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb1));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb1));
            metas.add(new Meta("Revisão do PPC para fomentar o trabalho articulado dos docentes", 5.0, eb1));
            metas.add(new Meta("Promover seminários de alinhamento semestral com os docentes para estimular o desenvolvimento de projetos em conjunto", 2.0, eb1));
            metas.add(new Meta("Investimento em pesquisas interdisciplinares, que aproximem os professores do programa, de forma a qualificar e ampliar o número de produções acadêmicas, especialmente de forma a contemplar a verticalidade, característica dos Institutos Federais, das pesquisas envolvendo alunos de Iniciação Científica e de Mestrado.", 5.0, eb1));
            metas.add(new Meta("Fomento ao desenvolvimento de produtos interdisciplinares na área da Informática da Educação", 0,eb1));
            metas.add(new Meta("Estabelecimento de projetos interdisciplinares e compartilhados entre docentes", 0,eb1));

            // Autoavaliação 3 - Eixo 2
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb2));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb2));
            metas.add(new Meta("Ampliação do número de disciplinas ministradas de forma interdisciplinar", 5.0, eb2));
            metas.add(new Meta("Comunicar as ações desenvolvidas pelo MPIE para a comunidade, com vista a estreitar as relações entre a academia e a sociedade, em especial no que diz respeito à aproximação com escolas públicas de Educação Básica", 0, eb2));
            metas.add(new Meta("Investimento em projetos guarda-chuva, que contemplem a verticalidade característica dos Institutos Federais, e que qualifiquem as pesquisas desenvolvidas pelo corpo docente junto aos mestrandos do MPIE", 0, eb2));

            // Autoavaliação 3 - Eixo 3
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb3));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb3));
            metas.add(new Meta("Contratação de professores visitantes por parte do IFRS que estarão vinculados ao programa, visando a formação continuada de docentes", 5, eb3));
            metas.add(new Meta("Contratação de professor visitante para articular as ações do programa com a rede brasileira de aprendizagem criativa", 5, eb3));
            metas.add(new Meta("Organização de eventos de formação continuada com apoio dos professores visitantes, para docentes do programa e instituições parceiras", 0, eb3));
            metas.add(new Meta("Organização de um livro por alguns docentes do programa, visando publicizar as ações e qualificar as atividades do programa", 0, eb3));

            // Autoavaliação 3 - Eixo 4
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb4));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb4));
            metas.add(new Meta("Divulgação para os alunos ingressantes de eventos e periódicos da área, incentivando a participação deles nos eventos", 5, eb4));
            metas.add(new Meta("Sistematização de técnicas de pesquisa na disciplina de metodologia da pesquisa", 5, eb4));
            metas.add(new Meta("Aulas com a apresentação de ferramentas tecnológicas para organização e gerenciamento da elaboração da dissertação e dos produtos tecnológicos produzidos", 5, eb4));
            metas.add(new Meta("Como os estudantes têm tempo restrito para o desenvolvimento de suas produções abordar ferramentas para o gerenciamento do tempo e técnicas  como Timebox, Pomodoro, entre outras", 0, eb4));
            metas.add(new Meta("Incentivar a produção de artigos em eventos e periódicos, e até mesmo livros, de forma conjunta entre os discentes que pesquisam um mesmo tema e seus orientadores", 0, eb4));

            // Autoavaliação 3 - Eixo 5
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb5));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb5));
            metas.add(new Meta("Parceria com a SEDUC/RS (Secretaria de Educação do Estado do Rio Grande do Sul) para aproximar o programa das escolas públicas da rede estadual, o que viabilizará o desenvolvimento de dissertações e produtos “com” a sociedade", 5, eb5));
            metas.add(new Meta("Incentivar a produção de dissertações e produtos com escolas públicas (rede federal, estadual e municipal)", 5, eb5));
            metas.add(new Meta("Participação no projeto Pacto Alegre com a Prefeitura de Porto Alegre", 5, eb5));
            metas.add(new Meta("Organizar eventos internos para que alunos ingressantes possam discutir os trabalhos já desenvolvidos e refletir como seus trabalhos podem ser produzidos “com” a sociedade", 5, eb5));
            metas.add(new Meta("Organizar eventos voltados para e com escolas para aproximar os mestrandos da realidade da sociedade, visando uma produção mais qualificada e articulada com as necessidades das escolas", 5, eb5));

            // Autoavaliação 3 - Eixo 6
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb6));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb6));
            metas.add(new Meta("Revisão do plano de curso à luz da experiência tida até aqui.", 5, eb6));
            metas.add(new Meta("Formação específica para as servidoras da secretaria do curso no que diz respeito às normas da CAPES para a pós-graduação.", 5, eb6));
            metas.add(new Meta("Treinamento para utilização da Plataforma Sucupira", 5, eb6));
            metas.add(new Meta("Revisar o plano de curso", 0, eb6));
            metas.add(new Meta("Organizar formação específica para as servidoras da secretaria do curso", 0, eb6));

            // Autoavaliação 3 - Eixo 7
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb7));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb7));
            metas.add(new Meta("Consolidar a cultura de uso do espaço que está sendo estruturado(poalab/MIGRA/LECC) pelos alunos para experimentos e discussões", 5, eb7));
            metas.add(new Meta("Estruturar melhor os laboratórios (POALAB, MIGRALA e LECC) para receber docentes e estudantes de escolas públicas", 5, eb7));
            metas.add(new Meta("Estruturação do cabeamento lógico e elétrico de alguns laboratórios", 5, eb7));
            metas.add(new Meta("Viabilizar a exaustão de máquina de corte a laser no POALab para andamento de algumas pesquisas", 5, eb7));
            metas.add(new Meta("Definição de sala para desenvolvimento de pesquisa e estudos com acesso para todos os discentes e docentes do programa", 0, eb7));
            metas.add(new Meta("Ajuste da infraestrutura dos laboratórios dependendo da disponibilidade orçamentária do IFRS", 0, eb7));

            // Autoavaliação 3 - Eixo 8
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb8));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb8));
            metas.add(new Meta("Entrar em contato por email com os egressos para verificar se os email continuam válidos", 0, eb8));
            metas.add(new Meta("Entrar em contato para consultar sobre a sua disponibilidade para participar de eventos e oficinas para alunos ingressantes", 0, eb8));
            metas.add(new Meta("Entrar em contato para solicitar breve relato sobre a importância que o programa teve em sua formação acadêmica e seus reflexos em sua vida profissional e pessoal", 0, eb8));
            metas.add(new Meta("Criação de uma página no Linkedin visando ampliar o contato com os egressos", 5, eb8));
            metas.add(new Meta("Reorganização do site visando dar mais visibilidade às atividades desenvolvidas pelos estudantes e valorização dos egressos", 5, eb8));

            // Autoavaliação 3 - Eixo 9
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb9));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb9));
            metas.add(new Meta("Submissão/Divulgação dos trabalhos realizados em eventos nacionais (SBIE, CBIE, e eventos internacionais (TICEduca, ICALT, ISAM, TISE, etc.) .", 5, eb9));
            metas.add(new Meta("Proposição de ações de extensão integradas às ações de pesquisas desenvolvidas no âmbito do MPIE, de forma a promover a inserção social do trabalho desenvolvido pelos professores do MPIE junto aos seus orientandos.", 5, eb9));
            metas.add(new Meta("Com a participação do professor visitante pretende-se ampliar o contato nacional e internacional", 0, eb9));
            metas.add(new Meta("Promover pesquisas e ações de extensão interdisciplinares", 0, eb9));
            metas.add(new Meta("Incentivo à realização de estágio pós-doutoral dos docentes em instituições internacionais, visando o estabelecimento das redes de pesquisa", 0, eb9));

            // Autoavaliação 3 - Eixo 10
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb10));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb10));
            metas.add(new Meta("Fortalecer junto aos discentes a diversidade de produtos que podem ser produzidos, atividade que já está em andamento na disciplina de metodologia científica", 5, eb10));
            metas.add(new Meta("Produção de cursos de curta duração para instituições parceiras", 5, eb10));
            metas.add(new Meta("Produção de produtos construídos “com” as instituições parceiras", 0, eb10));

            // Autoavaliação 3 - Eixo 11
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb11));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb11));
            metas.add(new Meta("Aproximação entre os Núcleos de Ações Assistivas e o CTA com as ações do Mestrado, de forma a qualificar o corpo docente e desenvolver ações de forma integrada, entre os núcleos e os docentes, e que busquem qualificar a permanência e o êxito de alunos de inclusão e também daqueles que tenham a necessidade de serem atendidos pelos núcleos", 5, eb11));
            metas.add(new Meta("Promover ações de integração entre Mestrado Profissional em Informática na Educação (MPIE), os núcleos de ações afirmativas e o centro de tecnologias assistivas (CTA), de forma a ampliar a inserção social das pesquisas desenvolvidas no âmbito do MPIE.", 0, eb11));
            metas.add(new Meta("Ampliar o número de projetos envolvendo os núcleos e as potencialidades do PoaLab.", 0, eb11));
            metas.add(new Meta("Promover ações de extensão com vistas a ampliar a inserção social do MPIE por meio de projetos de ações inclusivas", 0, eb11));

            // Autoavaliação 3 - Eixo 12
            indicadores.add(new Indicador("Pontos Fracos (fragilidades)",1, 1, "AN","TA", eb12));
            indicadores.add(new Indicador("Pontos Fortes",2, 1, "AN","TA", eb12));
            metas.add(new Meta("Buscar a manutenção do incentivo à participação em eventos internacionais", 5, eb12));
            metas.add(new Meta("Primar pela continuidade da política  de afastamento para professores", 5, eb12));
            metas.add(new Meta("Estabelecer projetos conjuntos com instituições internacionais", 0, eb12));
            metas.add(new Meta("Realização de estágio pós-doutoral dos docentes em instituições internacionais", 0, eb12));


        indicadorRepository.saveAll(indicadores);
        metaRepository.saveAll(metas);

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
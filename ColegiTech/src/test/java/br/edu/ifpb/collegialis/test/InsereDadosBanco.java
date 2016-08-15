package br.edu.ifpb.collegialis.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.ifpb.collegialis.dao.AdiamentoDAO;
import br.edu.ifpb.collegialis.dao.AlunoDAO;
import br.edu.ifpb.collegialis.dao.AssuntoDAO;
import br.edu.ifpb.collegialis.dao.ColegiadoDAO;
import br.edu.ifpb.collegialis.dao.CoordenadorDAO;
import br.edu.ifpb.collegialis.dao.CursoDAO;
import br.edu.ifpb.collegialis.dao.ManagedEMContext;
import br.edu.ifpb.collegialis.dao.MembroDAO;
import br.edu.ifpb.collegialis.dao.PerfilDAO;
import br.edu.ifpb.collegialis.dao.PersistenceUtil;
import br.edu.ifpb.collegialis.dao.ProcessoDAO;
import br.edu.ifpb.collegialis.dao.ProfessorDAO;
import br.edu.ifpb.collegialis.dao.ReuniaoDAO;
import br.edu.ifpb.collegialis.dao.UsuarioDAO;
import br.edu.ifpb.collegialis.dao.VotoDAO;
import br.edu.ifpb.collegialis.entity.Adiamento;
import br.edu.ifpb.collegialis.entity.Aluno;
import br.edu.ifpb.collegialis.entity.Assunto;
import br.edu.ifpb.collegialis.entity.Colegiado;
import br.edu.ifpb.collegialis.entity.Coordenador;
import br.edu.ifpb.collegialis.entity.Curso;
import br.edu.ifpb.collegialis.entity.Membro;
import br.edu.ifpb.collegialis.entity.Perfil;
import br.edu.ifpb.collegialis.entity.Processo;
import br.edu.ifpb.collegialis.entity.Professor;
import br.edu.ifpb.collegialis.entity.Reuniao;
import br.edu.ifpb.collegialis.entity.Usuario;
import br.edu.ifpb.collegialis.entity.Voto;
import br.edu.ifpb.collegialis.type.StatusReuniao;
import br.edu.ifpb.collegialis.type.TipoDecisao;
import br.edu.ifpb.collegialis.type.TipoPerfil;
import br.edu.ifpb.collegialis.type.TipoVoto;

/**
 * @author fred
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InsereDadosBanco {

	private static EntityManagerFactory emf;

	private static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

	private EntityManager em;

	@BeforeClass
	public static void init() {
		PersistenceUtil.createEntityManagerFactory();
		emf = PersistenceUtil.getEntityManagerFactory();
		ManagedEMContext.bind(emf, emf.createEntityManager());
		System.out.println("init()");
	}

	@AfterClass
	public static void destroy() {
		if (emf != null) {
			emf.close();
			System.out.println("destroy()");
		}
	}

	@Before
	public void initEM() {
		em = emf.createEntityManager();
	}

	/**
	 * Insere Alunos
	 */
	@Test
	public void test01InsereAlunos() {
		try {
			System.out.println("testInsereAlunos");
			AlunoDAO dao = new AlunoDAO(em);
			dao.beginTransaction();
			Aluno a = new Aluno();
			a.setNome("Jose Carlos da Silva");
			a.setEmail("jcds@ifpb.edu.br");
			a.setFone("3422-9900");
			a.setMatricula("2012041033");
			dao.insert(a);
			a = new Aluno();
			a.setNome("Maria Clara dos Santos");
			a.setEmail("mcds@ifpb.edu.br");
			a.setFone("3662-5536");
			a.setMatricula("2013041125");
			dao.insert(a);
			a = new Aluno();
			a.setNome("Joao Firmino da Costa");
			a.setEmail("jfdc@ifpb.edu.br");
			a.setFone("3556-8433");
			a.setMatricula("2012041056");
			dao.insert(a);
			a = new Aluno();
			a.setNome("Priscila Almeida Pontes");
			a.setEmail("pap@ifpb.edu.br");
			a.setFone("3417-4237");
			a.setMatricula("2013041012");
			dao.insert(a);
			a = new Aluno();
			a.setNome("Walter Pontes Fontes");
			a.setEmail("wpf@ifpb.edu.br");
			a.setFone("3417-4645");
			a.setMatricula("20130414512");
			dao.insert(a);
			a = new Aluno();
			a.setNome("Amanda Correia Lima");
			a.setEmail("acl@ifpb.edu.br");
			a.setFone("9888-4099");
			a.setMatricula("20130414564");
			dao.insert(a);
			a = new Aluno();
			a.setNome("Rogerio Nunes");
			a.setEmail("rn@ifpb.edu.br");
			a.setFone("98388-4787");
			a.setMatricula("2013041474");
			dao.insert(a);
			a = new Aluno();
			a.setNome("Carol Soares Barbosa");
			a.setEmail("csb@ifpb.edu.br");
			a.setFone("98747-4849");
			a.setMatricula("2013041110");
			dao.insert(a);
			a = new Aluno();
			a.setNome("Cesar Ferreira da Silva");
			a.setEmail("cfds@ifpb.edu.br");
			a.setFone("98821-4899");
			a.setMatricula("2013041556");
			dao.insert(a);
			a = new Aluno();
			a.setNome("Natalia Seixas Gomes");
			a.setEmail("nsg@ifpb.edu.br");
			a.setFone("94432-0199");
			a.setMatricula("2013041498");
			dao.insert(a);
			dao.commit();
		} catch (Exception e) {
			Assert.fail("Erro de BD");
		}
	}

	/**
	 * Insere Assuntos
	 */
	@Test
	public void test02InsereAssuntos() {
		try {
			System.out.println("testInsereAssuntos");
			AssuntoDAO dao = new AssuntoDAO(em);
			dao.beginTransaction();
			Assunto a = new Assunto();
			a.setDescricao("Trancamento de matrícula");
			dao.insert(a);
			a = new Assunto();
			a.setDescricao("Reabertura de matrícula");
			dao.insert(a);
			a = new Assunto();
			a.setDescricao("Dispensa de pré-requisito");
			dao.insert(a);
			dao.commit();
		} catch (Exception e) {
			Assert.fail("Erro de BD");
		}
	}

	/**
	 * Insere mais Perfis e Usuarios
	 */
	@Test
	public void test03InserePerfisUsuarios() {
		PerfilDAO pdao = new PerfilDAO(em);

		pdao.beginTransaction();
		Perfil p = new Perfil();
		p.setNome(TipoPerfil.ADMIN);
		p.setDescricao("Administrador do Sistema");
		pdao.insert(p);
		pdao.commit();
		pdao.beginTransaction();
		Perfil p2 = new Perfil();
		p2.setNome(TipoPerfil.COORDENADOR);
		p2.setDescricao("Coordenador de Curso");
		pdao.insert(p2);
		pdao.commit();
		pdao.beginTransaction();
		Perfil p3 = new Perfil();
		p3.setNome(TipoPerfil.MEMBRO);
		p3.setDescricao("Membro do Colegiado");
		pdao.insert(p3);
		pdao.commit();
		pdao.beginTransaction();
		Perfil p4 = new Perfil();
		p4.setNome(TipoPerfil.SECRETARIO);
		p4.setDescricao("Secretário da Coordenação");
		pdao.insert(p4);
		pdao.commit();

		UsuarioDAO udao = new UsuarioDAO(em);

		udao.beginTransaction();
		Usuario u = new Usuario();
		u.setNome("Frederico Costa");
		u.setEmail("fred@ifpb.edu.br");
		u.setSenha("lll");
		u.setAtivo(true);
		u.addPerfil(p3).addPerfil(p);
		udao.insert(u);

		u = new Usuario();
		u.setNome("Valeria Cavalcanti");
		u.setEmail("valeria@ifpb.edu.br");
		u.setAtivo(true);
		u.addPerfil(p).addPerfil(p2);
		udao.insert(u);
		udao.commit();
	}

	/**
	 * Insere professores
	 */
	@Test
	public void test04InsereProfessores() {
		System.out.println("testInsereProfessores");
		ProfessorDAO pdao = new ProfessorDAO(em);
		pdao.beginTransaction();
		Professor p1 = new Professor();
		p1.setNome("Frederico Costa");
		p1.setEmail("fred@ifpb.edu.br");
		p1.setMatricula("1200309");
		p1.setFone("988157517");
		pdao.insert(p1);

		Professor p2 = new Professor();
		p2.setNome("Valeria Cavalcanti");
		p2.setEmail("valeria@ifpb.edu.br");
		p2.setMatricula("1200310");
		p2.setFone("988887766");
		pdao.insert(p2);

		Professor p3 = new Professor();
		p3.setNome("Marcus Varandas");
		p3.setEmail("varandas@ifpb.edu.br");
		p3.setMatricula("1200311");
		p3.setFone("99328874");
		pdao.insert(p3);

		Professor p4 = new Professor();
		p4.setNome("Cândido Egypto");
		p4.setEmail("candido@ifpb.edu.br");
		p4.setMatricula("1200312");
		p4.setFone("99322744");
		pdao.insert(p4);

		Professor p5 = new Professor();
		p5.setNome("Thiago Gouveia");
		p5.setEmail("tgouveia@ifpb.edu.br");
		p5.setMatricula("1200313");
		p5.setFone("99347084");
		pdao.insert(p5);

		pdao.commit();
	}

	/**
	 * Insere Coordenadores
	 */
	@Test
	public void test05InsereCursos() {
		try {
			CursoDAO cdao = new CursoDAO(em);
			CoordenadorDAO cddao = new CoordenadorDAO(em);
			ProfessorDAO pdao = new ProfessorDAO(em);

			Professor p2 = pdao.find(2); // valeria
			Professor p4 = pdao.find(4); // candido
			Professor p5 = pdao.find(5); // thiago

			cddao.beginTransaction();
			Coordenador coord = new Coordenador();
			coord.setProfessor(p2);
			coord.setDataInicio(fmt.parse("10/02/2012"));
			coord.setDataFim(fmt.parse("12/12/2016"));
			coord.setNumPortaria("DG-JP 110/2012");
			cddao.insert(coord);
			cddao.commit();

			cddao.beginTransaction();
			Coordenador coord2 = new Coordenador();
			coord2.setProfessor(p4);
			coord2.setDataInicio(fmt.parse("10/02/2014"));
			coord2.setNumPortaria("DG-JP 310/2014");
			cddao.insert(coord2);
			cddao.commit();

			cddao.beginTransaction();
			Coordenador coord3 = new Coordenador();
			coord3.setProfessor(p5);
			coord3.setDataInicio(fmt.parse("10/02/2013"));
			coord3.setDataFim(fmt.parse("07/03/2015"));
			coord3.setNumPortaria("DG-JP 034/2013");
			cddao.insert(coord3);
			cddao.commit();

			cdao.beginTransaction();
			Curso c = new Curso();
			c.setNome("Tecnologia em Sistemas para Internet");
			c.setSigla("TSI");
			c.setCoordenador(coord);
			coord.setCurso(c);
			cdao.insert(c);
			cdao.commit();

			cdao.beginTransaction();
			Curso c2 = new Curso();
			c2.setNome("Tecnologia em Redes de Computadores");
			c2.setSigla("Redes");
			c2.setCoordenador(coord2);
			coord2.setCurso(c2);
			coord3.setCurso(c2);
			cdao.insert(c2);
			cdao.commit();
			
			cdao.beginTransaction();
			Curso c3 = new Curso();
			c3.setNome("Telemática");
			c3.setSigla("Telem");
			cdao.insert(c3);
			cdao.commit();

		} catch (ParseException e) {
			System.out.println("Erro BD");
		}

	}

	/**
	 * Insere membros do colegiado
	 */
	@Test
	public void test06InsereMembrosColegiado() {

		try {
			CursoDAO ccdao = new CursoDAO(em);
			Curso tsi = ccdao.find(1);
			Curso redes = ccdao.find(2);

			ProfessorDAO pdao = new ProfessorDAO(em);
			Professor p1 = pdao.find(1);
			Professor p2 = pdao.find(2);
			Professor p3 = pdao.find(3);
			Professor p4 = pdao.find(4);

			List<Membro> membrosTSI = new ArrayList<Membro>();
			List<Membro> membrosRedes = new ArrayList<Membro>();

			MembroDAO mdao = new MembroDAO(em);
			mdao.beginTransaction();
			Membro m1 = new Membro();
			m1.setProfessor(p1);
			mdao.insert(m1);
			membrosTSI.add(m1);

			Membro m2 = new Membro();
			m2.setProfessor(p2);
			mdao.insert(m2);
			membrosTSI.add(m2);

			Membro m3 = new Membro();
			m3.setProfessor(p3);
			mdao.insert(m3);
			membrosTSI.add(m3);

			// Redes
			Membro m4 = new Membro();
			m4.setProfessor(p4);
			mdao.insert(m4);
			membrosRedes.add(m4);

			Membro m5 = new Membro();
			m5.setProfessor(p3);
			mdao.insert(m5);
			membrosRedes.add(m5);

			Membro m6 = new Membro();
			m6.setProfessor(p1);
			mdao.insert(m6);
			membrosRedes.add(m6);
			mdao.commit();

			ColegiadoDAO cdao = new ColegiadoDAO(em);
			cdao.beginTransaction();
			Colegiado cTSI = new Colegiado();
			cTSI.setDescricao("Colegiado I - 2014");
			cTSI.setDataInicio(fmt.parse("10/04/2014"));
			cTSI.setDataFim(fmt.parse("06/06/2016"));
			cTSI.setPortaria("DG-JP 122/2014");
			cTSI.setCurso(tsi);
			tsi.setColegiado(cTSI);
			cTSI.addMembros(membrosTSI);
			cTSI.isAtivo();
			cdao.insert(cTSI);

			Colegiado cRedes = new Colegiado();
			cRedes.setDescricao("Colegiado I - 2013");
			cRedes.setDataInicio(fmt.parse("18/07/2013"));
			cRedes.setDataFim(fmt.parse("06/06/2016"));
			cRedes.setPortaria("DG-JP 175/2013");
			cRedes.setCurso(redes);
			redes.setColegiado(cRedes);
			cRedes.addMembros(membrosRedes);
			cdao.insert(cRedes);
			cdao.commit();

		} catch (ParseException e) {
			Assert.fail("Erro na data");
		}
	}

	@Test
	public void test07InsereProcessos() {
		try {
			AssuntoDAO adao = new AssuntoDAO(em);
			Assunto a1 = adao.find(1);
			Assunto a2 = adao.find(2);
			Assunto a3 = adao.find(3);

			MembroDAO mdao = new MembroDAO(em);
			Membro m1 = mdao.find(1);
			Membro m2 = mdao.find(2);
			Membro m3 = mdao.find(3);
			Membro m4 = mdao.find(4);
			Membro m5 = mdao.find(5);
			Membro m6 = mdao.find(6);

			AlunoDAO aldao = new AlunoDAO(em);
			Aluno al1 = aldao.find(1);
			Aluno al2 = aldao.find(2);
			Aluno al3 = aldao.find(3);
			Aluno al4 = aldao.find(4);
			Aluno al5 = aldao.find(5);
			Aluno al6 = aldao.find(6);
			Aluno al7 = aldao.find(7);
			Aluno al8 = aldao.find(8);
			Aluno al9 = aldao.find(9);
			Aluno al10 = aldao.find(10);

			ProcessoDAO pdao = new ProcessoDAO(em);
			pdao.beginTransaction();
			Processo p1 = new Processo();
			p1.setNumero("2300212445005/2016");
			p1.setAssunto(a1);
			p1.setDataRecepcao(fmt.parse("08/03/2016"));
			p1.setDataDistribuicao(fmt.parse("10/03/2016"));
			p1.setDataParecer(fmt.parse("17/03/2016"));
			p1.setDecisao(TipoDecisao.DEFERIDO);
			p1.setRelator(m1);
			p1.setRequisitante(al1);
			pdao.insert(p1);

			Processo p2 = new Processo();
			p2.setNumero("2300277895031/2016");
			p2.setAssunto(a2);
			p2.setDataRecepcao(fmt.parse("04/03/2016"));
			p2.setDataDistribuicao(fmt.parse("11/06/2016"));
			p2.setDataParecer(fmt.parse("19/03/2016"));
			p2.setDecisao(TipoDecisao.INDEFERIDO);
			p2.setRelator(m2);
			p2.setRequisitante(al2);
			String descricaoAlu = "Gostaria de pedir isso porque nao poderei ir ao IFPB";
			byte[] descricaoAluByte = descricaoAlu.getBytes();
			p2.setDescricaoAlu(descricaoAluByte);
			pdao.insert(p2);

			Processo p3 = new Processo();
			p3.setNumero("2300335767567/2016");
			p3.setAssunto(a3);
			p3.setDataRecepcao(fmt.parse("07/03/2016"));
			p3.setDataDistribuicao(fmt.parse("11/03/2016"));
			p3.setDataParecer(fmt.parse("15/03/2016"));
			p3.setDecisao(TipoDecisao.DEFERIDO);
			p3.setRelator(m3);
			p3.setRequisitante(al3);
			pdao.insert(p3);

			Processo p4 = new Processo();
			p4.setNumero("2300335353553/2016");
			p4.setAssunto(a2);
			p4.setDataRecepcao(fmt.parse("07/03/2016"));
			p4.setDataDistribuicao(fmt.parse("11/03/2016"));
			p4.setDataParecer(fmt.parse("14/03/2016"));
			p4.setDecisao(TipoDecisao.INDEFERIDO);
			p4.setRelator(m1);
			p4.setRequisitante(al4);
			pdao.insert(p4);

			Processo p5 = new Processo();
			p5.setNumero("2300335833392/2016");
			p5.setAssunto(a3);
			p5.setDataRecepcao(fmt.parse("17/05/2016"));
			p5.setDataDistribuicao(fmt.parse("21/05/2016"));
			p5.setDataParecer(fmt.parse("23/05/2016"));
			p5.setDecisao(TipoDecisao.DEFERIDO);
			p5.setRelator(m2);
			p5.setRequisitante(al5);
			pdao.insert(p5);

			Processo p6 = new Processo();
			p6.setNumero("2300334840948/2016");
			p6.setAssunto(a3);
			p6.setDataRecepcao(fmt.parse("18/05/2016"));
			p6.setDataDistribuicao(fmt.parse("21/05/2016"));
			p6.setDataParecer(fmt.parse("24/05/2016"));
			p6.setDecisao(TipoDecisao.DEFERIDO);
			p6.setRelator(m3);
			p6.setRequisitante(al6);
			pdao.insert(p6);

			Processo p7 = new Processo();
			p7.setNumero("23003357675677/2016");
			p7.setAssunto(a1);
			p7.setDataRecepcao(fmt.parse("17/05/2016"));
			p7.setDataDistribuicao(fmt.parse("21/05/2016"));
			p7.setDataParecer(fmt.parse("25/05/2016"));
			p7.setDecisao(TipoDecisao.INDEFERIDO);
			p7.setRelator(m1);
			p7.setRequisitante(al7);
			pdao.insert(p7);

			Processo p8 = new Processo();
			p8.setNumero("2300330650334/2016");
			p8.setAssunto(a2);
			p8.setDataRecepcao(fmt.parse("15/06/2016"));
			p8.setDataDistribuicao(fmt.parse("19/06/2016"));
			p8.setRelator(m4);
			p8.setRequisitante(al8);
			pdao.insert(p8);

			Processo p9 = new Processo();
			p9.setNumero("2300331134367/2016");
			p9.setAssunto(a3);
			p9.setDataRecepcao(fmt.parse("16/06/2016"));
			p9.setDataDistribuicao(fmt.parse("19/06/2016"));
			p9.setRelator(m5);
			p9.setRequisitante(al9);
			pdao.insert(p9);

			Processo p10 = new Processo();
			p10.setNumero("230033558381/2016");
			p10.setAssunto(a2);
			p10.setDataRecepcao(fmt.parse("19/06/2016"));
			p10.setDataDistribuicao(fmt.parse("20/06/2016"));
			p10.setRelator(m6);
			p10.setRequisitante(al10);
			pdao.insert(p10);
			pdao.commit();

		} catch (ParseException e) {
			Assert.fail();
		}

	}

	@Test
	public void test08InsereReuniao() {
		try {
			ColegiadoDAO coldao = new ColegiadoDAO(em);
			Colegiado colredes = coldao.find(1);
			Colegiado coltsi = coldao.find(2);

			ProcessoDAO pdao = new ProcessoDAO(em);
			List<Processo> procs1 = pdao.find(new Integer[] { 1, 2, 3, 4 });
			List<Processo> procs2 = pdao.find(new Integer[] { 5, 6, 7 });
			List<Processo> procs3 = pdao.find(new Integer[] { 8, 9, 10 });
			
			ReuniaoDAO rdao = new ReuniaoDAO(em);
			rdao.beginTransaction();
			Reuniao r1 = new Reuniao();
			r1.setColegiado(coltsi);
			r1.setData(fmt.parse("21/03/2016"));
			r1.setStatus(StatusReuniao.ENCERRADA);
			r1.setProcessos(procs1);

			Reuniao r2 = new Reuniao();
			r2.setColegiado(coltsi);
			r2.setData(fmt.parse("27/05/2016"));
			r2.setStatus(StatusReuniao.ENCERRADA);
			r2.setProcessos(procs2);

			Reuniao r3 = new Reuniao();
			r3.setColegiado(colredes);
			r3.setData(fmt.parse("27/06/2016"));
			r3.setStatus(StatusReuniao.PLANEJADA);
			r3.setProcessos(procs3);

			rdao.insert(r1);
			rdao.insert(r2);
			rdao.insert(r3);

			rdao.commit();
		} catch (ParseException e) {
			Assert.fail();
		}

	}

	@Test
	public void test09InsereVoto() {
		MembroDAO mdao = new MembroDAO(em);
		Membro m1 = mdao.find(1);
		Membro m2 = mdao.find(2);
		Membro m3 = mdao.find(3);
		Membro m4 = mdao.find(4);
		Membro m5 = mdao.find(5);
		Membro m6 = mdao.find(6);

		ProcessoDAO pdao = new ProcessoDAO(em);
		List<Processo> procs = pdao.find(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

		VotoDAO vdao = new VotoDAO(em);
		Voto v1 = new Voto();
		v1.setVoto(TipoVoto.COM_RELATOR);
		v1.setMembro(m2);
		v1.setProcesso(procs.get(0));

		Voto v2 = new Voto();
		v2.setVoto(TipoVoto.COM_RELATOR);
		v2.setMembro(m3);
		v2.setProcesso(procs.get(0));

		Voto v3 = new Voto();
		v3.setVoto(TipoVoto.COM_RELATOR);
		v3.setMembro(m1);
		v3.setProcesso(procs.get(1));

		Voto v4 = new Voto();
		v4.setVoto(TipoVoto.COM_RELATOR);
		v4.setMembro(m3);
		v4.setProcesso(procs.get(1));

		Voto v5 = new Voto();
		v5.setVoto(TipoVoto.COM_RELATOR);
		v5.setMembro(m1);
		v5.setProcesso(procs.get(2));

		Voto v6 = new Voto();
		v6.setVoto(TipoVoto.COM_RELATOR);
		v6.setMembro(m1);
		v6.setProcesso(procs.get(2));

		Voto v7 = new Voto();
		v7.setVoto(TipoVoto.COM_RELATOR);
		v7.setMembro(m2);
		v7.setProcesso(procs.get(3));

		Voto v8 = new Voto();
		v8.setVoto(TipoVoto.COM_RELATOR);
		v8.setMembro(m3);
		v8.setProcesso(procs.get(3));

		Voto v9 = new Voto();
		v9.setVoto(TipoVoto.COM_RELATOR);
		v9.setMembro(m1);
		v9.setProcesso(procs.get(4));

		Voto v10 = new Voto();
		v10.setVoto(TipoVoto.COM_RELATOR);
		v10.setMembro(m3);
		v10.setProcesso(procs.get(4));

		Voto v11 = new Voto();
		v11.setVoto(TipoVoto.COM_RELATOR);
		v11.setMembro(m1);
		v11.setProcesso(procs.get(5));

		Voto v12 = new Voto();
		v12.setVoto(TipoVoto.DIVERGENTE);
		v12.setMembro(m2);
		v12.setProcesso(procs.get(5));

		Voto v13 = new Voto();
		v13.setVoto(TipoVoto.COM_RELATOR);
		v13.setMembro(m2);
		v13.setProcesso(procs.get(6));

		Voto v14 = new Voto();
		v14.setVoto(TipoVoto.COM_RELATOR);
		v14.setMembro(m3);
		v14.setProcesso(procs.get(6));

		Voto v15 = new Voto();
		v15.setVoto(TipoVoto.COM_RELATOR);
		v15.setMembro(m5);
		v15.setProcesso(procs.get(7));

		Voto v16 = new Voto();
		v16.setVoto(TipoVoto.COM_RELATOR);
		v16.setMembro(m6);
		v16.setProcesso(procs.get(7));

		Voto v17 = new Voto();
		v17.setVoto(TipoVoto.COM_RELATOR);
		v17.setMembro(m4);
		v17.setProcesso(procs.get(8));

		Voto v18 = new Voto();
		v18.setVoto(TipoVoto.COM_RELATOR);
		v18.setMembro(m6);
		v18.setProcesso(procs.get(8));

		Voto v19 = new Voto();
		v19.setVoto(TipoVoto.COM_RELATOR);
		v19.setMembro(m4);
		v19.setProcesso(procs.get(9));

		Voto v20 = new Voto();
		v20.setVoto(TipoVoto.COM_RELATOR);
		v20.setMembro(m5);
		v20.setProcesso(procs.get(9));

		vdao.beginTransaction();
		vdao.insert(v1);
		vdao.insert(v2);
		vdao.insert(v3);
		vdao.insert(v4);
		vdao.insert(v5);
		vdao.insert(v6);
		vdao.insert(v7);
		vdao.insert(v8);
		vdao.insert(v9);
		vdao.insert(v10);
		vdao.insert(v11);
		vdao.insert(v12);
		vdao.insert(v13);
		vdao.insert(v14);
		// vdao.insert(v15);
		// vdao.insert(v16);
		// vdao.insert(v17);
		// vdao.insert(v18);
		// vdao.insert(v19);
		// vdao.insert(v20);

		vdao.commit();
	}

	@Test
	public void test10InsereAdiamento() {
		ProcessoDAO pdao = new ProcessoDAO(em);
		Processo processo = pdao.find(7);
		ReuniaoDAO rdao = new ReuniaoDAO(em);
		Reuniao reuniao = rdao.find(1);

		AdiamentoDAO adao = new AdiamentoDAO(em);
		Adiamento a = new Adiamento();
		a.setMotivo("Relator adoeceu");
		a.setProcesso(processo);
		a.setReuniao(reuniao);
		adao.beginTransaction();
		adao.insert(a);
		adao.commit();
	}

	@Test
	public void test11HistoricoCoordenador() {
		CoordenadorDAO cdao = new CoordenadorDAO(em);
		ProfessorDAO pdao = new ProfessorDAO(em);
		CursoDAO curdao = new CursoDAO(em);
		Curso c = curdao.find(3);  //telematica
		Curso c2 = curdao.find(1);	//TSI
		Professor p4 = pdao.find(4);  //candido

		try {
			cdao.beginTransaction();
			Coordenador coord = new Coordenador();
			coord.setProfessor(p4);
			coord.setDataInicio(fmt.parse("10/02/1999"));
			coord.setDataInicio(fmt.parse("20/10/2002"));
			coord.setNumPortaria("DG-JP 012/1999");
			coord.setCurso(c);
			cdao.insert(coord);
			cdao.commit();
			
			cdao.beginTransaction();
			Coordenador coord2 = new Coordenador();
			coord2.setProfessor(p4);
			coord2.setDataInicio(fmt.parse("22/09/2006"));
			coord2.setDataInicio(fmt.parse("03/04/2008"));
			coord2.setNumPortaria("DG-JP 301/2006");
			coord2.setCurso(c2);
			cdao.insert(coord2);
			cdao.commit();

		} catch (ParseException e) {
			Assert.fail();
		}

	}

}

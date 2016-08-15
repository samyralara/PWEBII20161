package br.edu.ifpb.collegialis.listener;

import java.util.List;

import br.edu.ifpb.collegialis.dao.AssuntoDAO;
import br.edu.ifpb.collegialis.dao.ColegiadoDAO;
import br.edu.ifpb.collegialis.dao.CursoDAO;
import br.edu.ifpb.collegialis.dao.MembroDAO;
import br.edu.ifpb.collegialis.dao.PersistenceUtil;
import br.edu.ifpb.collegialis.dao.ProcessoDAO;
import br.edu.ifpb.collegialis.dao.ReuniaoDAO;
import br.edu.ifpb.collegialis.entity.Assunto;
import br.edu.ifpb.collegialis.entity.Colegiado;
import br.edu.ifpb.collegialis.entity.Curso;
import br.edu.ifpb.collegialis.entity.Membro;
import br.edu.ifpb.collegialis.entity.Processo;
import br.edu.ifpb.collegialis.entity.Professor;
import br.edu.ifpb.collegialis.entity.Reuniao;

public class UtilBean {

	public List<Curso> getCursos() {
		CursoDAO dao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
		List<Curso> cursos = dao.findAll();
		return cursos;
	}
	
	public List<Colegiado> getColegiados() {
		ColegiadoDAO dao = new ColegiadoDAO(PersistenceUtil.getCurrentEntityManager());
		List<Colegiado> colegiados = dao.findAll();
		return colegiados;
	}
	public List<Assunto> getAssuntos() {
		AssuntoDAO dao = new AssuntoDAO(PersistenceUtil.getCurrentEntityManager());
		List<Assunto> assuntos = dao.findAll();
		return assuntos;
	}
	public List<Processo> getProcessos() {
		ProcessoDAO dao = new ProcessoDAO(PersistenceUtil.getCurrentEntityManager());
		List<Processo> processos = dao.findAll();
		return processos;
		
	}
	//Retorna os membros de um determinado colegiado
	public List<Membro> getMembrosColegiado(int id) {
		//coordenador join curso join colegiado e pega os membros
		CursoDAO dao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
		//vefifica se o membro é professor aqui
		List<Membro> membros = dao.findAllMembros(id);
		return membros;
	}
	//Retorna os Processos de uma determinada reunião. 
	public List<Processo> getProcessosReuniao(int id){
		ProcessoDAO dao = new ProcessoDAO(PersistenceUtil.getCurrentEntityManager());
		List<Processo> processosReu = dao.findProcessosReu(id);
		return processosReu;
		
	}
	//Retorna um processo pelo numero
	public List<Processo> getProcessoNumero(int id){
		ProcessoDAO dao = new ProcessoDAO(PersistenceUtil.getCurrentEntityManager());
		List<Processo> processosNu = dao.findProcessoNumero(id);
		return processosNu;
	}
	//Retorna um processos sem reuniao de um colegiado
		public List<Processo> getProcessoSemReuniao(int id){
			ProcessoDAO dao = new ProcessoDAO(PersistenceUtil.getCurrentEntityManager());
			List<Processo> processosSemReu = dao.findProcessosSemReu(id);
			return processosSemReu;
		}
	
	
}

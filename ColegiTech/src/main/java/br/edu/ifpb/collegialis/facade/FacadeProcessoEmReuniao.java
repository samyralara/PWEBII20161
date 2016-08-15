package br.edu.ifpb.collegialis.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.collegialis.dao.AlunoDAO;
import br.edu.ifpb.collegialis.dao.AssuntoDAO;
import br.edu.ifpb.collegialis.dao.MembroDAO;
import br.edu.ifpb.collegialis.dao.PersistenceUtil;
import br.edu.ifpb.collegialis.dao.ProcessoDAO;
import br.edu.ifpb.collegialis.dao.VotoDAO;
import br.edu.ifpb.collegialis.entity.Aluno;
import br.edu.ifpb.collegialis.entity.Assunto;
import br.edu.ifpb.collegialis.entity.Membro;
import br.edu.ifpb.collegialis.entity.Processo;
import br.edu.ifpb.collegialis.entity.Voto;
import br.edu.ifpb.collegialis.type.TipoDecisao;
import br.edu.ifpb.collegialis.type.TipoVoto;

public class FacadeProcessoEmReuniao {
	
	private Processo processo;
	private Voto voto;
	//public enum TipoDecisao{DEFERIDO, INDEFERIDO;}

	
	private List<String> mensagensErro;
	private TipoDecisao DEFERIDO;
	private TipoDecisao INDEFERIDO;
	private TipoVoto COM_RELATOR;
	private TipoVoto DIVERGENTE;
	
	public Resultado atualizar(Map<String, String[]> parametros) {
		
		Resultado resultado = new Resultado();
		
		// Se passar na validacao, o objeto Colegiado pode ser persistido
		if (this.validarParametros(parametros)) {
			ProcessoDAO dao = new ProcessoDAO(PersistenceUtil.getCurrentEntityManager());
			VotoDAO vdaoo = new VotoDAO(PersistenceUtil.getCurrentEntityManager());
			vdaoo.beginTransaction();
			dao.beginTransaction();
			dao.insert(this.processo);
			vdaoo.insert(this.voto);
			dao.commit();
			vdaoo.commit();
			resultado.setErro(false);
			resultado.setMensagensErro(Collections.singletonList("Processo finalizado com sucesso"));
		} else {
			resultado.setEntitade(this.processo);
			resultado.setErro(true);
			resultado.setMensagensErro(this.mensagensErro);
		}
		return resultado;
	}
	
	private boolean validarParametros(Map<String, String[]> parametros) {
		
		// Parametros do form para criar um processo
		String[] pronum = parametros.get("pronum");
		String[] votoMembro = parametros.get("votoMembro");
		String[] comorelator = parametros.get("comorelator");
		String[] divergente = parametros.get("divergente");
		String[] ausente = parametros.get("ausente");
		String[] parecer = parametros.get("parecer");
		String[] decisao = parametros.get("decisao");
		//String[] descricaoAlu = parametros.get("descricaoAlu");

		this.processo = new Processo();
		this.voto = new Voto();
		this.mensagensErro = new ArrayList<String>();
		String pronumm = pronum[0]; 
		int pronumint = Integer.parseInt(pronumm);
		System.out.println(votoMembro.length);
		
		
		if (comorelator != null && comorelator.length != 0 && !comorelator[0].isEmpty()) {
			MembroDAO Mdao = new MembroDAO(PersistenceUtil.getCurrentEntityManager());
			Membro membro = new Membro();
			List<Membro> membros = (List<Membro>) Mdao.findAll();		
			for( Membro var : membros){
				if(var.getProfessor().getNome().equals(votoMembro)){
					this.voto.setMembro(var);
					this.voto.setProcesso(processo);
					this.voto.setVoto(COM_RELATOR);
				}
				
			}
		}
			
			if (divergente != null && divergente.length != 0 && !divergente[0].isEmpty()) {
				MembroDAO mdao = new MembroDAO(PersistenceUtil.getCurrentEntityManager());
				Membro membross = new Membro();
				List<Membro> membrosss = (List<Membro>) mdao.findAll();		
				for( Membro var : membrosss){
					if(var.getProfessor().getNome().equals(votoMembro)){
						this.voto.setMembro(var);
						this.voto.setProcesso(processo);
						this.voto.setVoto(DIVERGENTE);
					}
					
			}
		}
			if (ausente != null && ausente.length != 0 && !ausente[0].isEmpty()) {
				MembroDAO medao = new MembroDAO(PersistenceUtil.getCurrentEntityManager());
				Membro membrosds = new Membro();
				List<Membro> membrossds = (List<Membro>) medao.findAll();		
				for( Membro var : membrossds){
					if(var.getProfessor().getNome().equals(votoMembro)){
						this.voto.setMembro(var);
						this.voto.setProcesso(processo);
						this.voto.setAusente(true);
					}
						
				}
			}
			
			
			
			if (votoMembro != null && decisao.length != 0 && !decisao[0].isEmpty()) {
				ProcessoDAO pro = new ProcessoDAO(PersistenceUtil.getCurrentEntityManager());
				Processo pros = pro.find(pronumint);
				if(decisao[0].contains("deferido")){
					//br.edu.ifpb.collegialis.type.TipoDecisao decisaoo = DEFERIDO;
					pros.setDecisao(DEFERIDO);
				}
				else{
					//br.edu.ifpb.collegialis.type.TipoDecisao INDEFERIDO = null;
					pros.setDecisao(INDEFERIDO);
				}
			}

		// Se algum relator foi selecionado, busca-o na base de dados
		if (decisao != null && decisao.length != 0 && !decisao[0].isEmpty()) {
			ProcessoDAO pro = new ProcessoDAO(PersistenceUtil.getCurrentEntityManager());
			Processo pros = pro.find(pronumint);
			if(decisao[0].contains("deferido")){
				//br.edu.ifpb.collegialis.type.TipoDecisao decisaoo = DEFERIDO;
				pros.setDecisao(DEFERIDO);
			}
			else{
				//br.edu.ifpb.collegialis.type.TipoDecisao INDEFERIDO = null;
				pros.setDecisao(INDEFERIDO);
			}
		}
			
		//Guarda a data da decisao do processo
		Date atual = new Date();
		SimpleDateFormat df;
		df = new SimpleDateFormat("yyyy-MM-dd");
		this.processo.setDataParecer(atual);

		return this.mensagensErro.isEmpty();
	}

}

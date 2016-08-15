package br.edu.ifpb.collegialis.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.edu.ifpb.collegialis.dao.ColegiadoDAO;
import br.edu.ifpb.collegialis.dao.CursoDAO;
import br.edu.ifpb.collegialis.dao.PersistenceUtil;
import br.edu.ifpb.collegialis.dao.ProcessoDAO;
import br.edu.ifpb.collegialis.dao.ReuniaoDAO;
import br.edu.ifpb.collegialis.entity.Colegiado;
import br.edu.ifpb.collegialis.entity.Curso;
import br.edu.ifpb.collegialis.entity.Processo;
import br.edu.ifpb.collegialis.entity.Reuniao;

public class FacadeReuniao {
	
	private Reuniao reuniao;
	
	private List<String> mensagensErro;
	
	public Resultado cadastrar(Map<String, String[]> parametros) {
		
		Resultado resultado = new Resultado();
		
		// Se passar na validacao, o objeto Colegiado pode ser persistido
		if (this.validarParametros(parametros)) {
			ReuniaoDAO dao = new ReuniaoDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			dao.insert(this.reuniao);
			dao.commit();
			resultado.setErro(false);
			resultado.setMensagensErro(Collections.singletonList("Colegiado criado com sucesso"));
		} else {
			resultado.setEntitade(this.reuniao);
			resultado.setErro(true);
			resultado.setMensagensErro(this.mensagensErro);
		}
		return resultado;
	}

	public Resultado atualizar(Map<String, String[]> parametros) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean validarParametros(Map<String, String[]> parametros) {
		// Parametros do form para criar um colegiado
		String[] datareuniao = parametros.get("datareuniao");
		String[] curso = parametros.get("curso");
		String[] processo = parametros.get("processo");
		
		this.reuniao = new Reuniao();
		
		this.mensagensErro = new ArrayList<String>();
		
		
		// Data é obrigatória
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (datareuniao == null || datareuniao.length == 0 || datareuniao[0].isEmpty()) {
			this.mensagensErro.add("Data início é campo obrigatório!");
		} else {
			try {
				Date dataReuniao = sdf.parse(datareuniao[0]);
				this.reuniao.setData(dataReuniao);
			} catch (ParseException e) {
				this.mensagensErro.add("Formato inválido para a data início");
			}
		}
		
		if (processo != null && processo.length != 0 && !processo[0].isEmpty()) {
			int i;
			ReuniaoDAO dao = new ReuniaoDAO(PersistenceUtil.getCurrentEntityManager());
			ProcessoDAO daop = new ProcessoDAO(PersistenceUtil.getCurrentEntityManager());
			for(i=0; i<processo.length; i++){
				Processo p = daop.find(Integer.parseInt(processo[0]));
				p.setReuniao(reuniao);
				//this.reuniao.setProcessos(processo);
				}
		}
		
		//this.colegiado.setAtivo(true);
		return this.mensagensErro.isEmpty();

	}

}

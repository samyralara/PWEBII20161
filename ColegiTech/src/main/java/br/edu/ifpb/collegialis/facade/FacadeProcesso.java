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
import br.edu.ifpb.collegialis.entity.Aluno;
import br.edu.ifpb.collegialis.entity.Assunto;
import br.edu.ifpb.collegialis.entity.Membro;
import br.edu.ifpb.collegialis.entity.Processo;

public class FacadeProcesso {
	
	private Processo processo;
	
	private List<String> mensagensErro;
	
	public Resultado cadastrar(Map<String, String[]> parametros) {
		
		Resultado resultado = new Resultado();
		
		// Se passar na validacao, o objeto Colegiado pode ser persistido
		if (this.validarParametros(parametros)) {
			ProcessoDAO dao = new ProcessoDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			dao.insert(this.processo);
			dao.commit();
			resultado.setErro(false);
			resultado.setMensagensErro(Collections.singletonList("Processo criado com sucesso"));
		} else {
			resultado.setEntitade(this.processo);
			resultado.setErro(true);
			resultado.setMensagensErro(this.mensagensErro);
		}
		return resultado;
	}

	public Resultado atualizar(Map<String, String[]> parametros) {
		Resultado resultado = new Resultado();
		
		if(this.validarParametros(parametros)){
		ProcessoDAO dao = new ProcessoDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		dao.update(this.processo);
		dao.commit();
		resultado.setErro(false);
		resultado.setMensagensErro(Collections.singletonList("Processo atualizado com sucesso"));
	} else {
		resultado.setEntitade(this.processo);
		resultado.setErro(true);
		resultado.setMensagensErro(this.mensagensErro);
	}
	return resultado;
	}
	
	private boolean validarParametros(Map<String, String[]> parametros) {
		// Parametros do form para criar um processo
		String[] numero = parametros.get("numero");
		String[] matricula = parametros.get("matricula");
		String[] assunto = parametros.get("assunto");
		String[] relator = parametros.get("relator");
		String[] descricaoAlu = parametros.get("descricaoAlu");

		this.processo = new Processo();
		this.mensagensErro = new ArrayList<String>();
		
		// Numero é obrigatorio
		if (numero == null || numero.length == 0 || numero[0].isEmpty()) {
			this.mensagensErro.add("Número é campo obrigatório!");
			} else {
				this.processo.setNumero(numero[0]);
		}

		// Matricula é obrigatorio
		if (matricula == null || matricula.length == 0 || matricula[0].isEmpty()) {
			this.mensagensErro.add("Matricula é campo obrigatório!");
		} else {
			//fazer pesquisa da matricula do aluno
			AlunoDAO dao = new AlunoDAO(PersistenceUtil.getCurrentEntityManager());
			Aluno a = dao.BuscaMat(matricula[0]);
			if(a!= null){
				this.processo.setRequisitante(a);
			}
			else{
				this.mensagensErro.add("Matrícula inválida!");
			}
		}
		// Se algum assunto foi selecionado, busca-o na base de dados
		if (assunto != null && assunto.length != 0 && !assunto[0].isEmpty()) {
			AssuntoDAO dao = new AssuntoDAO(PersistenceUtil.getCurrentEntityManager());
			Assunto as = dao.find(Integer.parseInt(assunto[0]));
			this.processo.setAssunto(as);
		}
		// Se algum relator foi selecionado, busca-o na base de dados
		if (relator != null && relator.length != 0 && !relator[0].isEmpty()) {
			MembroDAO dao = new MembroDAO(PersistenceUtil.getCurrentEntityManager());
			Membro m = dao.find(Integer.parseInt(relator[0]));
			this.processo.setRelator(m);
		}
		// Colocar aqui a parte que guarda a descricao feita pelo aluno
		if (descricaoAlu != null && descricaoAlu.length != 0 && !descricaoAlu[0].isEmpty()){
			byte[] descricaoAluByte = descricaoAlu[0].getBytes();
			this.processo.setDescricaoAlu(descricaoAluByte);
		}
		//Guarda a data da recepção do processo
		Date atual = new Date();
		SimpleDateFormat df;
		df = new SimpleDateFormat("yyyy-MM-dd");
		this.processo.setDataRecepcao(atual);

		return this.mensagensErro.isEmpty();
	}


}

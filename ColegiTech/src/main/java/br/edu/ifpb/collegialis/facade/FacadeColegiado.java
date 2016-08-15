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
import br.edu.ifpb.collegialis.entity.Colegiado;
import br.edu.ifpb.collegialis.entity.Curso;

public class FacadeColegiado {
	
	private Colegiado colegiado;
	
	private List<String> mensagensErro;
	
	public Resultado cadastrar(Map<String, String[]> parametros) {
		
		Resultado resultado = new Resultado();
		
		// Se passar na validacao, o objeto Colegiado pode ser persistido
		if (this.validarParametros(parametros)) {
			ColegiadoDAO dao = new ColegiadoDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			dao.insert(this.colegiado);
			dao.commit();
			resultado.setErro(false);
			resultado.setMensagensErro(Collections.singletonList("Colegiado criado com sucesso"));
		} else {
			resultado.setEntitade(this.colegiado);
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
		String[] descricao = parametros.get("descricao");
		String[] portaria = parametros.get("portaria");
		String[] dataini = parametros.get("dataini");
		String[] datafim = parametros.get("datafim");
		String[] curso = parametros.get("curso");
		
		this.colegiado = new Colegiado();
		
		this.mensagensErro = new ArrayList<String>();
		
		// Descricao é obrigatorio
		if (descricao == null || descricao.length == 0 || descricao[0].isEmpty()) {
			this.mensagensErro.add("Descricao é campo obrigatório!");
		} else {
			this.colegiado.setDescricao(descricao[0]);
		}
		
		// Data inicio é obrigatória
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (dataini == null || dataini.length == 0 || dataini[0].isEmpty()) {
			this.mensagensErro.add("Data início é campo obrigatório!");
		} else {
			try {
				Date dataIni = sdf.parse(dataini[0]);
				this.colegiado.setDataInicio(dataIni);
			} catch (ParseException e) {
				this.mensagensErro.add("Formato inválido para a data início");
			}
		}
		
		//Data fim é obrigatória
		if (datafim == null || datafim.length == 0 || datafim[0].isEmpty()) {
			this.mensagensErro.add("Data fim é campo obrigatório!");
		} else {
			try {
				Date dataFim = sdf.parse(datafim[0]);
				this.colegiado.setDataFim(dataFim);
			} catch (ParseException e) {
				this.mensagensErro.add("Formato inválido para a data início");
			}
		}
		
		// Define a portaria
		if (portaria != null && portaria.length != 0 && !portaria[0].isEmpty())
		this.colegiado.setPortaria(portaria[0]);
		
		// Se algum curso foi selecionado, busca-o na base de dados
		if (curso != null && curso.length != 0 && !curso[0].isEmpty()) {
			CursoDAO dao = new CursoDAO(PersistenceUtil.getCurrentEntityManager());
			Curso c = dao.find(Integer.parseInt(curso[0]));
			this.colegiado.setCurso(c);
		}
		
		this.colegiado.setAtivo(true);
		return this.mensagensErro.isEmpty();

	}
	

}

package br.edu.ifpb.collegialis.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.collegialis.entity.Adiamento;

public class AdiamentoDAO extends GenericDAO<Adiamento, Integer> {

	public AdiamentoDAO() {
		super();
	}

	public AdiamentoDAO(EntityManager em) {
		super(em);
	}
	

}

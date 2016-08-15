package br.edu.ifpb.collegialis.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.collegialis.entity.Voto;

public class VotoDAO extends GenericDAO<Voto, Integer> {

	public VotoDAO() {
		super();
	}

	public VotoDAO(EntityManager em) {
		super(em);
	}
	

}

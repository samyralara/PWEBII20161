package br.edu.ifpb.collegialis.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.edu.ifpb.collegialis.entity.Perfil;

public class PerfilDAO extends GenericDAO<Perfil, Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	public PerfilDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerfilDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
}

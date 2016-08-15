package br.edu.ifpb.collegialis.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.collegialis.entity.Processo;
import br.edu.ifpb.collegialis.entity.Reuniao;

public class ReuniaoDAO extends GenericDAO<Reuniao, Integer> {

	public ReuniaoDAO() {
		super();
	}

	public ReuniaoDAO(EntityManager em) {
		super(em);
	}


}

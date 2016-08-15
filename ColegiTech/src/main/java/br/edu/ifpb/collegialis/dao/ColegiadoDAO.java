package br.edu.ifpb.collegialis.dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.edu.ifpb.collegialis.entity.Colegiado;

public class ColegiadoDAO extends GenericDAO<Colegiado, Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ColegiadoDAO() {
		super();
	}

	public ColegiadoDAO(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Colegiado> findAll() throws DAOException {
		try {
		Query q = this.getEntityManager().createQuery("from Colegiado c order by c.descricao asc");
		return (List<Colegiado>) q.getResultList();
		} catch(PersistenceException e) {
			throw new DAOException("Não foi possível obter todos os coordenadores do banco. " + e.getMessage());
		}
	}

}

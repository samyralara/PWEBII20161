package br.edu.ifpb.collegialis.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.edu.ifpb.collegialis.entity.Coordenador;

public class CoordenadorDAO extends GenericDAO<Coordenador, Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	public CoordenadorDAO() {
		super();
	}

	public CoordenadorDAO(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Coordenador> findSemCurso() throws DAOException {
		try {
			Query q = this.getEntityManager().createQuery("from Coordenador c where c.curso is null order by c.professor.nome asc");
			return (List<Coordenador>) q.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("Não foi possível obter todos os coordenadores do banco. " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Coordenador> findAll() throws DAOException {
		try {
			Query q = this.getEntityManager().createQuery("from Coordenador c order by c.professor.nome asc");
			return (List<Coordenador>) q.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("Não foi possível obter todos os coordenadores do banco. " + e.getMessage());
		}
	}

	
}

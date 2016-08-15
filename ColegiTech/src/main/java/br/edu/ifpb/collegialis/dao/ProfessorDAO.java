package br.edu.ifpb.collegialis.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.edu.ifpb.collegialis.entity.Professor;

public class ProfessorDAO extends GenericDAO<Professor, Integer> implements Serializable{
	private static final long serialVersionUID = 1L;

	public ProfessorDAO() {
		super();
	}

	public ProfessorDAO(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> findAll() throws DAOException {
		try {
		Query q = this.getEntityManager().createQuery("from Professor p order by p.nome asc");
		return (List<Professor>) q.getResultList();
		} catch(PersistenceException e) {
			throw new DAOException("Não foi possível obter todos os professores do banco. " + e.getMessage());
		}
	}

}

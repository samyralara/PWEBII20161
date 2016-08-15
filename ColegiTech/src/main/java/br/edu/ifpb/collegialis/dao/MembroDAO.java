package br.edu.ifpb.collegialis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.edu.ifpb.collegialis.entity.Membro;
import br.edu.ifpb.collegialis.entity.Processo;

public class MembroDAO extends GenericDAO<Membro, Integer> {

	public MembroDAO() {
		super();
	}

	public MembroDAO(EntityManager em) {
		super(em);
	}
	public List<Membro> findAll() throws DAOException {
		try {
		Query q = this.getEntityManager().createQuery("select nome from Professor p JOIN Membro m where m.id = p.id");
		return (List<Membro>) q.getResultList();
		} catch(PersistenceException e) {
			throw new DAOException("Não foi possível obter todos os membros deste colegiado. " + e.getMessage());
		}
	}
}

package br.edu.ifpb.collegialis.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.edu.ifpb.collegialis.entity.Aluno;

public class AlunoDAO extends GenericDAO<Aluno, Integer> implements Serializable{
	private static final long serialVersionUID = 1L;

	public AlunoDAO() {
		super();
	}

	
	public AlunoDAO(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> findAll() throws DAOException {
		try {
		Query q = this.getEntityManager().createQuery("from Aluno a order by a.nome asc");
		return (List<Aluno>) q.getResultList();
		} catch(PersistenceException e) {
			throw new DAOException("Não foi possível obter todos os alunos do banco. " + e.getMessage());
		}
	}
	
	public Aluno BuscaMat(String matricula) throws DAOException {
		try {
			Query q = this.getEntityManager().createQuery("from Aluno a where a.matricula = :matricula");
			q.setParameter("matricula", matricula);
			Aluno alu = (Aluno) q.getSingleResult();
			return alu;
		} catch(PersistenceException e) {
			throw new DAOException("Não foi possível obter a mastricula do alunos no banco. " + e.getMessage());
		}
	}
	
	


}

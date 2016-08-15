package br.edu.ifpb.collegialis.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.edu.ifpb.collegialis.entity.Coordenador;
import br.edu.ifpb.collegialis.entity.Curso;
import br.edu.ifpb.collegialis.entity.Membro;
import br.edu.ifpb.collegialis.entity.Professor;

public class CursoDAO extends GenericDAO<Curso, Integer> implements Serializable{
	private static final long serialVersionUID = 1L;


	public CursoDAO() {
		super();
	}

	public CursoDAO(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> findAll() throws DAOException {
		try {
		Query q = this.getEntityManager().createQuery("from Curso a order by a.nome asc");
		return (List<Curso>) q.getResultList();
		} catch(PersistenceException e) {
			throw new DAOException("Não foi possível obter todos os cursos do banco. " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Coordenador> selectHistorico(Curso curso) {
		try {
			Query q = this.getEntityManager().createQuery("from Coordenador c where c.curso = :curso order by c.dataInicio desc");
			q.setParameter("curso", curso);
			return q.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("Não foi possível obter histórico do coordenador. " + e.getMessage());
		}
	}
	public List<Membro> findAllMembros(int id){
		Query q = this.getEntityManager().createQuery("select c.membros from Colegiado c where c.curso.id =(select cord.curso.id from Coordenador cord where cord.id=:id)");
		q.setParameter("id", id);
		return (List<Membro>) q.getResultList(); 
	}
}

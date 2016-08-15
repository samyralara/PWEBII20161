package br.edu.ifpb.collegialis.dao;


import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.edu.ifpb.collegialis.entity.Assunto;
import br.edu.ifpb.collegialis.entity.Processo;

public class ProcessoDAO extends GenericDAO<Processo, Integer> {

	public ProcessoDAO() {
		super();
	}

	public ProcessoDAO(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Processo> find(Integer[] ids) {
		Query q = this.getEntityManager().createQuery("from Processo where id IN :ids");
		q.setParameter("ids", Arrays.asList(ids));
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Processo> findAll() throws DAOException {
		try {
		Query q = this.getEntityManager().createQuery("from Processo p order by p.numero asc");
		return (List<Processo>) q.getResultList();
		} catch(PersistenceException e) {
			throw new DAOException("Não foi possível obter todos os processos do banco. " + e.getMessage());
		}
	}
	public List<Processo> findProcessosReu(int id) {
		Query q = this.getEntityManager().createQuery("from Processo p where p.reuniao.id = :id");
		q.setParameter("id",id);
		return q.getResultList();
	}
	public List<Processo> findProcessoNumero(int id){
		Query q = this.getEntityManager().createQuery("from Processo p where p.id=:id");
		q.setParameter("id", id);
		return q.getResultList();
	}
	public List<Processo> findProcessosSemReu(int id) {
		Query q = this.getEntityManager().createQuery("from Processo p where p.reuniao.id = NULL AND p.membros.colegiado.id = :id");
		q.setParameter("id",id);
		return q.getResultList();
	}

}

package br.edu.ifpb.collegialis.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.collegialis.entity.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Integer> {
	
	public UsuarioDAO() {
		super();
	}

	public UsuarioDAO(EntityManager em) {
		super(em);
	}

	public Usuario findByLogin(String login) {
		Query q = this.getEntityManager().createQuery("select u from Usuario u where u.email = :login");
		q.setParameter("login", login);
		return (Usuario) q.getSingleResult();
	}
	
}

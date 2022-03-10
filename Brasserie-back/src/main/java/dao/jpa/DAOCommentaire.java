package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOCommentaire;
import model.Biere;
import model.Commentaire;
import util.Context;

public class DAOCommentaire implements IDAOCommentaire {

	public Commentaire findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Commentaire c = em.find(Commentaire.class, id);
		em.close();
		return c;
	}

	public List<Commentaire> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Commentaire> commentaires = em.createQuery("SELECT c FROM Commentaire c").getResultList();
		em.close();
		return commentaires;
	}

	public Commentaire save(Commentaire c) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			c = em.merge(c);
			em.getTransaction().commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		em.close();
		return c;
	}

	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Commentaire c = em.find(Commentaire.class, id);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

}

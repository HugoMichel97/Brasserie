package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOEvenements;
import model.Evenement;
import util.Context;
	
public class DAOEvenements implements IDAOEvenements{

	@Override
	public Evenement findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Evenement e = em.find(Evenement.class, id);
		em.close();
		return e;
	}

	@Override
	public List<Evenement> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Evenement> evenements = em.createQuery("SELECT e from Evenement e").getResultList();
		em.close();
		return evenements;
	}

	@Override
	public Evenement save(Evenement e) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		e = em.merge(e);
		em.getTransaction().commit();
		em.close();
		return e;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Evenement e = em.find(Evenement.class, id);
		em.remove(e);
		em.getTransaction().commit();
		em.close();
		
	}
	
	
}

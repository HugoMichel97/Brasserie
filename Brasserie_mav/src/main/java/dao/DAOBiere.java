package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Biere;
import util.Context;

public class DAOBiere implements IDAOBiere {

	public Biere findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Biere b = em.find(Biere.class, id);
		em.close();
		return b;
	}

	public List<Biere> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Biere> bieres = em.createQuery("SELECT b from Biere b").getResultList();
		em.close();
		return bieres;
	}

	public Biere save(Biere b) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		
		try 
		{
			em.getTransaction().begin();
			b = em.merge(b);
			em.getTransaction().commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		em.close();
		return b;
	}

	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Biere b = em.find(Biere.class, id);
		em.remove(b);
		em.getTransaction().commit();
		em.close();
		
	}

}

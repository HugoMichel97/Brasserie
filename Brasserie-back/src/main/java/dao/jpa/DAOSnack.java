package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOSnack;
import model.Note;
import model.Snack;
import util.Context;

public class DAOSnack implements IDAOSnack {

	public Snack findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Snack s = em.find(Snack.class, id);
		em.close();
		return s;
	}

	public List<Snack> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Snack> snacks = em.createQuery("SELECT s FROM Snack s").getResultList();
		em.close();
		return snacks;
	}

	public Snack save(Snack s) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			s = em.merge(s);
			em.getTransaction().commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		em.close();
		return s;
	}
	

	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Snack s = em.find(Snack.class, id);
		em.remove(s);
		em.getTransaction().commit();
		em.close();
		
	}

}

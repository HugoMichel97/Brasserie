package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOAchat;
import model.Biere;
import model.Client;
import model.Achat;
import util.Context;

public class DAOAchat implements IDAOAchat {

	@Override
	public Achat findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Achat a = em.find(Achat.class, id);
		em.close();
		return a;
	}

	@Override
	public List<Achat> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Achat> achats = em.createQuery("SELECT a from Achat a").getResultList();
		em.close();
		return achats;
	}

	@Override
	public Achat save(Achat a) {
EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		
		try 
		{
			em.getTransaction().begin();
			a = em.merge(a);
			em.getTransaction().commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		em.close();
		return a;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Biere b = em.find(Biere.class, id);
		em.remove(b);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Achat> findByIdClient(Integer id) 
	{
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT a from Achat a where a.client.id = :id");
		q.setParameter("id", id);
		List<Achat> achats = q.getResultList();
		em.close();
		return achats;
	}

}	
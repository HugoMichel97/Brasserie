package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOInfoReglement;
import model.InfoReglement;
import util.Context;

public class DAOInfoReglement implements IDAOInfoReglement {

	@Override
	public InfoReglement findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		InfoReglement r = em.find(InfoReglement.class, id);
		em.close();
		return r;
	}

	@Override
	public List<InfoReglement> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<InfoReglement> reglements = em.createQuery("SELECT r from InfoReglement r").getResultList();
		em.close();
		return reglements;
	}

	public InfoReglement save(InfoReglement r) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		
		try 
		{
			em.getTransaction().begin();
			r = em.merge(r);
			em.getTransaction().commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		em.close();
		return r;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		InfoReglement r = em.find(InfoReglement.class, id);
		em.remove(r);
		em.getTransaction().commit();
		em.close();
	}

}

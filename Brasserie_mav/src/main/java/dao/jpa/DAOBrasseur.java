package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOBrasseur;
import model.Brasseur;
import model.Brasseur;
import util.Context;

public class DAOBrasseur implements IDAOBrasseur {

	@Override
	public Brasseur findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Brasseur b = em.find(Brasseur.class, id);
		em.close();
		return b;
	}

	@Override
	public List<Brasseur> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Brasseur> brasseurs = em.createQuery("SELECT b from Brasseur b").getResultList();
		em.close();
		return brasseurs;
	}

	public Brasseur save(Brasseur b) {
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

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Brasseur b = em.find(Brasseur.class, id);
		em.remove(b);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Brasseur seConnecter(String mail, String password) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Query q = em.createQuery("SELECT b from Brasseur b where b.mail = :mail and b.password = :password");
		q.setParameter("mail", mail);
		q.setParameter("password", password);
		Brasseur b=null;
		try {
			b = (Brasseur) q.getSingleResult();

		} catch (Exception e) {

		}
		em.close();
		return b;
	}

}

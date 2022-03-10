package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOProduits;
import model.Biere;
import model.Produits;
import util.Context;

public class DAOProduits implements IDAOProduits {

	@Override
	public Produits findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Produits p = em.find(Produits.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Produits> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Produits> produits = em.createQuery("SELECT p from Produits p").getResultList();
		em.close();
		return produits;
	}

	@Override
	public Produits save(Produits p) {
EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		
		try 
		{
			em.getTransaction().begin();
			p = em.merge(p);
			em.getTransaction().commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		em.close();
		return p;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Produits p = em.find(Produits.class, id);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}

}

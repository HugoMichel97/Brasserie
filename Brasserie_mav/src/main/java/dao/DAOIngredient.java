package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Biere;
import model.Ingredient;
import util.Context;

public class DAOIngredient implements IDAOIngredient {

	@Override
	public Ingredient findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Ingredient i = em.find(Ingredient.class, id);
		em.close();
		return i;
	}

	@Override
	public List<Ingredient> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Ingredient> ingredients = em.createQuery("SELECT i from Ingredient i").getResultList();
		em.close();
		return ingredients;
	}

	@Override
	public Ingredient save(Ingredient i) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			i = em.merge(i);
			em.getTransaction().commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		em.close();
		return i;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Ingredient i = em.find(Ingredient.class, id);
		em.remove(i);
		em.getTransaction().commit();
		em.close();
		
	}

}

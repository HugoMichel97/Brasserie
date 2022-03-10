package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Commentaire;
import model.Note;
import util.Context;

public class DAONote implements IDAONote {

	public Note findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Note n = em.find(Note.class, id);
		em.close();
		return n;
	}

	public List<Note> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Note> notes = em.createQuery("SELECT n FROM Note n").getResultList();
		em.close();
		return notes;
	}

	public Note save(Note n) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			n = em.merge(n);
			em.getTransaction().commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		em.close();
		return n;
	}

	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Note n = em.find(Note.class, id);
		em.remove(n);
		em.getTransaction().commit();
		em.close();
		
	}

}

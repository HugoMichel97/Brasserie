package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Biere;
import model.Note;
import model.Snack;

public class TestJPA {

	public static void main(String[] args) {
		
		Biere b1 = new Biere("Biere du test ", 3.5);
		
		List<Note> notes = new ArrayList();
		Note n1 = new Note(b1, 8.0);
		Note n2 = new Note(b1, 4.5);
		
		Collections.addAll(notes, n1, n2);
		
		b1.setNotes(notes);
		
		Snack s1 = new Snack("Snack du test", 2.0);
		
		
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("brasserie");
		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(n1);
		em.persist(n2);
		
		em.persist(b1);
		em.persist(s1);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}

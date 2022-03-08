package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Biere;

public class TestJPA {

	public static void main(String[] args) {
		
		List<Double> notes = new ArrayList();
		Double n1 = 8.0;
		Double n2 = 4.5;
		Collections.addAll(notes, n1, n2);
		
		Biere b1 = new Biere("Biere du test ", 3.5, notes);
		
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("brasserie");
		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(b1);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}

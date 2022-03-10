package test;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Biere;
import model.Commentaire;
import model.Ingredient;
import model.Note;
import model.Snack;

public class TestJPA {

	public static void main(String[] args) {
		
		Biere b1 = new Biere("Biere du test ", 3.5);
		
		// Test gestion notes
		List<Note> notes = new ArrayList();
		Note n1 = new Note(b1, 8.0);
		Note n2 = new Note(b1, 4.5);
		
		Collections.addAll(notes, n1, n2);
		
		b1.setNotes(notes);
		
		// Test gestion ingr�dients
		Ingredient i1 = new Ingredient("Houblon", 50);
		Ingredient i2 = new Ingredient("Levure", 3);
		
		List<Ingredient> recette1 = new ArrayList();
		Collections.addAll(recette1, i1, i2);
		b1.setRecette(recette1);
		
		// Test snack
		Snack s1 = new Snack("Snack du test", 2.0);
		Snack s2 = new Snack("Moelleux au citron", 6.0);
		
		List<Snack> sugg1 = new ArrayList();
		Collections.addAll(sugg1, s1, s2);
		b1.setSuggestions(sugg1);
		
		// Test commentaires 
		Commentaire c1 = new Commentaire(b1, "Superbe bi�re");
		Commentaire c2 = new Commentaire(b1, "Atroce" );
		
		List<Commentaire> coms = new ArrayList();
		Collections.addAll(coms, c1, c2);
		b1.setCommentaires(coms);
 		
		
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("brasserie");
		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(n1);
		em.persist(n2);
		
		em.persist(i1);
		em.persist(i2);
		
		em.persist(s1);
		em.persist(s2);
		
		em.persist(c1);
		em.persist(c2);
		
		em.persist(b1);
		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}

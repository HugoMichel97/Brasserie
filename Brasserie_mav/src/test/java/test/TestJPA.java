package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Brasseur;
import model.Client;
import model.InfoReglement;

public class TestJPA {

	public static void main(String[] args) {
		
		Brasseur ptitBrasseur = new Brasseur("Arthur@test", "brasseur");
		Client claTe = new Client("ClaTe@test", "client");
		claTe.setTel("0634982356");
		Client c = new Client("test@test", "test");
		InfoReglement testReg = new InfoReglement(c, "666", "Jonh Doe", "10/23");
		List<InfoReglement> regList = new ArrayList();
		regList.add(testReg);
		c.setReglements(regList);
		
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("brasserie");
		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(ptitBrasseur);
		em.persist(claTe);
		em.persist(c);
		em.persist(testReg);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}

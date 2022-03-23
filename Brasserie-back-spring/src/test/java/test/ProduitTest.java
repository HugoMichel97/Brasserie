package test;

import static org.junit.jupiter.api.Assertions.fail;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import brasserie.config.SpringConfig;
import brasserie.model.Produit;
import brasserie.model.Snack;
import brasserie.services.AchatService;
import brasserie.services.NoteService;
import brasserie.services.ProduitService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class ProduitTest {

	@Autowired
	ProduitService produitService;
	
	
	@Test //Test fonctionnel !
	@Disabled 
	void creationProduitTest() {
		produitService.create(new Snack("Snack Spring", 12));
	}
	
	@Test //Test fonctionnel !
	@Disabled
	void updateProduitTest() {
		Produit p = produitService.getById(7);
		p.setDescription("Description spring");
		produitService.update(p);;
	}
	
	@Test //Test fonctionnel !
	@Disabled
	void getAllProduitTest() {
		produitService.getAll().stream().forEach(a -> {System.out.println(a.getNom());});
	}
	
	@Test //Test fonctionnel ! 
	void deleteByNumeroTest() {
		produitService.deleteById(5);
	}
	

}

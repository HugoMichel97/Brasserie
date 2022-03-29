package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import brasserie.config.SpringConfig;
import brasserie.model.Evenement;
import brasserie.services.EvenementService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class EvenementTest {

	
	@Autowired
	EvenementService evenementService;
	
	
	@Test
	@Transactional
	@Commit
	void creationEvenementTest() {
		Evenement e=new Evenement(LocalDate.of(2022, 01, 10), LocalTime.of(12, 50), "foire de la biere", 15, 100, "le rendez vous incontournable", null, null);
		
		
	evenementService.create(e);
		
		
	}
	
	@Test
	void deleteEvenementTest() {
		
		evenementService.deleteById(4);
	}
	
	@Test
	void updateEvenementTest() {
        Evenement e = evenementService.getById(8);
        e.setLibelle("nouveau libelle");
        evenementService.update(e);
    }
	
	@Test
	void getByIdEvenementTest()
	{
		evenementService.getById(6);
	}
	
	@Test
	void getAllEvenementTest()
	{
		evenementService.getAll();
	}
	
}

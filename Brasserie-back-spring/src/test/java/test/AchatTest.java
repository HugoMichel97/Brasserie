package test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import brasserie.config.SpringConfig;
import brasserie.services.AchatService;
import brasserie.services.ProduitService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class AchatTest {

	@Autowired
	AchatService achatService;
	
	@Autowired
	ProduitService produitService;
	
	@Autowired
	//ClientService clientService; ne peut pas être testé sans client 
	
	@Test
	@Disabled
	void createAchatTest() {
		
	}
	
	@Test
	@Disabled
	void updateAchatTest() {
		
	}
	
	@Test
	@Disabled
	void getAllAchatTest() {
		
	}
	
	@Test
	@Disabled
	void deleteAchatTest() {
		
	}

}

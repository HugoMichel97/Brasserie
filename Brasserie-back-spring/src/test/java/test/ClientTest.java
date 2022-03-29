package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import brasserie.config.SpringConfig;
import brasserie.model.Client;
import brasserie.repositories.ClientRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class ClientTest {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Test
	void injectionTest() {
		assertNotNull(clientRepository);
	}
	
	@Test
	@Disabled
	@Commit
	void insertTest() {
		Client c = new Client("test@teeeest", "test");
		clientRepository.save(c);
		
		List<Client> clients = Arrays.asList(new Client("list@1", "listTest"),
				new Client("list@2", "testList"));
		clientRepository.saveAll(clients);
	}
	
	@Test
	@Disabled
	@Commit
	void deleteTest() {
		long nbLigne = clientRepository.count();
		clientRepository.deleteById(8);
		assertNotEquals(nbLigne, clientRepository.count());
		List<Integer> ids = Arrays.asList(9, 10);
		clientRepository.deleteAllById(ids);
		assertNotEquals(nbLigne, clientRepository.count());
	}
	
	@Test
	@Disabled
	@Commit
	void updateTest() {
		Client c = clientRepository.findById(7).get();
		c.setNom("Clavel-L'Haridon");
		clientRepository.save(c);
	}
	
	@Test
	@Disabled
	void equalsTest() {
		Client c = clientRepository.findById(11).orElseThrow();
		Client cBis = clientRepository.findById(11).orElseThrow();
		assertEquals(c, cBis);
	}
	
	@Test
	@Disabled
	void findByFideliteTest() {
		Client cFid = clientRepository.findByFidelite(20).orElseThrow();
		Client c = clientRepository.findById(3).orElseThrow();
		assertEquals(cFid, c);
		
		//List<Client> cFids = clientRepository.findByFidelite(0).orElseThrow();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

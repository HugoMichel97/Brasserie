package soprajc.Brasserie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.repositories.BrasseurRepository;

@Service
public class BrasseurService {
	
	@Autowired
	private BrasseurRepository brasseurRepository;
	
	
}

package brasserie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brasserie.repositories.BrasseurRepository;

@Service
public class BrasseurService {
	
	@Autowired
	private BrasseurRepository brasseurRepository;
	
	
}

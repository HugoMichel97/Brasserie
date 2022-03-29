package brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brasserie.exception.EvenementException;
import brasserie.model.Evenement;
import brasserie.repositories.EvenementRepository;

@Service
public class EvenementService {



		@Autowired
		private EvenementRepository evenementRepository;
		

		public void create(Evenement e) {
			
			evenementRepository.save(e);
		}

		public void update(Evenement e) {
			
			evenementRepository.save(e);
		}

		public List<Evenement> getAll() {
			return evenementRepository.findAll();
		}

		

		

		public void delete(Evenement e) {

			evenementRepository.delete(e);
		}

		public void deleteById(Integer id) {
	        evenementRepository.deleteById(id);
	    }

		public Evenement getById(Integer id) {
	        return evenementRepository.findById(id).orElseThrow(()-> {throw new EvenementException("Numero inconnu");});
	    }
	}


package soprajc.Brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.EvenementException;
import soprajc.Brasserie.model.Evenement;
import soprajc.Brasserie.repositories.EvenementRepository;

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
		
		//getByDate
		//getByFidelite

		

		

		public void delete(Evenement e) {

			evenementRepository.delete(e);
		}

		public void deleteById(Integer id) {
	        evenementRepository.deleteById(id);
	    }

		public Evenement getById(Integer id) {
	        return evenementRepository.findById(id).orElseThrow(()-> {throw new EvenementException("Numero inconnu");});
	    }
		
		public Evenement save(Evenement evenement) {
	        if (evenement.getId() != null) {
	            Evenement evtEnBase = getById(evenement.getId());
	            evenement.setVersion(evtEnBase.getVersion());
	        }
	        return evenementRepository.save(evenement);
	    }
		
	}


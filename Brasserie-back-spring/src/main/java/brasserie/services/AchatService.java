package brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brasserie.exception.AchatException;
import brasserie.exception.ProduitException;
import brasserie.model.Achat;
import brasserie.model.Note;
import brasserie.model.Produit;
import brasserie.repositories.AchatRepository;

@Service
public class AchatService {

	@Autowired
	AchatRepository achatRepository;
	
	public void create(Achat a) {

		achatRepository.save(a);
	}

	public void update(Achat a) {
		achatRepository.save(a);
	}

	public List<Achat> getAll(){
		return achatRepository.findAll();
	}
	
	public Achat getById(Integer id) {
		return achatRepository.findById(id).orElseThrow(()-> {throw new AchatException("Numero inconnu");});
	}

	public void deleteById(Integer id) { 
		achatRepository.deleteById(id);

	}
}

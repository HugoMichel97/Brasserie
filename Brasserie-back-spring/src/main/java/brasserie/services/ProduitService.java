package brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brasserie.exception.ProduitException;
import brasserie.model.Produit;
import brasserie.repositories.AchatRepository;
import brasserie.repositories.ProduitRepository;



@Service
public class ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired 
	AchatRepository achatRepository;

	public void create(Produit p) {
		if(p.getId() != null) {
			throw new ProduitException("Le numero ne doit pas être défini");
		}
		if(p.getNom() == null ) {
			throw new ProduitException("Le nom doit être défini");
		}
		produitRepository.save(p);
	}

	
	public void update(Produit p) {
		if(p.getId() == null) {
			throw new ProduitException("Le numero doit être défini");
		}
		if(p.getNom() == null ) {
			throw new ProduitException("Le nom doit être défini");
		}
		produitRepository.save(p);
	}
	
	public List<Produit> getAll(){
		return produitRepository.findAll();
	}
	
	public Produit getById(Integer id) {
		return produitRepository.findById(id).orElseThrow(()-> {throw new ProduitException("Numero inconnu");});
	}
	
	//Il faudra aussi supprimer en cascade les notes mais prb (cf NoteRepository)
	public void delete(Produit p) {
		Produit pBase = getById(p.getId());
		achatRepository.deleteByProduit(pBase);
		produitRepository.delete(pBase);
	}
	
	public void deleteById(Integer id) {
		produitRepository.deleteById(id);
	}
}

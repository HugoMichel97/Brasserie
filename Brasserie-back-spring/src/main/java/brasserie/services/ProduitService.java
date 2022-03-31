package brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brasserie.exception.ProduitException;
import brasserie.model.Biere;
import brasserie.model.Produit;
import brasserie.model.Snack;
import brasserie.repositories.AchatRepository;
import brasserie.repositories.BiereRepository;
import brasserie.repositories.ProduitRepository;
import brasserie.repositories.SnackRepository;

@Service
public class ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired 
	AchatRepository achatRepository;
	
	@Autowired
	BiereRepository biereRepository;
	
	@Autowired
	SnackRepository snackRepository;

	public void create(Produit p) {
		if(p.getId() != null) {
			throw new ProduitException("Le numero ne doit pas �tre d�fini");
		}
		if(p.getNom() == null ) {
			throw new ProduitException("Le nom doit �tre d�fini");
		}
		produitRepository.save(p);
	}

	
	public void update(Produit p) {
		if(p.getId() == null) {
			throw new ProduitException("Le numero doit �tre d�fini");
		}
		if(p.getNom() == null ) {
			throw new ProduitException("Le nom doit �tre d�fini");
		}
		produitRepository.save(p);
	}
	
	public List<Produit> getAll(){
		return produitRepository.findAll();
	}
	
	public List<Biere> getAllBeers(){
		return biereRepository.findAll();
	}
	
	public List<Snack> getAllSnacks(){
		return snackRepository.findAll();
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
	
	public Produit save(Produit produit) {
		if (produit.getId() != null) {
			Produit produitEnBase = getById(produit.getId());
			produit.setVersion(produitEnBase.getVersion());
		}
		return produitRepository.save(produit);
	}
}

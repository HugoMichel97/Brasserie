package soprajc.Brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.ProduitException;
import soprajc.Brasserie.model.Biere;
import soprajc.Brasserie.model.Produit;
import soprajc.Brasserie.model.Snack;
import soprajc.Brasserie.repositories.AchatRepository;
import soprajc.Brasserie.repositories.BiereRepository;
import soprajc.Brasserie.repositories.NoteRepository;
import soprajc.Brasserie.repositories.ProduitRepository;
import soprajc.Brasserie.repositories.SnackRepository;

@Service
public class ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired 
	AchatRepository achatRepository;
	
	@Autowired
	NoteRepository noteRepository;
	
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
	
	public void delete(Produit p) {
		Produit pBase = getById(p.getId());
		achatRepository.deleteByProduit(pBase);
		if(pBase instanceof Biere) {
			noteRepository.deleteByProduit((Biere) pBase);
		}
		produitRepository.delete(pBase);
	}
	
	public void deleteById(Integer id) {
		Produit p = getById(id);
		delete(p);
	}
	
	public Produit save(Produit produit) {
		if (produit.getId() != null) {
			Produit produitEnBase = getById(produit.getId());
			produit.setVersion(produitEnBase.getVersion());
		}
		return produitRepository.save(produit);
	}
}

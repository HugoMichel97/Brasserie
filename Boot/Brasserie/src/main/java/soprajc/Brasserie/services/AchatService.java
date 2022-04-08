package soprajc.Brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.AchatException;
import soprajc.Brasserie.model.Achat;
import soprajc.Brasserie.model.Biere;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.Produit;
import soprajc.Brasserie.model.StatutCommande;
import soprajc.Brasserie.repositories.AchatRepository;

@Service
public class AchatService {

	@Autowired
	AchatRepository achatRepository;
	@Autowired
	ProduitService produitService;
	@Autowired
	ClientService clientService;

	public void create(Achat a) {
		achatRepository.save(a);
	}

	public void update(Achat a) {
		// modification du stock de produit en fonction des achats si statut = validee
		if (a.getId_client().getStatut().equals(StatutCommande.validee)) {
			Produit p = a.getId_produit();
			p.setStock(p.getStock()-a.getQuantite());
			// modification des pts fidélité si bière et si statut = validee
			if (p instanceof Biere) {
				Client c = a.getId_client();
				c.setFidelite(c.getFidelite() + p.getPoints());
				clientService.save(c);
			}
			produitService.save(p);
		}
		// sauvegarde en base de l'achat
		achatRepository.save(a);
	}

	public List<Achat> getAll(){
		return achatRepository.findAll();
	}

	public List<Achat> getByClient(Client c){
		return achatRepository.findByClient(c);
	}
	
	public Achat getById(Integer id) {
		return achatRepository.findById(id).orElseThrow(()-> {throw new AchatException("Numero inconnu");});
	}

	public void deleteById(Integer id) { 
		achatRepository.deleteById(id);
	}

	public void deleteByClient(Client c) {
		achatRepository.deleteByClient(c);
	}

	public Achat save(Achat achat) {
		if (achat.getId_achat() != null) {
			Achat achatEnBase = getById(achat.getId_achat());
			// modification du stock de produit en fonction des achats si statut = validee
			if (achat.getId_client().getStatut().equals(StatutCommande.validee)) {
				Produit p = achat.getId_produit();
				p.setStock(p.getStock()-achat.getQuantite());
				// modification des pts fidélité si bière et si statut = validee
				if (p instanceof Biere) {
					Client c = achat.getId_client();
					c.setFidelite(c.getFidelite() + p.getPoints());
					clientService.save(c);
				}
				produitService.save(p);
			}
			achat.setVersion(achatEnBase.getVersion());
		}
		return achatRepository.save(achat);
	}

}

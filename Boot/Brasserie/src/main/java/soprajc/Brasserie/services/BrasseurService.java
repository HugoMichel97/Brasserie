package soprajc.Brasserie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.BrasseurException;
import soprajc.Brasserie.exception.ClientException;
import soprajc.Brasserie.model.Brasseur;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.repositories.BrasseurRepository;

@Service
public class BrasseurService {
	
	@Autowired
	private BrasseurRepository brasseurRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Brasseur getById(Integer id) {
		Brasseur brasseur = brasseurRepository.findById(id).orElseThrow(BrasseurException::new);
		return brasseur;
	}
	
	public Brasseur getByMail(String mail) {
		Brasseur brasseur = brasseurRepository.findByMail(mail).orElseThrow(BrasseurException::new);
		return brasseur;
	}
	
	public Brasseur create(Brasseur b) {
		if (b.getId() != null) {
			throw new BrasseurException("L'id ne doit pas �tre defini.");
		}
		if (b.getMail() == null || b.getMail().isEmpty()) {
			throw new BrasseurException("Le mail doit etre defini.");
		}
		b.setPassword(passwordEncoder.encode(b.getPassword()));
		return brasseurRepository.save(b);
	}
	
	public Brasseur save(Brasseur brasseur) {
		if (brasseur.getId() != null) {
			Brasseur brasseurEnBase = getById(brasseur.getId());
			brasseur.setVersion(brasseurEnBase.getVersion());
		}
		return brasseurRepository.save(brasseur);
	}
	
}

package soprajc.Brasserie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.BrasseurException;
import soprajc.Brasserie.model.Brasseur;
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
	
	public Brasseur save(Brasseur brasseur) {
		if (brasseur.getId() != null) {
			Brasseur brasseurEnBase = getById(brasseur.getId());
			brasseur.setVersion(brasseurEnBase.getVersion());
		}
		brasseur.setPassword(passwordEncoder.encode(brasseur.getPassword()));
		return brasseurRepository.save(brasseur);
	}
	
}

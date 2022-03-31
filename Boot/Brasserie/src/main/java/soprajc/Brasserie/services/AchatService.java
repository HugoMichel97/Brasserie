package soprajc.Brasserie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.Brasserie.exception.AchatException;
import soprajc.Brasserie.model.Achat;
import soprajc.Brasserie.repositories.AchatRepository;

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
	
	public Achat save(Achat achat) {
        if (achat.getId_achat() != null) {
            Achat achatEnBase = getById(achat.getId_achat());
            achat.setVersion(achatEnBase.getVersion());
        }
        return achatRepository.save(achat);
    }

}

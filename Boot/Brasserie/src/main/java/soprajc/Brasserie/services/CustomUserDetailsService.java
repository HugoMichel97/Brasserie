package soprajc.Brasserie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import soprajc.Brasserie.repositories.BrasseurRepository;
import soprajc.Brasserie.repositories.ClientRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private BrasseurRepository brasseurRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(!(clientRepo.findByMail(username).isEmpty())) {
			return clientRepo.findByMail(username).get();
		} else if (!(brasseurRepo.findByMail(username).isEmpty())) {
			return brasseurRepo.findByMail(username).get();
		} else {
			throw new UsernameNotFoundException("Mail inconnu.");
		}
	}

}

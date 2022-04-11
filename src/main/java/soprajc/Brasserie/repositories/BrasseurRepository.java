package soprajc.Brasserie.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import soprajc.Brasserie.model.Brasseur;

public interface BrasseurRepository extends JpaRepository<Brasseur, Integer>{
	
	Optional<Brasseur> findByMail(@Param("mail") String mail);
}

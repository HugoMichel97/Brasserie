package soprajc.Brasserie.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.Brasserie.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	@Query("select c from Client c where c.fidelite=:fidelite")
	List<Client> findByFidelite(@Param("fidelite") int fidelite);
	
	@Query("select c from Client c where c.fidelite>=:fidelite")
	List<Client> findByFideliteSup(@Param("fidelite") int fidelite);

	@Query("select c from Client c where c.fidelite<=:fidelite")
	List<Client> findByFideliteInf(@Param("fidelite") int fidelite);
	
	Optional<Client> findByMail(@Param("mail") String mail);
}

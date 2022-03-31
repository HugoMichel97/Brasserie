package soprajc.Brasserie.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.Brasserie.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	@Query("select c from Client c left join fetch c.reservations")
	List<Client> findAllWithReservation();

	@Query("select c from Client c left join fetch c.achats")
	List<Client> findAllWithAchat();
	
	@Query("select c from Client c left join fetch c.reservations where c.id=:id")
	Optional<Client> findByIdWithReservations(@Param("id") Integer id);

	@Query("select c from Client c left join fetch c.achats where c.id=:id")
	Optional<Client> findByIdWithAchats(@Param("id") Integer id);
	
	@Query("select c from Client c where c.fidelite=:fidelite")
	Optional<Client> findByFidelite(@Param("fidelite") int fidelite);
	
	@Query("select c from Client c where c.fidelite>=:fidelite")
	Optional<Client> findByFideliteSup(@Param("fidelite") int fidelite);

	@Query("select c from Client c where c.fidelite<=:fidelite")
	Optional<Client> findByFideliteInf(@Param("fidelite") int fidelite);
}

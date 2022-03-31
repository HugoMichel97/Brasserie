package soprajc.Brasserie.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.Reservation;
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	@Modifying
	@Transactional
	@Query("delete from Reservation r where r.client=:client")
	void deleteByClient(@Param("client") Client client);
	
	@Query("select r from Reservation r left join fetch r.client where r.id=:id")
	Optional<Reservation> findByIdWithClient(@Param("id") Integer id);
}

package soprajc.Brasserie.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.Brasserie.model.Evenement;

public interface EvenementRepository  extends JpaRepository<Evenement, Integer>{
	@Query("select e from Evenement e left join fetch e.reservations")
	List<Evenement> findAllWithReservation();
	
	@Query("select e from Evenement e left join fetch e.reservations where e.id=:id")
	Optional<Evenement> findByIdWithReservations(@Param("id") Integer id);
	
	@Query("select e from Evenement e where e.ptsRequis<=:fidelite")
	List<Evenement> findAllByFidelite(@Param("fidelite") int fidelite);
	
	@Query("select e from Evenement e where e.date=:date")
	List<Evenement> findAllByDate(@Param("date") LocalDate date);
}

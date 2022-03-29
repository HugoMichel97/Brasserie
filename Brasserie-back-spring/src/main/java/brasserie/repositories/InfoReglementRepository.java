package brasserie.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import brasserie.model.Client;
import brasserie.model.InfoReglement;
import brasserie.model.Reservation;

public interface InfoReglementRepository extends JpaRepository<InfoReglement, Integer>{
	@Modifying
	@Transactional
	@Query("delete from InfoReglement i where i.client=:client")
	void deleteByClient(@Param("client") Client client);
	
	@Query("select i from InfoReglement i left join fetch i.client where i.id=:id")
	Optional<InfoReglement> findByIdWithClients(@Param("id") Integer id);
}

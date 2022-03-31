package soprajc.Brasserie.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.InfoReglement;

public interface InfoReglementRepository extends JpaRepository<InfoReglement, Integer>{
	@Modifying
	@Transactional
	@Query("delete from InfoReglement i where i.client=:client")
	void deleteByClient(@Param("client") Client client);
	
	@Query("select i from InfoReglement i left join fetch i.client where i.id=:id")
	Optional<InfoReglement> findByIdWithClients(@Param("id") Integer id);
}

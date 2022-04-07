package soprajc.Brasserie.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.Brasserie.model.Biere;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>{

	@Modifying
	@Transactional
	@Query("delete from Note a where a.biere=:produit")
	void deleteByProduit(@Param("produit") Biere biere);
	
	@Query("select n from Note n where n.client=:client")
	List<Note> findByClient(@Param("client") Client client);
}

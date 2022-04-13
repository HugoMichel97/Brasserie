package soprajc.Brasserie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.Brasserie.model.Biere;
import soprajc.Brasserie.model.Note;
import soprajc.Brasserie.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
	
	@Query(value= "SELECT AVG(note) FROM Note n where id_biere=:id", nativeQuery=true)
	int averageBiere(@Param("id") Integer id);

}

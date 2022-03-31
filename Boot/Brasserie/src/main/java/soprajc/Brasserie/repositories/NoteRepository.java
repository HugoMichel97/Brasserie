package soprajc.Brasserie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import soprajc.Brasserie.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>{

	/*Prb avec les notes .... voir classe note --> pas de produits mentionn�s mais une biere
	@Modifying
	@Transactional
	@Query("delete from Note a where a.biere=:produit")
	void deleteByProduit(@Param("produit") Produit produit);
	*/
}

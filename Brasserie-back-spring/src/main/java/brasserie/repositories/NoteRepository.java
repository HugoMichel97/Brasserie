package brasserie.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import brasserie.model.Note;
import brasserie.model.Produit;

public interface NoteRepository extends JpaRepository<Note, Integer>{

	/*Prb avec les notes .... voir classe note --> pas de produits mentionnés mais une biere
	@Modifying
	@Transactional
	@Query("delete from Note a where a.biere=:produit")
	void deleteByProduit(@Param("produit") Produit produit);
	*/
}

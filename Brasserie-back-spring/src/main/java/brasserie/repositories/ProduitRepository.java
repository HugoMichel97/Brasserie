package brasserie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import brasserie.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

	@Query("SELECT p FROM Produit p WHERE p.type_produit = Biere")
	List<Produit> findAllBeers();
}

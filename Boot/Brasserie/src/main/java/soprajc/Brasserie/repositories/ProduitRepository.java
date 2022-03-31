package soprajc.Brasserie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import soprajc.Brasserie.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

//	@Query("SELECT p FROM Produit p WHERE p.type_produit = Biere")
//	List<Produit> findAllBeers();
}

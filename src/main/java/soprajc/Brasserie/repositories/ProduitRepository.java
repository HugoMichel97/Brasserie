package soprajc.Brasserie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import soprajc.Brasserie.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}

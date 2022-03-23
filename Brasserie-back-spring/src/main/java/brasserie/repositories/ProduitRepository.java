package brasserie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import brasserie.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}

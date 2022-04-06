package soprajc.Brasserie.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.Brasserie.model.Achat;
import soprajc.Brasserie.model.Client;
import soprajc.Brasserie.model.Produit;

public interface AchatRepository extends JpaRepository<Achat, Integer>{

	@Modifying
	@Transactional
	@Query("delete from Achat a where a.id_client=:client")
	void deleteByClient(@Param("client") Client client);
	
	@Modifying
	@Transactional
	@Query("delete from Achat a where a.id_produit=:produit")
	void deleteByProduit(@Param("produit") Produit produit);
}

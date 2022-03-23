package brasserie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import brasserie.model.Brasseur;

public interface BrasseurRepository extends JpaRepository<Brasseur, Integer>{
	
}

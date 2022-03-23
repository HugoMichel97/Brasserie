package brasserie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import brasserie.model.Evenement;

public interface EvenementRepository  extends JpaRepository<Evenement, Integer>{



}

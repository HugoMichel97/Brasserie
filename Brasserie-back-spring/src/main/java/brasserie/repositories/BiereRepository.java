package brasserie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import brasserie.model.Biere;

public interface BiereRepository extends JpaRepository<Biere, Integer>{

}

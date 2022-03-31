package brasserie.repositories;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;

import brasserie.model.Snack;

public interface SnackRepository extends JpaRepository<Snack, Integer>{

}

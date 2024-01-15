package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie,Long>{

}
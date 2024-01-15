package tn.esprit.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Categorie;
import tn.esprit.entities.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit,Long>{

}

package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Produit;

public interface ProduitService{

    List<Produit> retrieveAllProduit();
    Produit addProduit(Produit p );
    void deleteProduit(Long id);
    Produit updateProduit(Produit produit);

    List<Produit> getProduitsByCategoryId(Long categoryId);




}

package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Categorie;


public interface CategorieService {


    List<Categorie> retrieveAllCategorie();
    Categorie addCategorie(Categorie c );
    void deleteCategorie(Long id);
    Categorie updateCategorie(Categorie categorie);

    Categorie getCategorieById(Long categoryId);

}
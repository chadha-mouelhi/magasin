package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.entities.Categorie;

import tn.esprit.repository.CategorieRepository;


@Service
public class CategorieServiceImpl implements CategorieService{


    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public List<Categorie> retrieveAllCategorie() {
        List <Categorie> categories = (List<Categorie>) categorieRepository.findAll();
        return categories;
    }



    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(Long id) {
       categorieRepository.deleteById(id);

    }


    @Override
    public Categorie updateCategorie(Categorie categorie) {
        if (categorieRepository.existsById(categorie.getIdcategorie())){
            Categorie c = categorieRepository.findById(categorie.getIdcategorie()).get();

            c.setNom(categorie.getNom());
            categorieRepository.save(c);
        }

        return categorie;
    }

    @Override
    public Categorie getCategorieById(Long categoryId) {
        // Implémentation de la récupération de la catégorie depuis la base de données ou autre source
        // Ici, nous allons simplement simuler une catégorie avec l'identifiant donné
        Categorie categorie = new Categorie();
        categorie.setIdcategorie(categoryId);
        categorie.setNom("Nom de la catégorie");
        return categorie;
    }
}




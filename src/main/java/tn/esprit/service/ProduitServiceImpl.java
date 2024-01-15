package tn.esprit.service;

import tn.esprit.service.ProduitService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.entities.Categorie;

import tn.esprit.entities.Produit;
import tn.esprit.repository.CategorieRepository;
import tn.esprit.repository.ProduitRepository;
@Service
public class ProduitServiceImpl implements ProduitService {


    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    private CategorieService categorieService;
    private List<Produit> produits = new ArrayList<>();


    @Override
    public List<Produit> retrieveAllProduit() {
        List<Produit> produits = (List<Produit>) produitRepository.findAll();
        return produits;
    }

    @Override
    public Produit addProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public void deleteProduit(Long id) {

        produitRepository.deleteById(id);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        if (produitRepository.existsById(produit.getIdproduit())) {
            Produit p = produitRepository.findById(produit.getIdproduit()).get();
            p.setPrix(produit.getPrix());
            p.setNom(produit.getNom());
            produitRepository.save(p);
        }

        return produit;
    }

    @Override
    public List<Produit> getProduitsByCategoryId(Long categoryId) {
        // Récupérer la catégorie par son identifiant
        // Cette étape dépend de l'implémentation de votre service de catégorie
        // Nous supposons ici que vous avez une méthode getCategorieById dans le service de catégorie
        // à implémenter
        // Cela permet de vérifier si la catégorie existe avant de filtrer les produits
        Categorie categorie = categorieService.getCategorieById(categoryId);

        if (categorie != null) {
            // Filtrer les produits par l'identifiant de la catégorie
            return produits.stream()
                    .filter(produit -> produit.getCategorie().equals(categoryId))
                    .collect(Collectors.toList());
        } else {
            // Gérer le cas où la catégorie n'existe pas
            return new ArrayList<>();
        }
    }




}

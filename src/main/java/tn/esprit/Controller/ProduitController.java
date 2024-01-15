package tn.esprit.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Categorie;
import tn.esprit.entities.Produit;

import tn.esprit.service.ProduitService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.esprit.service.ProduitService;
@CrossOrigin("*")
@RestController

public class ProduitController {

    @Autowired
    private ProduitService produitService;




    @GetMapping("/retrieveallProduits")
    public List<Produit> getProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduit();
        return listProduits;
    }



    @PostMapping("/addProduits")
    @ResponseBody
    public Produit addProduit(@RequestBody Produit p )
    {
        Produit produit = produitService.addProduit(p);
        return produit;
    }


    @PutMapping("/modifyProduit")
    @ResponseBody
    public Produit modifyProduit(@RequestBody Produit produit ) {
        return produitService.updateProduit(produit);
    }


    @DeleteMapping("/removeProduit/{produitId}")
    @ResponseBody
    public void removeProduit(@PathVariable("produitId") Long produitId) {
        produitService.deleteProduit(produitId);
    }

    @GetMapping("/categorie/{categoryId}")
    public List<Produit> getProduitsByCategoryId(@PathVariable Long categoryId) {
        return produitService.getProduitsByCategoryId(categoryId);
    }




}

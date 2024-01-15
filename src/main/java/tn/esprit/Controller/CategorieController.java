package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Categorie;
import tn.esprit.entities.Produit;
import tn.esprit.service.CategorieService;
import tn.esprit.service.ProduitService;

import java.util.List;


@CrossOrigin("*")
@RestController
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    //crud categorie
    @GetMapping("/retrieveallCategories")
    public List<Categorie> getCategories() {
        List<Categorie> listCategories = categorieService.retrieveAllCategorie();
        return listCategories;
    }


    @PostMapping("/addCategories")
    @ResponseBody
    public Categorie addCategorie(@RequestBody Categorie c) {
        Categorie categorie = categorieService.addCategorie(c);
        return categorie;
    }


    @PutMapping("/modifyCategorie")
    @ResponseBody
    public Categorie modifyCategorie(@RequestBody Categorie categorie) {
        return categorieService.updateCategorie(categorie);
    }


    @DeleteMapping("/removeCategorie/{categorieId}")
    @ResponseBody
    public void removeCategorie(@PathVariable("categorieId") Long categorieId) {
        categorieService.deleteCategorie(categorieId);
    }




}


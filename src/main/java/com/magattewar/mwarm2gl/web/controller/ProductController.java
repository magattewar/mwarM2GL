package com.magattewar.mwarm2gl.web.controller;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.magattewar.mwarm2gl.dao.ProductDao;
import com.magattewar.mwarm2gl.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * nom : WAR
 * prenom : Magatte
 * classe : M2GL
 */
@RestController
public class ProductController {



    @Autowired
    private ProductDao productDao;

    //Récupérer la liste des produits
    @RequestMapping(value = "/Produits", method = RequestMethod.GET)

    public MappingJacksonValue listeProduits() {

        List<Product> produits = productDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);

        produitsFiltres.setFilters(listDeNosFiltres);

        return produitsFiltres;
    }

    //Récupérer un produit par son Id
    @GetMapping(value="/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) throws ProduitIntrouvableException {
        Product produit = productDao.findById(id);
        if(produit==null) {
            throw new ProduitIntrouvableException("Le produit avec l'id " + id + " est INTROUVABLE. Écran Bleu si je pouvais.");
        }
        return produit;
    }
//
//
//    //ajouter un produit
//    @PostMapping(value = "/Produits")
//    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {
//
//        Product productAdded =  productDao.save(product);
//
//        if (productAdded == null)
//            return ResponseEntity.noContent().build();
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(productAdded.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build();
//    }

    @DeleteMapping (value = "/Produits/{id}")
    public void supprimerProduit(@PathVariable int id) {

        productDao.deleteProductById(id);
    }

    @PutMapping (value = "/Produits")
    public void updateProduit(@RequestBody Product product) {

        productDao.save(product);
    }
}

package com.magattewar.mwarm2gl.dao;

import com.magattewar.mwarm2gl.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * nom : WAR
 * prenom : Magatte
 * classe : M2GL
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    Product findById(int id);

    List<Product> findByPrixGreaterThan(int prixLimit);
    List<Product> findByNomLike(String recherche);
    void deleteProductById(int id);

}

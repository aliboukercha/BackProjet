package com.projet.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}

package com.nab.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nab.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}

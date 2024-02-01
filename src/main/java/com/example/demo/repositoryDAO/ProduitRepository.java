package com.example.demo.repositoryDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	List<Produit> findByIdUser(Long idUser);
}

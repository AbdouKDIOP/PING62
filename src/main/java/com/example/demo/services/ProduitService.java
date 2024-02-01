package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Produit;
import com.example.demo.repositoryDAO.ProduitRepository;

//Créez un service pour gérer l'accès à la BDD
@Service
public class ProduitService {

 // Injectez le Repository approprié pour accéder à la BDD
 private final ProduitRepository produitRepository;

 public ProduitService(ProduitRepository produitRepository) {
     this.produitRepository = produitRepository;
 }

 // Méthode pour récupérer tous les produits depuis la BDD
 public List<Produit> getAllProduits() {
     return produitRepository.findAll();
 }
 
 public List<Produit> getProduitsByIdUser(Long userId) {
	    return produitRepository.findByIdUser(userId);
	}
}
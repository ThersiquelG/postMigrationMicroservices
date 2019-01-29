package com.ecommerce.microcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductDao productDao ;
	/*
	 * Tout d'abord, nous avons créé une variable de type ProductDao, 
	 * que nous avons annotée avec @Autowired afin que Spring se charge 
	 * d'en fabriquer une instance. 
	 * ProductDao a désormais accès à toutes les méthodes que nous avons définies.
	 */



	@RequestMapping(value="/Produits", method=RequestMethod.GET)
	public List<Product>listeProduits() {
		return productDao.findAll();
	}

	/*
	 * @RequestMapping(value="/Produits/{id}", method=RequestMethod.GET)
		public String afficherUnProduit(@PathVariable int id) {
		return "Vous avez demandé un produit avec l'id : " + id;
		}
	 */


	@GetMapping(value="/Produits/{id}")
	public Product afficherUnProduit(@PathVariable int id) {
		return productDao.findById(id);
	}

	/*
	 * 	@GetMapping(value="/Produits/{id}")
		public Product afficherUnProduit(@PathVariable int id) {
		Product product = new Product(id, new String("Aspirateur"), 100);
		return product;
	}
	 */

}

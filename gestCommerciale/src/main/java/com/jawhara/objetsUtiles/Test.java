package com.jawhara.objetsUtiles;

import java.util.List;

import com.jawhara.dao.ProduitDao;
import com.jawhara.entity.Produit;

public class Test {

	public static void main(String[] args) {
		
		ProduitDao pdao = new ProduitDao();
		List<Produit> lstprod = pdao.findAll();
		for (Produit produit : lstprod) {
			System.out.println(produit.getCodeProduit());
		}

	}

}

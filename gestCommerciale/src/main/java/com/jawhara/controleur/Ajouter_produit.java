package com.jawhara.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jawhara.dao.ProduitDao;
import com.jawhara.entity.Produit;
import com.jawhara.entity.TypeProduit;

/**
 * Servlet implementation class Ajouter_produit
 */
@WebServlet("/Ajouter_produit")
public class Ajouter_produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_produit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
//		type produit
			TypeProduit typeProduit=new TypeProduit();
			typeProduit.setRefTypeProduit(Integer.parseInt(request.getParameter("select_type")));
		
//		produit
			Produit produit=new Produit();
			produit.setCodeProduit(request.getParameter("txt_code"));
			produit.setTypeProduit(typeProduit);
			produit.setCategorieArticle(request.getParameter("select_categorie"));
			produit.setExistantProduit(true);
			System.out.println(produit.getCodeProduit());
//		ajouter l'article
			new ProduitDao().persist(produit);
		}catch(Exception e){
			
		}
	}

}

package com.jawhara.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jawhara.dao.FournisseurDao;
import com.jawhara.dao.ProduitDao;
import com.jawhara.entity.Fournisseur;
import com.jawhara.entity.Produit;

/**
 * Servlet implementation class Ajouter_fournisseur
 */
@WebServlet("/Ajouter_fournisseur")
public class Ajouter_fournisseur extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_fournisseur() {
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
			
//			fournisseur
				Fournisseur fournisseur = new Fournisseur(); 
				fournisseur.setNomFr(request.getParameter("txt_nom"));
				fournisseur.setAdrFr(request.getParameter("txt_adr"));
				fournisseur.setMailFr(request.getParameter("email"));
				fournisseur.setTelFr(request.getParameter("num_tel"));
				
				// TEST existance 
				if (new FournisseurDao().exist(fournisseur) == false){
					// AJOUT fournisseur
					new FournisseurDao().persist(fournisseur); 
					response.setContentType("text/plain");
			        response.getWriter().write("OK");
				 
				}
				else{
				 
					System.out.println("------------> fournisseur existe deja");
					
					response.setContentType("text/plain");
			        response.getWriter().write("NO");
				}
			}catch(Exception e){
				 
				System.out.println("le fournisseur n'a pas été ajouté");
				response.setContentType("text/plain");
		        response.getWriter().write("NO");
			}
	}
}
	
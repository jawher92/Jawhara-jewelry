package com.jawhara.controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jawhara.entity.Fournisseur;
import com.jawhara.objetsUtiles.ProduitSession;

/**
 * Servlet implementation class Choisir_fournisseur
 */
@WebServlet("/Choisir_fournisseur")
public class Choisir_fournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Choisir_fournisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		recuperation de l'id appartir du formulaire 
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setIdFr(Integer.parseInt(request.getParameter("id")));
		fournisseur.setNomFr(request.getParameter("nom"));
		
//		creation d'une session
		HttpSession session = request.getSession();
		session.setAttribute("fournisseur", fournisseur);
		
//		cree la liste des produits
		List<ProduitSession> lst=new ArrayList<ProduitSession>();
//		HttpSession session = request.getSession();
		session.setAttribute("ProduitsFournisseur", lst);
		
//		rediraction
		response.sendRedirect("Stock.jsp");
	}

}

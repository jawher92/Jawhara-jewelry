package com.jawhara.controleur;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jawhara.objetsUtiles.ProduitSession;

/**
 * Servlet implementation class Enlever_prod_fournisseur
 */
@WebServlet("/Enlever_prod_fournisseur")
public class Enlever_prod_fournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enlever_prod_fournisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	recuperer l'identifiant
		int id=Integer.parseInt(request.getParameter("id"));
//	recuperer la liste des produits (achat) en cours
		HttpSession session = request.getSession();
		List<ProduitSession> lst = (List<ProduitSession>)session.getAttribute("ProduitsFournisseur"); 
	
//	cree une nouvelle liste	
		List<ProduitSession> lst2=new LinkedList<ProduitSession>();
		
//	supprimer le produit et mettre ajours la liste
		for(ProduitSession produitSession:lst){
			if(produitSession.getId()!=id){
				lst2.add(produitSession);
			}
		}
		session.setAttribute("ProduitsFournisseur", lst2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.jawhara.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jawhara.objetsUtiles.ProduitSession;

/**
 * Servlet implementation class Choisir_prod_fournisseur
 */
@WebServlet("/Choisir_prod_fournisseur")
public class Choisir_prod_fournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Choisir_prod_fournisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		cree un produit achat et un cle primaire produit achat
		ProduitSession produit=new ProduitSession();
//		affecter l'id (clé primaire) , code, type, prix, marque et qte
		produit.setId(Integer.parseInt(request.getParameter("id")));
		
		produit.setCode(request.getParameter("code"));
		produit.setLibType(request.getParameter("type"));
		produit.setPrix(Float.parseFloat(request.getParameter("prix")));
		produit.setLibMarque(request.getParameter("marque"));
		produit.setQte(Integer.parseInt(request.getParameter("qte")));
//		recuperer la liste des produits (achat) en cours
		HttpSession session = request.getSession();
		List<ProduitSession> lst = (List<ProduitSession>)session.getAttribute("ProduitsFournisseur"); 
		
//		verifier l'existance de produit
		boolean existe=false;
		for(ProduitSession produitSession:lst){
			if(produitSession.getId()==produit.getId()){
				//si le produit existe deja dans la liste 
				existe=true;
				produitSession.setQte(produitSession.getQte()+produit.getQte());
			}
		}
		
//		ajouter le nouveau produit et mettre ajours la liste
		if(!existe)
		{
			lst.add(produit);
		}
		
		session.setAttribute("ProduitsFournisseur", lst);

		
		response.setContentType("text/plain");
        response.getWriter().write("OK");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

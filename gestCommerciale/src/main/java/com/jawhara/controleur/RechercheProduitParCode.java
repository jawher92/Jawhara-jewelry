package com.jawhara.controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.jawhara.dao.ProduitDao;
import com.jawhara.entity.Produit;

/**
 * Servlet implementation class RechercheProduitParCode
 */
@WebServlet("/RechercheProduitParCode")
public class RechercheProduitParCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheProduitParCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=(String)request.getParameter("code");
		try{
			Produit produit = new ProduitDao().findByCode(code);
			List<String> list = new ArrayList<String>();
		    list.add(produit.getRefProduit()+"");
		    list.add(produit.getCodeProduit()+"");
		    list.add(produit.getTypeProduit().getNomTypeProduit()+"");
		    list.add(request.getAttribute("codeB")+"");
		    list.add(produit.getPrixVenteProduit()+"");
		    String json = new Gson().toJson(list);
	
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}catch(Exception e){
			System.out.println("produit "+code+" n'existe pas");
		}
	}

}

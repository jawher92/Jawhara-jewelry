package com.jawhara.controleur;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jawhara.dao.UtilisateurDao;
import com.jawhara.entity.Utilisateur;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("login_utilisateur")!=null){
			request.getSession().invalidate();
	        response.sendRedirect("Login.jsp");
		}else{
		
			String login=request.getParameter("txt_login");
			String mdp=request.getParameter("txt_mdp");
			
			Utilisateur utilisateur=new UtilisateurDao().findByLoginMp(login, mdp);
			System.out.println("User : "+utilisateur.getLoginUtilisateur());
			if(utilisateur!=null){
//				HttpSession session = request.getSession();
				session.setAttribute("login_utilisateur", utilisateur.getLoginUtilisateur());
				session.setAttribute("nom_utilisateur", utilisateur.getNomUtilisateur());
				session.setAttribute("prenom_utilisateur", utilisateur.getPrenomUtilisateur());
				if(utilisateur.getAgence()!=null){
					session.setAttribute("agence_utilisateur", utilisateur.getAgence().getNomAgence());
					session.setAttribute("id_agence_utilisateur", utilisateur.getAgence().getNumAgence());
				}
				else{
					session.setAttribute("agence_utilisateur", "");
					session.setAttribute("id_agence_utilisateur", 0);
				}
					session.setAttribute("type_utilisateur", utilisateur.getTypeUtilisateur());
					response.sendRedirect("Index.jsp");
				}
			else{
				response.sendRedirect("Login.jsp?msg=Verifier votre login et mot de passe");
			}
		}
	}	

}

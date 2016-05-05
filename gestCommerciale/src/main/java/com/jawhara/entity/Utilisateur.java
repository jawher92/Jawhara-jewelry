package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_utilisateur")
	private Integer idUtilisateur;

	@Column(name="login_utilisateur")
	private String loginUtilisateur;

	@Column(name="mdp_utilisateur")
	private String mdpUtilisateur;

	@Column(name="nom_utilisateur")
	private String nomUtilisateur;

	@Column(name="prenom_utilisateur")
	private String prenomUtilisateur;

	@Column(name="type_utilisateur")
	private String typeUtilisateur;

	//bi-directional many-to-one association to Achat
	@OneToMany(mappedBy="utilisateur")
	private List<Achat> achats;

	//bi-directional many-to-one association to Facture
	@OneToMany(mappedBy="utilisateur")
	private List<Facture> factures;

	//bi-directional many-to-one association to Agence
	@ManyToOne
	@JoinColumn(name="num_agence")
	private Agence agence;

	public Utilisateur() {
	}

	public Integer getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLoginUtilisateur() {
		return this.loginUtilisateur;
	}

	public void setLoginUtilisateur(String loginUtilisateur) {
		this.loginUtilisateur = loginUtilisateur;
	}

	public String getMdpUtilisateur() {
		return this.mdpUtilisateur;
	}

	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}

	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return this.prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getTypeUtilisateur() {
		return this.typeUtilisateur;
	}

	public void setTypeUtilisateur(String typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	public List<Achat> getAchats() {
		return this.achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public Achat addAchat(Achat achat) {
		getAchats().add(achat);
		achat.setUtilisateur(this);

		return achat;
	}

	public Achat removeAchat(Achat achat) {
		getAchats().remove(achat);
		achat.setUtilisateur(null);

		return achat;
	}

	public List<Facture> getFactures() {
		return this.factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public Facture addFacture(Facture facture) {
		getFactures().add(facture);
		facture.setUtilisateur(this);

		return facture;
	}

	public Facture removeFacture(Facture facture) {
		getFactures().remove(facture);
		facture.setUtilisateur(null);

		return facture;
	}

	public Agence getAgence() {
		return this.agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

}
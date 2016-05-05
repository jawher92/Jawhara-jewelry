package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the facture database table.
 * 
 */
@Entity
@NamedQuery(name="Facture.findAll", query="SELECT f FROM Facture f")
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_facture")
	private Integer idFacture;

	@Temporal(TemporalType.DATE)
	@Column(name="date_facture")
	private Date dateFacture;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to ProduitFacture
	@OneToMany(mappedBy="facture")
	private List<ProduitFacture> produitFactures;

	public Facture() {
	}

	public Integer getIdFacture() {
		return this.idFacture;
	}

	public void setIdFacture(Integer idFacture) {
		this.idFacture = idFacture;
	}

	public Date getDateFacture() {
		return this.dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<ProduitFacture> getProduitFactures() {
		return this.produitFactures;
	}

	public void setProduitFactures(List<ProduitFacture> produitFactures) {
		this.produitFactures = produitFactures;
	}

	public ProduitFacture addProduitFacture(ProduitFacture produitFacture) {
		getProduitFactures().add(produitFacture);
		produitFacture.setFacture(this);

		return produitFacture;
	}

	public ProduitFacture removeProduitFacture(ProduitFacture produitFacture) {
		getProduitFactures().remove(produitFacture);
		produitFacture.setFacture(null);

		return produitFacture;
	}

}
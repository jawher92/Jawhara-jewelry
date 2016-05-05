package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="produit_ref_produit_seq",
    sequenceName="produit_ref_produit_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	 generator="produit_ref_produit_seq")
	@Column(name="ref_produit", updatable=false)
	private Integer refProduit;

	@Column(name="categorie_article")
	private String categorieArticle;

	@Column(name="code_produit")
	private String codeProduit;

	@Column(name="existant_produit")
	private Boolean existantProduit;

	@Column(name="prix_achat_produit")
	private double prixAchatProduit;

	@Column(name="prix_vente_produit")
	private double prixVenteProduit;

	//bi-directional many-to-one association to Disponible
	@OneToMany(mappedBy="produit")
	private List<Disponible> disponibles;

	//bi-directional many-to-many association to Marque
	@ManyToMany
	@JoinTable(
		name="fabriquer"
		, joinColumns={
			@JoinColumn(name="ref_produit")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_marque")
			}
		)
	private List<Marque> marques;

	//bi-directional many-to-many association to MatiereProduit
	@ManyToMany
	@JoinTable(
		name="inclure"
		, joinColumns={
			@JoinColumn(name="ref_produit")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ref_matiere_produit")
			}
		)
	private List<MatiereProduit> matiereProduits;

	//bi-directional many-to-one association to TypeProduit
	@ManyToOne
	@JoinColumn(name="ref_type_produit")
	private TypeProduit typeProduit;

	//bi-directional many-to-one association to ProduitAchat
	@OneToMany(mappedBy="produit")
	private List<ProduitAchat> produitAchats;

	//bi-directional many-to-one association to ProduitFacture
	@OneToMany(mappedBy="produit")
	private List<ProduitFacture> produitFactures;

	//bi-directional many-to-one association to Promotion
	@OneToMany(mappedBy="produit")
	private List<Promotion> promotions;

	//bi-directional many-to-one association to Reserver
	@OneToMany(mappedBy="produit")
	private List<Reserver> reservers;

	public Produit() {
	}

	public Integer getRefProduit() {
		return this.refProduit;
	}

	public void setRefProduit(Integer refProduit) {
		this.refProduit = refProduit;
	}

	public String getCategorieArticle() {
		return this.categorieArticle;
	}

	public void setCategorieArticle(String categorieArticle) {
		this.categorieArticle = categorieArticle;
	}

	public String getCodeProduit() {
		return this.codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public Boolean getExistantProduit() {
		return this.existantProduit;
	}

	public void setExistantProduit(Boolean existantProduit) {
		this.existantProduit = existantProduit;
	}

	public double getPrixAchatProduit() {
		return this.prixAchatProduit;
	}

	public void setPrixAchatProduit(double prixAchatProduit) {
		this.prixAchatProduit = prixAchatProduit;
	}

	public double getPrixVenteProduit() {
		return this.prixVenteProduit;
	}

	public void setPrixVenteProduit(double prixVenteProduit) {
		this.prixVenteProduit = prixVenteProduit;
	}

	public List<Disponible> getDisponibles() {
		return this.disponibles;
	}

	public void setDisponibles(List<Disponible> disponibles) {
		this.disponibles = disponibles;
	}

	public Disponible addDisponible(Disponible disponible) {
		getDisponibles().add(disponible);
		disponible.setProduit(this);

		return disponible;
	}

	public Disponible removeDisponible(Disponible disponible) {
		getDisponibles().remove(disponible);
		disponible.setProduit(null);

		return disponible;
	}

	public List<Marque> getMarques() {
		return this.marques;
	}

	public void setMarques(List<Marque> marques) {
		this.marques = marques;
	}

	public List<MatiereProduit> getMatiereProduits() {
		return this.matiereProduits;
	}

	public void setMatiereProduits(List<MatiereProduit> matiereProduits) {
		this.matiereProduits = matiereProduits;
	}

	public TypeProduit getTypeProduit() {
		return this.typeProduit;
	}

	public void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}

	public List<ProduitAchat> getProduitAchats() {
		return this.produitAchats;
	}

	public void setProduitAchats(List<ProduitAchat> produitAchats) {
		this.produitAchats = produitAchats;
	}

	public ProduitAchat addProduitAchat(ProduitAchat produitAchat) {
		getProduitAchats().add(produitAchat);
		produitAchat.setProduit(this);

		return produitAchat;
	}

	public ProduitAchat removeProduitAchat(ProduitAchat produitAchat) {
		getProduitAchats().remove(produitAchat);
		produitAchat.setProduit(null);

		return produitAchat;
	}

	public List<ProduitFacture> getProduitFactures() {
		return this.produitFactures;
	}

	public void setProduitFactures(List<ProduitFacture> produitFactures) {
		this.produitFactures = produitFactures;
	}

	public ProduitFacture addProduitFacture(ProduitFacture produitFacture) {
		getProduitFactures().add(produitFacture);
		produitFacture.setProduit(this);

		return produitFacture;
	}

	public ProduitFacture removeProduitFacture(ProduitFacture produitFacture) {
		getProduitFactures().remove(produitFacture);
		produitFacture.setProduit(null);

		return produitFacture;
	}

	public List<Promotion> getPromotions() {
		return this.promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public Promotion addPromotion(Promotion promotion) {
		getPromotions().add(promotion);
		promotion.setProduit(this);

		return promotion;
	}

	public Promotion removePromotion(Promotion promotion) {
		getPromotions().remove(promotion);
		promotion.setProduit(null);

		return promotion;
	}

	public List<Reserver> getReservers() {
		return this.reservers;
	}

	public void setReservers(List<Reserver> reservers) {
		this.reservers = reservers;
	}

	public Reserver addReserver(Reserver reserver) {
		getReservers().add(reserver);
		reserver.setProduit(this);

		return reserver;
	}

	public Reserver removeReserver(Reserver reserver) {
		getReservers().remove(reserver);
		reserver.setProduit(null);

		return reserver;
	}

}
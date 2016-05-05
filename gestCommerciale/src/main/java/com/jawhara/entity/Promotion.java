package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_promo")
	private Integer idPromo;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deb_promo")
	private Date dateDebPromo;

	@Temporal(TemporalType.DATE)
	@Column(name="date_fin_promo")
	private Date dateFinPromo;

	@Column(name="pourcentage_promo")
	private Integer pourcentagePromo;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="ref_produit")
	private Produit produit;

	public Promotion() {
	}

	public Integer getIdPromo() {
		return this.idPromo;
	}

	public void setIdPromo(Integer idPromo) {
		this.idPromo = idPromo;
	}

	public Date getDateDebPromo() {
		return this.dateDebPromo;
	}

	public void setDateDebPromo(Date dateDebPromo) {
		this.dateDebPromo = dateDebPromo;
	}

	public Date getDateFinPromo() {
		return this.dateFinPromo;
	}

	public void setDateFinPromo(Date dateFinPromo) {
		this.dateFinPromo = dateFinPromo;
	}

	public Integer getPourcentagePromo() {
		return this.pourcentagePromo;
	}

	public void setPourcentagePromo(Integer pourcentagePromo) {
		this.pourcentagePromo = pourcentagePromo;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
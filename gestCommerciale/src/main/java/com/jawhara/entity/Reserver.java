package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reserver database table.
 * 
 */
@Entity
@NamedQuery(name="Reserver.findAll", query="SELECT r FROM Reserver r")
public class Reserver implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReserverPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_disponibilite")
	private Date dateDisponibilite;

	@Temporal(TemporalType.DATE)
	@Column(name="date_reservation")
	private Date dateReservation;

	//bi-directional many-to-one association to Agence
	@MapsId("numAgence")
	@ManyToOne
	@JoinColumn(name="num_agence")
	private Agence agence;

	//bi-directional many-to-one association to Client
	@MapsId("idClient")
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Produit
	@MapsId("refProduit")
	@ManyToOne
	@JoinColumn(name="ref_produit")
	private Produit produit;

	public Reserver() {
	}

	public ReserverPK getId() {
		return this.id;
	}

	public void setId(ReserverPK id) {
		this.id = id;
	}

	public Date getDateDisponibilite() {
		return this.dateDisponibilite;
	}

	public void setDateDisponibilite(Date dateDisponibilite) {
		this.dateDisponibilite = dateDisponibilite;
	}

	public Date getDateReservation() {
		return this.dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Agence getAgence() {
		return this.agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
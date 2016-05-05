package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agence database table.
 * 
 */
@Entity
@NamedQuery(name="Agence.findAll", query="SELECT a FROM Agence a")
public class Agence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="num_agence")
	private Integer numAgence;

	@Column(name="adresse_agence")
	private String adresseAgence;

	@Column(name="latitude_agence")
	private double latitudeAgence;

	@Column(name="longitude_agence")
	private double longitudeAgence;

	@Column(name="nom_agence")
	private String nomAgence;

	@Column(name="tel_agence")
	private String telAgence;

	//bi-directional many-to-one association to Disponible
	@OneToMany(mappedBy="agence")
	private List<Disponible> disponibles;

	//bi-directional many-to-one association to Reserver
	@OneToMany(mappedBy="agence")
	private List<Reserver> reservers;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="agence")
	private List<Utilisateur> utilisateurs;

	public Agence() {
	}

	public Integer getNumAgence() {
		return this.numAgence;
	}

	public void setNumAgence(Integer numAgence) {
		this.numAgence = numAgence;
	}

	public String getAdresseAgence() {
		return this.adresseAgence;
	}

	public void setAdresseAgence(String adresseAgence) {
		this.adresseAgence = adresseAgence;
	}

	public double getLatitudeAgence() {
		return this.latitudeAgence;
	}

	public void setLatitudeAgence(double latitudeAgence) {
		this.latitudeAgence = latitudeAgence;
	}

	public double getLongitudeAgence() {
		return this.longitudeAgence;
	}

	public void setLongitudeAgence(double longitudeAgence) {
		this.longitudeAgence = longitudeAgence;
	}

	public String getNomAgence() {
		return this.nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public String getTelAgence() {
		return this.telAgence;
	}

	public void setTelAgence(String telAgence) {
		this.telAgence = telAgence;
	}

	public List<Disponible> getDisponibles() {
		return this.disponibles;
	}

	public void setDisponibles(List<Disponible> disponibles) {
		this.disponibles = disponibles;
	}

	public Disponible addDisponible(Disponible disponible) {
		getDisponibles().add(disponible);
		disponible.setAgence(this);

		return disponible;
	}

	public Disponible removeDisponible(Disponible disponible) {
		getDisponibles().remove(disponible);
		disponible.setAgence(null);

		return disponible;
	}

	public List<Reserver> getReservers() {
		return this.reservers;
	}

	public void setReservers(List<Reserver> reservers) {
		this.reservers = reservers;
	}

	public Reserver addReserver(Reserver reserver) {
		getReservers().add(reserver);
		reserver.setAgence(this);

		return reserver;
	}

	public Reserver removeReserver(Reserver reserver) {
		getReservers().remove(reserver);
		reserver.setAgence(null);

		return reserver;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setAgence(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setAgence(null);

		return utilisateur;
	}

}
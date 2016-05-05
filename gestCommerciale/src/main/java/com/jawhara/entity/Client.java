package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_client")
	private Integer idClient;

	@Column(name="adresse_client")
	private String adresseClient;

	@Column(name="categorie_client")
	private String categorieClient;

	@Column(name="code_postal_client")
	private String codePostalClient;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naiss_client")
	private Date dateNaissClient;

	@Column(name="mail_client")
	private String mailClient;

	@Column(name="nom_client")
	private String nomClient;

	@Column(name="prenom_client")
	private String prenomClient;

	@Column(name="tel_client")
	private String telClient;

	//bi-directional many-to-one association to Facture
	@OneToMany(mappedBy="client")
	private List<Facture> factures;

	//bi-directional many-to-one association to Reserver
	@OneToMany(mappedBy="client")
	private List<Reserver> reservers;

	public Client() {
	}

	public Integer getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getAdresseClient() {
		return this.adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public String getCategorieClient() {
		return this.categorieClient;
	}

	public void setCategorieClient(String categorieClient) {
		this.categorieClient = categorieClient;
	}

	public String getCodePostalClient() {
		return this.codePostalClient;
	}

	public void setCodePostalClient(String codePostalClient) {
		this.codePostalClient = codePostalClient;
	}

	public Date getDateNaissClient() {
		return this.dateNaissClient;
	}

	public void setDateNaissClient(Date dateNaissClient) {
		this.dateNaissClient = dateNaissClient;
	}

	public String getMailClient() {
		return this.mailClient;
	}

	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return this.prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getTelClient() {
		return this.telClient;
	}

	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}

	public List<Facture> getFactures() {
		return this.factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public Facture addFacture(Facture facture) {
		getFactures().add(facture);
		facture.setClient(this);

		return facture;
	}

	public Facture removeFacture(Facture facture) {
		getFactures().remove(facture);
		facture.setClient(null);

		return facture;
	}

	public List<Reserver> getReservers() {
		return this.reservers;
	}

	public void setReservers(List<Reserver> reservers) {
		this.reservers = reservers;
	}

	public Reserver addReserver(Reserver reserver) {
		getReservers().add(reserver);
		reserver.setClient(this);

		return reserver;
	}

	public Reserver removeReserver(Reserver reserver) {
		getReservers().remove(reserver);
		reserver.setClient(null);

		return reserver;
	}

}
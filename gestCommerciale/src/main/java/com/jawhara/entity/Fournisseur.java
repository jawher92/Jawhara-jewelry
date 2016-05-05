package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fournisseur database table.
 * 
 */
@Entity
@NamedQuery(name="Fournisseur.findAll", query="SELECT f FROM Fournisseur f")
public class Fournisseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="fournisseur_id_fr_seq",
    sequenceName="fournisseur_id_fr_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	 generator="fournisseur_id_fr_seq")
	@Column(name="id_fr")
	private Integer idFr;
	
	
	
//	@Id
//	@Column(name="id_fr")
//	private Integer idFr;

	@Column(name="adr_fr")
	private String adrFr;

	@Column(name="mail_fr")
	private String mailFr;

	@Column(name="nom_fr")
	private String nomFr;

	@Column(name="tel_fr")
	private String telFr;

	//bi-directional many-to-one association to Achat
	@OneToMany(mappedBy="fournisseur")
	private List<Achat> achats;

	public Fournisseur() {
	}

	public Integer getIdFr() {
		return this.idFr;
	}

	public void setIdFr(Integer idFr) {
		this.idFr = idFr;
	}

	public String getAdrFr() {
		return this.adrFr;
	}

	public void setAdrFr(String adrFr) {
		this.adrFr = adrFr;
	}

	public String getMailFr() {
		return this.mailFr;
	}

	public void setMailFr(String mailFr) {
		this.mailFr = mailFr;
	}

	public String getNomFr() {
		return this.nomFr;
	}

	public void setNomFr(String nomFr) {
		this.nomFr = nomFr;
	}

	public String getTelFr() {
		return this.telFr;
	}

	public void setTelFr(String telFr) {
		this.telFr = telFr;
	}

	public List<Achat> getAchats() {
		return this.achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public Achat addAchat(Achat achat) {
		getAchats().add(achat);
		achat.setFournisseur(this);

		return achat;
	}

	public Achat removeAchat(Achat achat) {
		getAchats().remove(achat);
		achat.setFournisseur(null);

		return achat;
	}

}
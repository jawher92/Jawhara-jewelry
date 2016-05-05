package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the reserver database table.
 * 
 */
@Embeddable
public class ReserverPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="num_agence", insertable=false, updatable=false)
	private Integer numAgence;

	@Column(name="id_client", insertable=false, updatable=false)
	private Integer idClient;

	@Column(name="ref_produit", insertable=false, updatable=false)
	private Integer refProduit;

	public ReserverPK() {
	}
	public Integer getNumAgence() {
		return this.numAgence;
	}
	public void setNumAgence(Integer numAgence) {
		this.numAgence = numAgence;
	}
	public Integer getIdClient() {
		return this.idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	public Integer getRefProduit() {
		return this.refProduit;
	}
	public void setRefProduit(Integer refProduit) {
		this.refProduit = refProduit;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReserverPK)) {
			return false;
		}
		ReserverPK castOther = (ReserverPK)other;
		return 
			this.numAgence.equals(castOther.numAgence)
			&& this.idClient.equals(castOther.idClient)
			&& this.refProduit.equals(castOther.refProduit);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numAgence.hashCode();
		hash = hash * prime + this.idClient.hashCode();
		hash = hash * prime + this.refProduit.hashCode();
		
		return hash;
	}
}
package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the disponible database table.
 * 
 */
@Embeddable
public class DisponiblePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ref_produit", insertable=false, updatable=false)
	private Integer refProduit;

	@Column(name="num_agence", insertable=false, updatable=false)
	private Integer numAgence;

	public DisponiblePK() {
	}
	public Integer getRefProduit() {
		return this.refProduit;
	}
	public void setRefProduit(Integer refProduit) {
		this.refProduit = refProduit;
	}
	public Integer getNumAgence() {
		return this.numAgence;
	}
	public void setNumAgence(Integer numAgence) {
		this.numAgence = numAgence;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DisponiblePK)) {
			return false;
		}
		DisponiblePK castOther = (DisponiblePK)other;
		return 
			this.refProduit.equals(castOther.refProduit)
			&& this.numAgence.equals(castOther.numAgence);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.refProduit.hashCode();
		hash = hash * prime + this.numAgence.hashCode();
		
		return hash;
	}
}
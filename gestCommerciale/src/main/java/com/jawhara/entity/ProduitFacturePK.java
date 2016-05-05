package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the produit_facture database table.
 * 
 */
@Embeddable
public class ProduitFacturePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ref_produit", insertable=false, updatable=false)
	private Integer refProduit;

	@Column(name="id_facture", insertable=false, updatable=false)
	private Integer idFacture;

	public ProduitFacturePK() {
	}
	public Integer getRefProduit() {
		return this.refProduit;
	}
	public void setRefProduit(Integer refProduit) {
		this.refProduit = refProduit;
	}
	public Integer getIdFacture() {
		return this.idFacture;
	}
	public void setIdFacture(Integer idFacture) {
		this.idFacture = idFacture;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProduitFacturePK)) {
			return false;
		}
		ProduitFacturePK castOther = (ProduitFacturePK)other;
		return 
			this.refProduit.equals(castOther.refProduit)
			&& this.idFacture.equals(castOther.idFacture);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.refProduit.hashCode();
		hash = hash * prime + this.idFacture.hashCode();
		
		return hash;
	}
}
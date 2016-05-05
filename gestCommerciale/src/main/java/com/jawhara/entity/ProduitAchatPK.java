package com.jawhara.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the produit_achat database table.
 * 
 */
@Embeddable
public class ProduitAchatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ref_produit", insertable=false, updatable=false)
	private Integer refProduit;

	@Column(name="id_achat", insertable=false, updatable=false)
	private Integer idAchat;

	public ProduitAchatPK() {
	}
	public Integer getRefProduit() {
		return this.refProduit;
	}
	public void setRefProduit(Integer refProduit) {
		this.refProduit = refProduit;
	}
	public Integer getIdAchat() {
		return this.idAchat;
	}
	public void setIdAchat(Integer idAchat) {
		this.idAchat = idAchat;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProduitAchatPK)) {
			return false;
		}
		ProduitAchatPK castOther = (ProduitAchatPK)other;
		return 
			this.refProduit.equals(castOther.refProduit)
			&& this.idAchat.equals(castOther.idAchat);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.refProduit.hashCode();
		hash = hash * prime + this.idAchat.hashCode();
		
		return hash;
	}
}
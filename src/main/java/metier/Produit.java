package metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produit")
public class Produit implements Serializable{
	@Id
	@Column(name="REF_PROD")
	private String reference;
	@Column(name="DESIGNATION")
	private String designation;
	@Column(name="PRIX")
	private double prix;
	@Column(name="QUANTITE")
	private int quantite;
	
	public Produit() {
		
	}
	public Produit(String reference, String designation, double prix, int quantite) {
		this.reference = reference;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "{reference=" + reference + ", designation=" + designation + ", prix=" + prix + ", quantite=" + quantite
				+ "}\n";
	}
	

}

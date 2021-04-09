package sn.unipro.gestionInscription.modeles;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Etudiant {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String prenom;
	
	@Column
	private String nom;
	
	@Column
	private String numero_carte;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Column
	private String lieuNaissance;
	
	@Column
	private String cni;
	
	@Column
	private String adresse;
	
	@Column
	private String email;
	
	@Column
	private String motPasse;
	

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column
	private Date createdAt;
	

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column
	private Date updatedAt;


	public int getId() {
		return id;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getNom() {
		return nom;
	}


	public String getNumero_carte() {
		return numero_carte;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public String getLieuNaissance() {
		return lieuNaissance;
	}


	public String getCni() {
		return cni;
	}


	public String getAdresse() {
		return adresse;
	}


	public String getEmail() {
		return email;
	}


	public String getMotPasse() {
		return motPasse;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setNumero_carte(String numero_carte) {
		this.numero_carte = numero_carte;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}


	public void setCni(String cni) {
		this.cni = cni;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}

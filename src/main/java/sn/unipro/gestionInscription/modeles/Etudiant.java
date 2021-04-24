package sn.unipro.gestionInscription.modeles;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable=false)
	private String prenom;

	@Column(nullable=false)
	private String nom;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Sexe sexe;

	@Column(nullable=false)
	private String numero_carte;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@Column
	private String lieuNaissance;

	@Column(unique=true)
	private String cni;

	@Column
	private String adresse;

	@Column(unique=true)
	private String telephone;

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

	public Sexe getSexe() {
		return sexe;
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

	public String getTelephone() {
		return telephone;
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

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
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

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}

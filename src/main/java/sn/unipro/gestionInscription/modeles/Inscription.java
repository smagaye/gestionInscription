package sn.unipro.gestionInscription.modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Inscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private int annee;

	@Column
	private String dateInscription;

	@Column(nullable = false)
	private double montant;

	// bi-directional many-to-one association to Etudiant
	@ManyToOne
	private Etudiant etudiant;

	// bi-directional many-to-one association to Etudiant
	@ManyToOne
	private Formation formation;
	
	@OneToMany(mappedBy="inscription", fetch = FetchType.EAGER)
	private List<Mensualite> mensualites;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column
	private Date updatedAt;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public int getAnnee() {
		return annee;
	}

	public String getDateInscription() {
		return dateInscription;
	}

	public double getMontant() {
		return montant;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public Formation getFormation() {
		return formation;
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

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
package sn.unipro.gestionInscription.controllers.comptes;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import sn.unipro.gestionInscription.dao.CompteDao;
import sn.unipro.gestionInscription.modeles.Compte;

@ManagedBean(name = "crudView")
@SessionScoped
public class CrudView implements Serializable {

	private List<Compte> comptes;

	private Compte selectedCompte;

	private List<Compte> selectedComptes;

	private CompteDao compteDao;

	@PostConstruct
	public void init() {
		this.compteDao = new CompteDao();
		this.comptes = this.compteDao.findAll();
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public Compte getSelectedCompte() {
		return selectedCompte;
	}

	public void setSelectedCompte(Compte selectedCompte) {
		this.selectedCompte = selectedCompte;
	}

	public List<Compte> getSelectedComptes() {
		return selectedComptes;
	}

	public void setSelectedComptes(List<Compte> selectedComptes) {
		this.selectedComptes = selectedComptes;
	}

	public void openNew() {
		this.selectedCompte = new Compte();
	}

	public void saveCompte() {
		if (this.selectedCompte.getUsername() == null) {
			this.selectedCompte.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
			this.comptes.add(this.selectedCompte);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Compte ajouté"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Compte modifié"));
			
		}

		PrimeFaces.current().executeScript("PF('manageCompteDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteCompte() {
		this.comptes.remove(this.selectedCompte);
		this.selectedCompte = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Compte supprimé"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-comptes");
	}

	public String getDeleteButtonMessage() {
		if (hasSelectedComptes()) {
			int size = this.selectedComptes.size();
			return size > 1 ? size + " Comptes sélectionnés" : "1 compte sélectionné";
		}

		return "Supprimer";
	}

	public boolean hasSelectedComptes() {
		return this.selectedComptes != null && !this.selectedComptes.isEmpty();
	}

	public void deleteSelectedComptes() {
		this.comptes.removeAll(this.selectedComptes);
		this.selectedComptes = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Comptes Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-comptes");
		PrimeFaces.current().executeScript("PF('dtComptes').clearFilters()");
	}

}
package sn.unipro.gestionInscription.controllers;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import sn.unipro.gestionInscription.dao.CompteDao;
import sn.unipro.gestionInscription.modeles.Compte;
import sn.unipro.gestionInscription.modeles.Profil;

@ManagedBean(name = "connexionBean")
@SessionScoped
public class ConnexionBean {

	private CompteDao compteDao = new CompteDao();

	private String username = "";

	private String password = "";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void seConnecter() throws IOException {
		Compte compte = compteDao.login(username, password);
		System.out.println("Login : " + compte.getUsername() + "\nPassword : " + compte.getPassword() + "\nProfil : "
				+ compte.getProfil());
		if (compte != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("compte", compte);
			if (compte.getProfil() != null && compte.getProfil().equals(Profil.ADMIN)) {

				FacesContext.getCurrentInstance().getExternalContext().redirect("../admin/comptes/liste.xhtml");

			}
			if (compte.getProfil() != null && compte.getProfil().equals(Profil.ETUDIANT)) {

				FacesContext.getCurrentInstance().getExternalContext().redirect("../etudiant/home.xhtml");

			}

		}

	}
}
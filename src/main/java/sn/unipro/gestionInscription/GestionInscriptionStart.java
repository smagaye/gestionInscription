package sn.unipro.gestionInscription;

import java.util.Calendar;
import java.util.Date;

import sn.unipro.gestionInscription.dao.EtudiantDao;
import sn.unipro.gestionInscription.modeles.Etudiant;

public class GestionInscriptionStart {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		cal.set(1985, 04, 25);
		Date dateNaissance = cal.getTime();
		
		EtudiantDao etudiantDao = new EtudiantDao();

		Etudiant etudiant = new Etudiant();
		etudiant.setNom("Camara");
		etudiant.setPrenom("Fallou");
		etudiant.setMotPasse("1234");
		etudiant.setAdresse("Keur Massar");
		etudiant.setCni("1870198504356");
		etudiant.setEmail("fallou@gmail.com");
		etudiant.setLieuNaissance("Dakar");
		etudiant.setNumero_carte("UNI05298");
		etudiant.setDateNaissance(dateNaissance);
		
		etudiantDao.save(etudiant);

	}

}

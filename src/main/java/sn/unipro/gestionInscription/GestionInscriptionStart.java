package sn.unipro.gestionInscription;

import java.util.Date;

import sn.unipro.gestionInscription.dao.EtudiantDao;
import sn.unipro.gestionInscription.modeles.Etudiant;

public class GestionInscriptionStart {


 
	public static void main(String[] args) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("Camara");
        etudiant.setPrenom("Fallou");
        etudiant.setMotPasse("1234");
        etudiant.setDateNaissance(new Date());
        
        EtudiantDao etudiantDao = new EtudiantDao();
        
        etudiantDao.save(etudiant);
        
	}

}

package sn.unipro.gestionInscription;

import sn.unipro.gestionInscription.dao.CompteDao;
import sn.unipro.gestionInscription.dao.EtudiantDao;
import sn.unipro.gestionInscription.modeles.Compte;
import sn.unipro.gestionInscription.modeles.Etudiant;
import sn.unipro.gestionInscription.modeles.Sexe;
import sn.unipro.gestionInscription.util.DateUtil;

public class GestionInscriptionStart {

	public static void main(String[] args) {

		EtudiantDao etudiantDao = new EtudiantDao();		

		Etudiant etudiant = new Etudiant();
		etudiant.setNom("Camara");
		etudiant.setPrenom("Fallou");
		etudiant.setAdresse("Keur Massar");
		etudiant.setCni("1870198504356");
		etudiant.setLieuNaissance("Dakar");
		etudiant.setNumero_carte("UNI05298");
		etudiant.setTelephone("772341560");
		etudiant.setDateNaissance(DateUtil.createDate(25, 04, 1987));
		etudiant.setSexe(Sexe.fromCode('m'));
		etudiantDao.save(etudiant);
		
		CompteDao compteDao = new CompteDao();
		Compte compte = new Compte();
		compte.setUsername("fallou.camara");
		compte.setEmail("fallou.camara@unipro.sn");
		compte.setPassword("1234");
		compte.setEtudiant(etudiantDao.findById(1));
		compteDao.save(compte);
		
		compte = new Compte();
		compte.setUsername("admin");
		compte.setEmail("admin@unipro.sn");
		compte.setPassword("1234");
		compteDao.save(compte);
		
		compteDao.login("fallou.camara", "1234");
	}

}

package sn.unipro.gestionInscription;

import sn.unipro.gestionInscription.dao.CompteDao;
import sn.unipro.gestionInscription.dao.EtudiantDao;
import sn.unipro.gestionInscription.modeles.Compte;
import sn.unipro.gestionInscription.modeles.Etudiant;
import sn.unipro.gestionInscription.modeles.Profil;
import sn.unipro.gestionInscription.modeles.Sexe;
import sn.unipro.gestionInscription.security.Encryptage;
import sn.unipro.gestionInscription.util.DateUtil;

/**
 * @author Smag
 * @since 24 avril 2021
 * @description Cette classe permet de tester en live des méthodes du projet.
 * 
 */
public class GestionInscriptionStart {

	private static EtudiantDao etudiantDao = new EtudiantDao();
	private static CompteDao compteDao = new CompteDao();

	public static void main(String[] args) {

		// Enregistrement d'un étudiant dans la base de données
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

		// Mot de passe en clair pour les deux comptes à créer dans la base de données
		String passwordEnclair = "1234";

		// Test de la méthode de hachage des données
		String passwordHashed = Encryptage.hashPassword(passwordEnclair);
		
		// Enregistrement d'un compte étudiant et celui d'un admin dans la base de
		// données
		// Compte etudiant
		Compte compte = new Compte();
		compte.setUsername("fallou.camara");
		compte.setEmail("fallou.camara@unipro.sn");
		compte.setPassword(passwordHashed);
		compte.setEtudiant(etudiantDao.findById(1));
		compte.setProfil(Profil.fromCode("etu"));
		compteDao.save(compte);

		// Compte admin
		compte = new Compte();
		compte.setUsername("admin");
		compte.setEmail("admin@unipro.sn");
		compte.setPassword(passwordHashed);
		compte.setProfil(Profil.fromCode("adm"));
		compteDao.save(compte);

		// Test pour vérifier dans labqse si le username et le mot de passe sont
		// correctes
		Compte compteConnecte = compteDao.login("fallou.camara", passwordEnclair);

		// Vérification si le mode de passe haché correspond à celui en clair
		Encryptage.checkPass(passwordEnclair, compteConnecte.getPassword());
	}

}

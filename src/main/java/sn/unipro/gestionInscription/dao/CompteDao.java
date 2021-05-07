package sn.unipro.gestionInscription.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sn.unipro.gestionInscription.modeles.Compte;
import sn.unipro.gestionInscription.security.Encryptage;
import sn.unipro.gestionInscription.util.JPAUtil;

public class CompteDao {

	private final static EntityManager entityMgr = JPAUtil.getEntityManager();

	public void save(Compte compte) {
		entityMgr.getTransaction().begin();
		entityMgr.persist(compte);
		entityMgr.getTransaction().commit();
		entityMgr.clear();
	}

	public Compte update(Compte compte) {
		compte = entityMgr.merge(compte);
		return compte;
	}

	public void delete(Compte compte) {
		entityMgr.remove(compte);
	}

	public Compte findById(int id) {
		return entityMgr.find(Compte.class, id);
	}

	public Compte login(String username, String password) {
		Query query = entityMgr.createQuery("FROM Compte where username=:username");
		query.setParameter("username", username);
		Compte compteConnecte = (Compte) query.getSingleResult();
		if (!Encryptage.checkPass(password, compteConnecte.getPassword())) {
			compteConnecte = null;
		}
		return compteConnecte;
	}

}

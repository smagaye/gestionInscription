package sn.unipro.gestionInscription.dao;

import javax.persistence.EntityManager;

import sn.unipro.gestionInscription.modeles.Etudiant;
import sn.unipro.gestionInscription.util.JPAUtil;

public class EtudiantDao {
    
	private final static EntityManager entityMgr = JPAUtil.getEntityManager();
	
    public void save(Etudiant etudiant) {

        entityMgr.getTransaction().begin();
        entityMgr.persist(etudiant);
        entityMgr.getTransaction().commit();
        entityMgr.clear();
	
	}
	
	public Etudiant update(Etudiant etudiant) {
        entityMgr.getTransaction().begin();
        etudiant = entityMgr.merge(etudiant);
        entityMgr.getTransaction().commit();
        entityMgr.clear();
        return etudiant;
	}
	
	
	public void delete(Etudiant etudiant) {
        entityMgr.getTransaction().begin();
        entityMgr.remove(etudiant);
        entityMgr.getTransaction().commit();
        entityMgr.clear();
		
	}	

	public Etudiant findById(int id) {
		return entityMgr.find(Etudiant.class, id);
	}
}

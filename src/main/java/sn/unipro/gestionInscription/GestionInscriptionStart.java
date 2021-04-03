package sn.unipro.gestionInscription;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.unipro.gestionInscription.modeles.Etudiant;

public class GestionInscriptionStart {

    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE_UNIT_DB"; 
    
    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
 
    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }
 
	public static void main(String[] args) {
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();
 
        Etudiant etudiant = new Etudiant();
        
        etudiant.setId(5);
        etudiant.setNom("Alpha Dramé");
        etudiant.setPrenom("1234");
        
        entityMgr.persist(etudiant);
 
        entityMgr.getTransaction().commit();
       
        entityMgr.clear();

	}

}

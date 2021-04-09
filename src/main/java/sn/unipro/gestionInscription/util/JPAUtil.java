package sn.unipro.gestionInscription.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE_UNIT_DB"; 
    
    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
 
    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }
}

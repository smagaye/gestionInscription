package sn.unipro.gestionInscription.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory emFactoryObj;
	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE_UNIT_DB";
	private static EntityManager entityManager;

	static {
		emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null)
			entityManager = emFactoryObj.createEntityManager();
		return entityManager;
	}
}

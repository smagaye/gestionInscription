package sn.unipro.gestionInscription.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import sn.unipro.gestionInscription.modeles.Compte;
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
		CriteriaBuilder builder = entityMgr.getCriteriaBuilder();

		CriteriaQuery<Compte> criteria = builder.createQuery(Compte.class);
		Root<Compte> root = criteria.from(Compte.class);
		criteria.select(root);
		criteria.where(builder.and(builder.equal(root.get("username"), username),
				builder.equal(root.get("password"), password)));
		return entityMgr.createQuery(criteria).getSingleResult();
	}

}

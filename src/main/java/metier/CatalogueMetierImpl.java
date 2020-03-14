package metier;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class CatalogueMetierImpl implements ICatalogueMetier {

	@Override
	public void ajouterProduit(Produit produit) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CAT_MVC_withJPA2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(produit);
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();

	}

	@Override
	public void deleteProduit(String reference) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CAT_MVC_withJPA2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Produit produit = entityManager.find(Produit.class, reference);
		entityTransaction.begin();

		entityManager.remove(produit);
		;

		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public List<Produit> listProduits() {
		// REF_PROD,DESIGNATION,PRIX,QUNTITE)

		List<Produit> listProduits = new ArrayList<Produit>();

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CAT_MVC_withJPA2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		listProduits = entityManager.createQuery("SELECT p FROM Produit p",Produit.class).getResultList();
//		Query<Produit> theQuery=currentSession.createQuery("from Customer", Customer.class);
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		return listProduits;

	}

	@Override
	public List<Produit> produitParMotCle(String keyword) {
		// REF_PROD,DESIGNATION,PRIX,QUNTITE)

		List<Produit> listProduits = new ArrayList<Produit>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CAT_MVC_withJPA2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		keyword="%"+keyword+"%";
		listProduits = entityManager.createQuery("SELECT p FROM Produit p where p.designation like '"+keyword+"'",Produit.class).getResultList();
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		return listProduits;
	}

	@Override
	public Produit getProduit(String reference) {
		// REF_PROD,DESIGNATION,PRIX,QUNTITE)

		Produit produit = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CAT_MVC_withJPA2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		produit = entityManager.find(Produit.class, reference);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();

		return produit;
	}

	@Override
	public void updateProduit(Produit p) {
		// REF_PROD,DESIGNATION,PRIX,QUNTITE)
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CAT_MVC_withJPA2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		
		Produit produit=entityManager.find(Produit.class, p.getReference());
		produit.setReference(p.getReference());
		produit.setPrix(p.getPrix());
        produit.setDesignation(p.getDesignation());
        produit.setQuantite(p.getQuantite());
		entityTransaction.commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

}

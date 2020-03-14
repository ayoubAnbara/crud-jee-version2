package test;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import metier.CatalogueMetierImpl;
import metier.ICatalogueMetier;
import metier.Produit;

public class App {

	public static void main(String[] args) {
		Produit produit = new Produit("ref88", "chargeur", 55, 1200);
		

		ICatalogueMetier metier=new CatalogueMetierImpl();
		 
		//metier.deleteProduit("ref55");
//		System.out.println(metier.listProduits());
		System.out.println(metier.produitParMotCle("chargeur"));
		
		//metier.updateProduit(produit);
		
//		System.out.println(metier.getProduit("ref88"));
		
		
		
		
		
		
		
	}
	void f() {
//		Configuration configuration = new Configuration()
//				.configure(new File("/home/hp/eclipse-workspace/CAT_MVC_withJPA/src/main/webapp/META-INF/hibernate.cfg.xml"))
//				.addAnnotatedClass(Produit.class);
//		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//				.buildServiceRegistry();
//		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//
//		//session.save(produit);
//
//		transaction.commit();
	}

}

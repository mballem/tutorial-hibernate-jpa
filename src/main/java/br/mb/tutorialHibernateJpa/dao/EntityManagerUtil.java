package br.mb.tutorialHibernateJpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 22/02/2011
 * Time: 16:40:26
 * http://mballem.wordpress.com
 */
public class EntityManagerUtil {

  private static EntityManagerFactory emf;

	public static EntityManager getEntityManager() {
		if (emf == null){
			emf = Persistence.createEntityManagerFactory("agenda");
		}
		return emf.createEntityManager();
	}
}
package br.edu.ifpb.collegialis.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class PersistenceUtil {

    private static EntityManagerFactory emf;
    private static ManagedEMContext emc;
	private static Logger logger = Logger.getLogger(PersistenceUtil.class);

	private PersistenceUtil() {
		// Singleton
	}
	
    public static EntityManagerFactory createEntityManagerFactory() {
        try {
    		emf = Persistence.createEntityManagerFactory("collegialis");
    		emc = new ManagedEMContext(emf);
            logger.info("F�brica de EntityManagers constru�da.");
            return emf;
        } catch (Throwable ex) {
            logger.error("Falha ao criar EntityManagerFactory.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    public static EntityManager getCurrentEntityManager() {
    	return emc.currentEntityManager();
    }
    
    public static EntityManager getEntityManager() {
    	return emf.createEntityManager();
    }
    

}
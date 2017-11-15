package com.joshmr94.easylibrarium.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 *
 * @author joshmr94
 */
public abstract class CommonSession<T> {
    
    private static final Logger LOG = Logger.getLogger(CommonSession.class);

    EntityManager entityManager;
    EntityManager sharedEntityManager;
    
    static volatile EntityManagerFactory emf;

    public CommonSession(EntityManager em) {
        this();

        if (em == null) {
            throw new NullPointerException("Entity manager cannot be null.");
        }
        this.sharedEntityManager = em;
    }
    
    public CommonSession() {
        initEntityManagerFactory();
    }
    
    static final void initEntityManagerFactory() {
        EntityManagerFactory localEmf = emf;
        if (localEmf == null) {
            synchronized (CommonSession.class) {
                if (emf == null) {
                    LOG.debug("EntityManagerFactory initialization...");
                    emf = Persistence.createEntityManagerFactory("com.inerza_SolicitudHSR_PU");
                    LOG.debug("EntityManagerFactory created.");
                }
            }
        }
    }
    
    protected EntityManager getEntityManager() {
        LOG.debug("EntityManager resquested...");
        if (sharedEntityManager != null) {
            LOG.debug("Shared EntityManager returned");
            return sharedEntityManager;
        } else {
            if (entityManager == null || !entityManager.isOpen()) {
                LOG.debug("EntityManager initialization...");
                entityManager = buildEntityManager();
                LOG.debug(String.format("EntityManager created: %s", entityManager));
            }
            LOG.debug("EntityManager returned");
            return entityManager;
        }
    }
    
    public static EntityManager buildEntityManager() {
        initEntityManagerFactory();
        return emf.createEntityManager();
    }
    
    protected void beginTransaction() {
        if (sharedEntityManager == null) {
            LOG.debug("Transaction initialization...");
            if (!getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().begin();
                LOG.debug("Transaction created.");
            }
        }
    }
    
    protected void rollbackTransaction() {
        try {
            if (getEntityManager().getTransaction().isActive()) {
                LOG.debug("Transaction rollbacking...");
                getEntityManager().getTransaction().rollback();
                LOG.debug("Transaction rollbacked .");
            }
        } catch (Exception e) {
            LOG.error("Error rollbacking transaction.", e);
            //
        }
    }
    
    protected void commitTransaction() {
        if (sharedEntityManager == null) {
            LOG.debug("Transaction committing...");
            getEntityManager().getTransaction().commit();
            LOG.debug("Transaction committed .");
        }
    }
    
    protected void closeEntityManager() {
        if (sharedEntityManager == null) {
            LOG.debug("EntityManager clossing ...");
            if (getEntityManager().getTransaction().isActive()) {
                LOG.warn("Transaction rollbacking on close...");
                getEntityManager().getTransaction().rollback();
                LOG.warn("Transaction rollbacked on close.");
            }
            entityManager.close();
            LOG.debug("EntityManager closed.");
        }
    }
    
}

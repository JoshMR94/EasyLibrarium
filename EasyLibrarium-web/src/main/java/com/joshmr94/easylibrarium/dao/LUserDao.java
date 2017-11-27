package com.joshmr94.easylibrarium.dao;

import com.joshmr94.easylibrarium.model.LUser;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author joshmr94
 */
public class LUserDao extends CommonSession<LUser>{
    
    private static final Logger LOG = Logger.getLogger(LUser.class);
    
    public LUserDao(EntityManager em) {
        super(em);
    }
    
    public LUserDao() {
        super();
    }
    
    public long countLUsers() {
        try {
            String queryString;
            queryString = String.format("select count(luser.id) from " + LUser.class.getName() + " luser");
            Query query = getEntityManager().createQuery(queryString);
            return (long) query.getSingleResult();
        } catch (Exception e) {
            LOG.warn("Error obtaining the number of LUsers in the database", e);
            return 0L;
        } finally {
            closeEntityManager();
        }
    }
    
    public LUser getLUserById(Long id) {
        try {
            String queryString;
            queryString = String.format("select luser from " + LUser.class.getName() + " luser where luser.id = :id", LUser.class.getName());
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("id", id);
            return (LUser) query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error("Error obtaining the LUser by id", e);
            return null;
        } finally {
            closeEntityManager();
        }
    }
    
    public List<LUser> getAllLUsers() {
        try {
            String queryString;
            queryString = String.format("select a from " + LUser.class.getName() + " a");
            Query query = getEntityManager().createQuery(queryString);
            return (List<LUser>) query.getResultList();
        } catch (NoResultException e) {
            LOG.error("Error obtaining all the LUser", e);
            return new ArrayList<>();
        } finally {
            closeEntityManager();
        }
    }
   
}

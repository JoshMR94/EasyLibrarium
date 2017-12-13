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
    
    public LUser insertLUser(LUser u){
        beginTransaction();
        try {
            getEntityManager().persist(u);
            commitTransaction();
            return u;
        } catch (NoResultException e) {
            rollbackTransaction();
            LOG.error("Error inserting the LUser", e); 
            return null;
        } finally {
            closeEntityManager();
        }
    }
    
    public boolean updateLUser(LUser u) {
        beginTransaction();
        try {
            String queryString;
            queryString = "update " + LUser.class.getName() + " u SET u.username = :username" + 
                  ", u.password = :password" +  
                  ", u.description = :description" +
                  ", u.email = :email" + 
                  ", u.userType = :userType" + 
                  " WHERE id = " + u.getId();
            
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("username", u.getUsername());
            query.setParameter("password", u.getPassword());
            query.setParameter("description", u.getDescription());
            query.setParameter("email", u.getEmail());
            query.setParameter("userType", u.getUserType());
            
            query.executeUpdate();
            commitTransaction();
            return true;
        } catch (NoResultException e) {
            rollbackTransaction();
            LOG.error("Error updating the user", e); 
            return false;
        } finally {
            closeEntityManager();
        }
    }
   
    public boolean deleteLUser(Long id) {
        beginTransaction();
        try {
            Query query = getEntityManager().createQuery("DELETE FROM " + LUser.class.getName() + " luser WHERE luser.id = " + id);
            query.executeUpdate();
            commitTransaction();
            return true;
        } catch (NoResultException e) {
            rollbackTransaction();
            LOG.error("Error deleting the user", e); 
            return false;
        } finally {
            closeEntityManager();
        }
    }
    
    public LUser getLUserCredentials(String username, String password) {
        try {
            String queryString;
            queryString = String.format("select luser from " + LUser.class.getName() + " luser where luser.username = :username "
                    + "and luser.password = :password", LUser.class.getName());
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (LUser) query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error("Error obtaining the LUser. Logging failed", e);
            return null;
        } finally {
            closeEntityManager();
        }
    }
}

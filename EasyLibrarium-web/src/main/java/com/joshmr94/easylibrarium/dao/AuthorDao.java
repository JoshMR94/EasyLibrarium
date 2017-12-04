package com.joshmr94.easylibrarium.dao;

import com.joshmr94.easylibrarium.model.Author;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;

/**
 *
 * @author joshmr94
 */
public class AuthorDao extends CommonSession<Author> {
    
    private static final Logger LOG = Logger.getLogger(Author.class);
    
    public AuthorDao(EntityManager em) {
        super(em);
    }
    
    public AuthorDao() {
        super();
    }
    
    public long countAuthors() {
        try {
            String queryString;
            queryString = String.format("select count(author.id) from " + Author.class.getName() + " author");
            Query query = getEntityManager().createQuery(queryString);
            return (long) query.getSingleResult();
        } catch (Exception e) {
            LOG.warn("Error obtaining the number of authors in the database", e);
            return 0L;
        } finally {
            closeEntityManager();
        }
    }
    
    public Author getAuthorById(Long id) {
        try {
            String queryString;
            //queryString = String.format("select * from author where author.id = :id", Author.class.getName());
            queryString = String.format("select author from " + Author.class.getName() + " author where author.id = :id", Author.class.getName());
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("id", id);
            return (Author) query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error("Error obtaining the author by id", e);
            return null;
        } finally {
            closeEntityManager();
        }
    }
    
    public List<Author> getAllAuthors() {
        try {
            String queryString;
            queryString = String.format("select a from " + Author.class.getName() + " a");
            Query query = getEntityManager().createQuery(queryString);
            return (List<Author>) query.getResultList();
        } catch (NoResultException e) {
            LOG.error("Error obtaining all the authors", e);
            return new ArrayList<>();
        } finally {
            closeEntityManager();
        }
    }
    
    public boolean updateAuthor(Author a) {
        beginTransaction();
        try {
            String queryString;
            /*queryString = String.format("update " + Author.class.getName() + " author set "
                    + "author.description = " + a.getDescription()
                    + ", author.name = " + a.getName()
                    + ", author.surname = " + a.getSurname()
                    + ", where author.id = " + a.getId());
            Query query = getEntityManager().createQuery(queryString);*/
            queryString = "update " + Author.class.getName() + " a SET a.description = :description" + 
                  ", a.name = :name" +  
                  ", a.surname = :surname" + 
                  " WHERE id = " + a.getId();
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("description", a.getDescription());
            query.setParameter("name", a.getName());
            query.setParameter("surname", a.getSurname());
            System.out.println("ejecuta update");
            query.executeUpdate();
            System.out.println("comita update");
            commitTransaction();
            return true;
        } catch (NoResultException e) {
            rollbackTransaction();
            LOG.error("Error updating the author", e); 
            return false;
        } finally {
            closeEntityManager();
        }
    }     
}

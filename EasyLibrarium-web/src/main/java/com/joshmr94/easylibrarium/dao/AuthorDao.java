package com.joshmr94.easylibrarium.dao;

import com.joshmr94.easylibrarium.model.Author;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
            queryString = String.format("select count(author.id) from author", Author.class.getName());
            Query query = getEntityManager().createQuery(queryString);
            return (long) query.getSingleResult();
        } catch (Exception e) {
            LOG.warn("Error obtaining the number of authors in the database", e);
            return 0L;
        } finally {
            closeEntityManager();
        }
    }
    
    public Author findAuthorById(Long id) {
        try {
            String queryString;
            queryString = String.format("select * from author where author.id = :id", Author.class.getName());
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
    
}

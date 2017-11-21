package com.joshmr94.easylibrarium.dao;

import com.joshmr94.easylibrarium.model.Book;
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
public class BookDao extends CommonSession<Book>{
    
    private static final Logger LOG = Logger.getLogger(Book.class);
    
    public BookDao(EntityManager em) {
        super(em);
    }
    
    public BookDao() {
        super();
    }
    
    public long countBooks() {
        try {
            String queryString;
            queryString = String.format("select count(book.id) from book", Book.class.getName());
            Query query = getEntityManager().createQuery(queryString);
            return (long) query.getSingleResult();
        } catch (Exception e) {
            LOG.warn("Error obtaining the number of books in the database", e);
            return 0L;
        } finally {
            closeEntityManager();
        }
    }
    
    public Book getBookById(Long id) {
        try {
            String queryString;
            queryString = String.format("select * from book where book.id = :id", Book.class.getName());
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("id", id);
            return (Book) query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error("Error obtaining the book by id", e);
            return null;
        } finally {
            closeEntityManager();
        }
    }
    
    public List<Book> getAllBooks() {
        try {
            String queryString;
            queryString = String.format("select c from " + Book.class.getName() + " c");
            Query query = getEntityManager().createQuery(queryString);
            return (List<Book>) query.getResultList();
        } catch (NoResultException e) {
            LOG.error("Error obtaining all the books", e);
            return new ArrayList<>();
        } finally {
            closeEntityManager();
        }
    }
    
}

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
            queryString = String.format("select count(book.id) from " + Book.class.getName() + " book");
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
            queryString = String.format("select book from " + Book.class.getName() + " book where book.id = :id", Book.class.getName());
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
    
    public Book insertBook(Book b){
        beginTransaction();
        try {
            getEntityManager().persist(b);
            commitTransaction();
            return b;
        } catch (NoResultException e) {
            rollbackTransaction();
            LOG.error("Error inserting the book", e); 
            return null;
        } finally {
            closeEntityManager();
        }
    }
    
    public boolean updateBook(Book b) {
        beginTransaction();
        try {
            String queryString;
            queryString = "update " + Book.class.getName() + " b SET b.ISBN = :isbn" + 
                  ", b.editorial = :editorial" +  
                  ", b.publicationDate = :publicationDate" +
                  ", b.rate = :rate" + 
                  ", b.title = :title" + 
                  " WHERE id = " + b.getId();
            
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("isbn", b.getISBN());
            query.setParameter("editorial", b.getEditorial());
            query.setParameter("publicationDate", b.getPublicationDate());
            query.setParameter("rate", b.getRate());
            query.setParameter("title", b.getTitle());
            
            query.executeUpdate();
            commitTransaction();
            return true;
        } catch (NoResultException e) {
            rollbackTransaction();
            LOG.error("Error updating the book", e); 
            return false;
        } finally {
            closeEntityManager();
        }
    }
    
    public boolean deleteBook(Long id) {
        beginTransaction();
        try {
            Query query = getEntityManager().createQuery("DELETE FROM " + Book.class.getName() + " book WHERE book.id = " + id);
            query.executeUpdate();
            commitTransaction();
            return true;
        } catch (NoResultException e) {
            rollbackTransaction();
            LOG.error("Error deleting the book", e); 
            return false;
        } finally {
            closeEntityManager();
        }
    }
    
    /*
    public List<Book> getBooksByLUserId(Long id) {
        try {
            String queryString;
            queryString = String.format("select b from " + Book.class.getName() + " b"
                    + " INNER JOIN books_luser bl"
                    + " ON b.id = bl.id"
                    + " where bl.id = :id", Book.class.getName());
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("id", id);
            return (List<Book>) query.getResultList();
        } catch (NoResultException e) {
            LOG.error("Error obtaining the book by id", e);
            return null;
        } finally {
            closeEntityManager();
        }
    }
    */
}

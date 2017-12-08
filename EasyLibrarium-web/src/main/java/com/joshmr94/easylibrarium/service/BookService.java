/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.service;

import com.joshmr94.easylibrarium.dao.BookDao;
import com.joshmr94.easylibrarium.dao.CommonSession;
import com.joshmr94.easylibrarium.model.Book;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joshmr94
 */
public class BookService {

    public BookService() {
    }
    
    public long countBooks(){
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            BookDao bookDao = new BookDao(em);
            long count = bookDao.countBooks();
            
            return count;
            
        } catch (NullPointerException ex) {
            System.out.println("ERROR :: " + ex.getMessage());
            return 0L;  
        } finally {
            em.close();
        }
    }
    
    public Book getBookById(Long id){
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            BookDao bookDao = new BookDao(em);
            Book result = bookDao.getBookById(id);
            
            return result;
            
        } catch (NullPointerException ex) {
            System.out.println("ERROR :: " + ex.getMessage());
            return null;  
        } finally {
            em.close();
        }
    }
    
    public List<Book> getAllBooks() {
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            BookDao bookDao = new BookDao(em);
            List<Book> list = bookDao.getAllBooks();
            
            return list;
            
        } catch (NullPointerException ex) {           
            System.out.println("ERROR :: " + ex.getMessage());  
            return null;
        } finally {
            em.close();
        }   
    }
    
    public Book insertBook(Book b){
        EntityManager em = CommonSession.buildEntityManager();
        em.getTransaction().begin();
        try {
            BookDao bookDao = new BookDao(em);
            Book result = bookDao.insertBook(b);
            em.getTransaction().commit();
            return result;
            
        } catch (NullPointerException ex) {           
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                System.out.println("ERROR :: " + ex.getMessage());
            }
            return null;
        } finally {
            em.close();
        } 
    }
    
    public boolean updateBook(Book b) {
        EntityManager em = CommonSession.buildEntityManager();
        em.getTransaction().begin();
        try {
            BookDao bookDao = new BookDao(em);
            Boolean result = bookDao.updateBook(b);
            em.getTransaction().commit();
            return result;
            
        } catch (NullPointerException ex) {           
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                System.out.println("ERROR :: " + ex.getMessage());
            }
            return false;
        } finally {
            em.close();
        } 
    }
    
    public boolean deleteBook(Long id) {
        EntityManager em = CommonSession.buildEntityManager();
        em.getTransaction().begin();
        try {
            BookDao bookDao = new BookDao(em);
            Boolean result = bookDao.deleteBook(id);
            em.getTransaction().commit();
            return result;
            
        } catch (NullPointerException ex) {           
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                System.out.println("ERROR :: " + ex.getMessage());
            }
            return false;
        } finally {
            em.close();
        } 
    }
    
    
}

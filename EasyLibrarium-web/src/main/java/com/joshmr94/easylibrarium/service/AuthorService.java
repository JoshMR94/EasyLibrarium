/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.service;

import com.joshmr94.easylibrarium.dao.AuthorDao;
import com.joshmr94.easylibrarium.dao.CommonSession;
import com.joshmr94.easylibrarium.model.Author;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joshmr94
 */
public class AuthorService {

    public AuthorService() {
    }
    
    public long countAuthors(){
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            AuthorDao authorDao = new AuthorDao(em);
            long count = authorDao.countAuthors();
            
            return count;
            
        } catch (NullPointerException ex) {
            System.out.println("ERROR :: " + ex.getMessage());
            return 0L;  
        } finally {
            em.close();
        }
    }
    
    public Author getAuthorById(Long id){
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            AuthorDao authorDao = new AuthorDao(em);
            Author result = authorDao.getAuthorById(id);
            
            return result;
            
        } catch (NullPointerException ex) {
            System.out.println("ERROR :: " + ex.getMessage());
            return null;  
        } finally {
            em.close();
        }
    }
    
    public List<Author> getAllAuthors() {
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            AuthorDao authorDao = new AuthorDao(em);
            List<Author> list = authorDao.getAllAuthors();
            
            return list;
            
        } catch (NullPointerException ex) {           
            System.out.println("ERROR :: " + ex.getMessage());  
            return null;
        } finally {
            em.close();
        }   
    }
    
    public boolean updateAuthor(Author a) {
        EntityManager em = CommonSession.buildEntityManager();
        em.getTransaction().begin();
        try {
            AuthorDao authorDao = new AuthorDao(em);
            Boolean result = authorDao.updateAuthor(a);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.service;

import com.joshmr94.easylibrarium.dao.CommonSession;
import com.joshmr94.easylibrarium.dao.GenreDao;
import com.joshmr94.easylibrarium.model.Genre;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joshmr94
 */
public class GenreService {
    
    public GenreService() {
    }
    
    public long countGenres(){
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            GenreDao genreDao = new GenreDao(em);
            long count = genreDao.countGenres();
            
            return count;
            
        } catch (NullPointerException ex) {
            System.out.println("ERROR :: " + ex.getMessage());
            return 0L;  
        } finally {
            em.close();
        }
    }
    
    public Genre getGenreById(Long id){
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            GenreDao genreDao = new GenreDao(em);
            Genre result = genreDao.getGenreById(id);
            
            return result;
            
        } catch (NullPointerException ex) {
            System.out.println("ERROR :: " + ex.getMessage());
            return null;  
        } finally {
            em.close();
        }
    }
    
    public List<Genre> getAllGenres() {
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            GenreDao genreDao = new GenreDao(em);
            List<Genre> list = genreDao.getAllGenres();
            
            return list;
            
        } catch (NullPointerException ex) {           
            System.out.println("ERROR :: " + ex.getMessage());  
            return null;
        } finally {
            em.close();
        }   
    }
    
    public Genre insertGenre(Genre g){
        EntityManager em = CommonSession.buildEntityManager();
        em.getTransaction().begin();
        try {
            GenreDao genreDao = new GenreDao(em);
            Genre result = genreDao.insertGenre(g);
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
    
    public boolean updateGenre(Genre g) {
        EntityManager em = CommonSession.buildEntityManager();
        em.getTransaction().begin();
        try {
            GenreDao genreDao = new GenreDao(em);
            Boolean result = genreDao.updateGenre(g);
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
    
    public boolean deleteGenre(Long id) {
        EntityManager em = CommonSession.buildEntityManager();
        em.getTransaction().begin();
        try {
            GenreDao genreDao = new GenreDao(em);
            Boolean result = genreDao.deleteGenre(id);
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

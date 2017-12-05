/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.dao;

import com.joshmr94.easylibrarium.model.Genre;
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
public class GenreDao extends CommonSession<Genre>{
    
    private static final Logger LOG = Logger.getLogger(Genre.class);
    
    public GenreDao(EntityManager em) {
        super(em);
    }
    
    public GenreDao() {
        super();
    }
    
    public long countGenres() {
        try {
            String queryString;
            queryString = String.format("select count(genre.id) from " + Genre.class.getName() + " genre");
            Query query = getEntityManager().createQuery(queryString);
            return (long) query.getSingleResult();
        } catch (Exception e) {
            LOG.warn("Error obtaining the number of genres in the database", e);
            return 0L;
        } finally {
            closeEntityManager();
        }
    }
    
    public Genre getGenreById(Long id) {
        try {
            String queryString;
            queryString = String.format("select genre from " + Genre.class.getName() + " genre where genre.id = :id", Genre.class.getName());
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("id", id);
            return (Genre) query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error("Error obtaining the genre by id", e);
            return null;
        } finally {
            closeEntityManager();
        }
    }
    
    public List<Genre> getAllGenres() {
        try {
            String queryString;
            queryString = String.format("select g from " + Genre.class.getName() + " g");
            Query query = getEntityManager().createQuery(queryString);
            return (List<Genre>) query.getResultList();
        } catch (NoResultException e) {
            LOG.error("Error obtaining all the genres", e);
            return new ArrayList<>();
        } finally {
            closeEntityManager();
        }
    }
    
    public Genre insertGenre(Genre g){
        beginTransaction();
        try {
            getEntityManager().persist(g);
            commitTransaction();
            return g;
        } catch (NoResultException e) {
            rollbackTransaction();
            LOG.error("Error inserting the genre", e); 
            return null;
        } finally {
            closeEntityManager();
        }
    }
    
    public boolean updateGenre(Genre g) {
        beginTransaction();
        try {
            String queryString;
            queryString = "update " + Genre.class.getName() + " g SET g.name = :name" + 
                  " WHERE id = " + g.getId();
            
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("name", g.getName());
            
            query.executeUpdate();
            commitTransaction();
            return true;
        } catch (NoResultException e) {
            rollbackTransaction();
            LOG.error("Error updating the genre", e); 
            return false;
        } finally {
            closeEntityManager();
        }
    }
    
    public boolean deleteGenre(Long id) {
        beginTransaction();
        try {
            Query query = getEntityManager().createQuery("DELETE FROM " + Genre.class.getName() + " genre WHERE genre.id = " + id);
            query.executeUpdate();
            commitTransaction();
            return true;
        } catch (NoResultException e) {
            rollbackTransaction();
            LOG.error("Error deleting the genre", e); 
            return false;
        } finally {
            closeEntityManager();
        }
    }
}

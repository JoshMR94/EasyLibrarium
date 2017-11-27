/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.service;

import com.joshmr94.easylibrarium.dao.CommonSession;
import com.joshmr94.easylibrarium.dao.LUserDao;
import com.joshmr94.easylibrarium.model.LUser;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joshmr94
 */
public class LUserService {

    public LUserService() {
    }
    
    public long countLUsers(){
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            LUserDao luserDao = new LUserDao(em);
            long count = luserDao.countLUsers();
            
            return count;
            
        } catch (NullPointerException ex) {
            System.out.println("ERROR :: " + ex.getMessage());
            return 0L;  
        } finally {
            em.close();
        }
    }
    
    public LUser getLUserById(Long id){
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            LUserDao luserDao = new LUserDao(em);
            LUser result = luserDao.getLUserById(id);
            
            return result;
            
        } catch (NullPointerException ex) {
            System.out.println("ERROR :: " + ex.getMessage());
            return null;  
        } finally {
            em.close();
        }
    }
    
    public List<LUser> getAllLUsers() {
        EntityManager em = CommonSession.buildEntityManager();
        try {
            
            LUserDao luserDao = new LUserDao(em);
            List<LUser> list = luserDao.getAllLUsers();
            
            return list;
            
        } catch (NullPointerException ex) {           
            System.out.println("ERROR :: " + ex.getMessage());  
            return null;
        } finally {
            em.close();
        }   
    }
}

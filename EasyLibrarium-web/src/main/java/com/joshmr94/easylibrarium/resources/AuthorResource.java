/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.resources;

import com.joshmr94.easylibrarium.dao.AuthorDao;
import com.joshmr94.easylibrarium.dao.CommonSession;
import com.joshmr94.easylibrarium.model.Author;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author joshmr94
 */
@Path("authors")
public class AuthorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AuthorResource
     */
    public AuthorResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthors(){
        EntityManager em = CommonSession.buildEntityManager();
        ArrayList<Author> result = new ArrayList<>();
        try {
            
            AuthorDao authorDao = new AuthorDao(em);
            List<Author> list = authorDao.getAllAuthors();
            for(int i = 0; i < list.size();  i++){
                result.add(list.get(i));
            }
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            
            System.out.println("ERROR :: " + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            
        } finally {
            em.close();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.resources;

import com.joshmr94.easylibrarium.dao.BookDao;
import com.joshmr94.easylibrarium.dao.CommonSession;
import com.joshmr94.easylibrarium.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author joshmr94
 */
@Path("book")
public class BookResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookResource
     */
    public BookResource() {
    }

    @GET
    @Path("ejemplo")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Correcto";
    }
    
    @GET
    @Path("books")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks(){
        EntityManager em = CommonSession.buildEntityManager();
        ArrayList<Book> result = new ArrayList<>();
        try {
            
            BookDao bookDao = new BookDao(em);
            List<Book> list = bookDao.getAllBooks();
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

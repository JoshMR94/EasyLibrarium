/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.resources;

import com.joshmr94.easylibrarium.dao.AuthorDao;
import com.joshmr94.easylibrarium.dao.CommonSession;
import com.joshmr94.easylibrarium.model.Author;
import com.joshmr94.easylibrarium.service.AuthorService;
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
import javax.ws.rs.PathParam;
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
        ArrayList<Author> result = new ArrayList<>();
        try {
            
            AuthorService authorService = new AuthorService();
            List<Author> list = authorService.getAllAuthors();
            for(int i = 0; i < list.size();  i++){
                result.add(list.get(i));
            }
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();  
        } 
    }
    
    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorsCount(){
        long result; 
        try {
            
            AuthorService authorService = new AuthorService();
            result = authorService.countAuthors();
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) { 
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @GET
    @Path("/author/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorById(@PathParam("id") Long id){
        Author result = new Author();
        try {
            
            AuthorService authorService = new AuthorService();
            result = authorService.getAuthorById(id);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @PUT
    @Path("/author/{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAuthor(@PathParam("id") Long id, Author author){
        Author authorById = new Author();
        Boolean result = false;
        try {
            
            AuthorService authorByIdService = new AuthorService();
            authorById = authorByIdService.getAuthorById(id);
            
            authorById.setBirthDate(author.getBirthDate());
            authorById.setDescription(author.getDescription());
            authorById.setName(author.getName());
            authorById.setSurname(author.getSurname());
            authorById.setBooks(author.getBooks());
            
            AuthorService authorService = new AuthorService();
            result = authorService.updateAuthor(authorById);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }

}

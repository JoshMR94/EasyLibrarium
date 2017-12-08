/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.resources;

import com.joshmr94.easylibrarium.model.Genre;
import com.joshmr94.easylibrarium.service.GenreService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author joshmr94
 */
@Path("genres")
public class GenreResource {
    
    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of GenreResource
     */
    public GenreResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGenres(){
        ArrayList<Genre> result = new ArrayList<>();
        try {
            
            GenreService genreService = new GenreService();
            List<Genre> list = genreService.getAllGenres();
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
    public Response getGenresCount(){
        long result; 
        try {
            
            GenreService genreService = new GenreService();
            result = genreService.countGenres();
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) { 
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @GET
    @Path("/genre/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGenreById(@PathParam("id") Long id){
        Genre result = new Genre();
        try {
            
            GenreService genreService = new GenreService();
            result = genreService.getGenreById(id);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @POST
    @Path("/genre/insert")  //insert authors with no books. Error if we have any books attached
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertGenre(Genre genre){
        Genre result;
        try {
            
            GenreService genreService = new GenreService();
            result = genreService.insertGenre(genre);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @PUT
    @Path("/genre/{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGenre(@PathParam("id") Long id, Genre genre){
        Genre genreById = new Genre();
        Boolean result = false;
        try {
            
            GenreService genreByIdService = new GenreService();
            genreById = genreByIdService.getGenreById(id);
            
            genreById.setName(genre.getName());
   
            GenreService genreService = new GenreService();
            result = genreService.updateGenre(genreById);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @DELETE
    @Path("/genre/{id}/delete")  //delete books (with no relations)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteGenre(@PathParam("id") Long id){
        Boolean result = false;
        try {
            
            GenreService genreService = new GenreService();
            result = genreService.deleteGenre(id);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.resources;

import com.joshmr94.easylibrarium.model.LUser;
import com.joshmr94.easylibrarium.service.LUserService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author AlumnoTarde
 */
@Path("users")
public class LUserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LUserResource
     */
    public LUserResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLUsers(){
        ArrayList<LUser> result = new ArrayList<>();
        try {
            
            LUserService luserService = new LUserService();
            List<LUser> list = luserService.getAllLUsers();
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
    public Response getLUsersCount(){
        long result; 
        try {
            
            LUserService luserService = new LUserService();
            result = luserService.countLUsers();
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) { 
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLUserById(@PathParam("id") Long id){
        LUser result = new LUser();
        try {
            
            LUserService luserService = new LUserService();
            result = luserService.getLUserById(id);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @POST
    @Path("/user/insert")  //insert authors with no books. Error if we have any books attached
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertLUser(LUser luser){
        LUser result;
        try {
            
            LUserService luserService = new LUserService();
            result = luserService.insertLUser(luser);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @PUT
    @Path("/user/{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateLUser(@PathParam("id") Long id, LUser luser){
        LUser luserById = new LUser();
        Boolean result = false;
        try {
            
            LUserService luserByIdService = new LUserService();
            luserById = luserByIdService.getLUserById(id);
            
            luserById.setUsername(luser.getUsername());
            luserById.setPassword(luser.getPassword());
            luserById.setDescription(luser.getDescription());
            luserById.setEmail(luser.getEmail());
            luserById.setUserType(luser.getUserType());
   
            
            LUserService luserService = new LUserService();
            result = luserService.updateLUser(luserById);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @DELETE
    @Path("/user/{id}/delete")  //delete books (with no relations)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLUser(@PathParam("id") Long id){
        Boolean result = false;
        try {
            
            LUserService luserService = new LUserService();
            result = luserService.deleteLUser(id);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @GET
    @Path("/user/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLUserCredentials(@PathParam("username") String username, @PathParam("password") String password){
        LUser result = new LUser();
        try {
            
            LUserService luserService = new LUserService();
            result = luserService.getLUserCredentials(username, password);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }

}

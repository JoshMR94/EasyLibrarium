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
import javax.ws.rs.GET;
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
    public Response getUsers(){
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
    public Response getUsersCount(){
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
    public Response getBookById(@PathParam("id") Long id){
        LUser result = new LUser();
        try {
            
            LUserService luserService = new LUserService();
            result = luserService.getLUserById(id);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }

}

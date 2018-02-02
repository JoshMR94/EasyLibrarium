/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.resources;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.gson.Gson;
import com.joshmr94.easylibrarium.model.LUser;
import com.joshmr94.easylibrarium.service.LUserService;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author AlumnoTarde
 */
@Path("facebook")
public class FacebookResource {
    
    @Context
    private UriInfo context;
    
    private static final String NETWORK_NAME = "Facebook";
    private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/v2.11/me?fields=id,name,email";
    private static final String clientId = "1160097630787700";
    private static final String clientSecret = "d8fd8f7a1c41160ca890cc5f425183b2";
    private static OAuth20Service service;
    
    /**
     * Creates a new instance of FacebookResource
     */
    public FacebookResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFacebookOAuthLogin(){
        try {          
            service = new ServiceBuilder(clientId)
                .apiSecret(clientSecret)
                .scope("email")
                .callback("http://localhost:8081/EasyLibrarium-web/webresources/facebook/callback")
                .build(FacebookApi.instance());
            
            return Response.temporaryRedirect(new URI(service.getAuthorizationUrl())).build();
            
        } catch (URISyntaxException ex) { 
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();      
        }
    }
    
    @GET
    @Path("/callback")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCallback(@QueryParam("code") String code){
        LUser result = new LUser();
        LUser insertResult = new LUser();
        try {          
            final OAuth2AccessToken accessToken = service.getAccessToken(code);
            final OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
            service.signRequest(accessToken, request);
            final com.github.scribejava.core.model.Response response = service.execute(request);
            
            //insertar en base de datos el body
            /*
            JsonNode tree = mapper.readTree(response.getBody());
            result.setId(tree.get("id").asLong());
            result.setEmail(tree.get("email").asText());
            result.setDescription(tree.get("name").asText());
            */     
            
            result = new Gson().fromJson(response.getBody(), LUser.class);
            insertResult.setEmail(result.getEmail());
            insertResult.setUsername("randomValueUser"); //
            insertResult.setPassword("randomValuePass");
            
            LUserService luserService = new LUserService();
            luserService.insertLUser(insertResult);
            
            return Response.ok(insertResult).build();
            
        } catch (IOException | InterruptedException | ExecutionException ex) { 
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();      
        }
    }
    
    
    
    
    
}

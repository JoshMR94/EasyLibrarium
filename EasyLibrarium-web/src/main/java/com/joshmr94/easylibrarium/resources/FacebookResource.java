/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.resources;

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.joshmr94.easylibrarium.model.Genre;
import com.joshmr94.easylibrarium.service.GenreService;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
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
    private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/v2.11/me?fields=id,email,picture";
    private static final String clientId = "";
    private static final String clientSecret = "";
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
        try {          
            final OAuth2AccessToken accessToken = service.getAccessToken(code);
            final OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
            service.signRequest(accessToken, request);
            final com.github.scribejava.core.model.Response response = service.execute(request);
            
            return Response.ok(response.getBody()).build();
            
        } catch (IOException | InterruptedException | ExecutionException ex) { 
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();      
        }
    }
    
    
    
    
    
}

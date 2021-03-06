/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.resources;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author joshmr94
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.joshmr94.easylibrarium.resources.AuthorResource.class);
        resources.add(com.joshmr94.easylibrarium.resources.BookResource.class);
        resources.add(com.joshmr94.easylibrarium.resources.FacebookResource.class);
        resources.add(com.joshmr94.easylibrarium.resources.GenreResource.class);
        resources.add(com.joshmr94.easylibrarium.resources.LUserResource.class);
    }
    
}

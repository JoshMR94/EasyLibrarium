/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.resources;

import com.joshmr94.easylibrarium.model.Book;
import com.joshmr94.easylibrarium.service.BookService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author joshmr94
 */
@Path("books")
public class BookResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookResource
     */
    public BookResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks(){
        ArrayList<Book> result = new ArrayList<>();
        try {
            
            BookService bookService = new BookService();
            List<Book> list = bookService.getAllBooks();
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
    public Response getBooksCount(){
        long result; 
        try {
            
            BookService bookService = new BookService();
            result = bookService.countBooks();
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) { 
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @GET
    @Path("/book/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookById(@PathParam("id") Long id){
        Book result = new Book();
        try {
            
            BookService bookService = new BookService();
            result = bookService.getBookById(id);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @POST
    @Path("/book/insert")  //insert authors with no books. Error if we have any books attached
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertBook(Book book){
        Book result;
        try {
            
            BookService bookService = new BookService();
            result = bookService.insertBook(book);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @PUT
    @Path("/book/{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAuthor(@PathParam("id") Long id, Book book){
        Book bookById = new Book();
        Boolean result = false;
        try {
            
            BookService bookByIdService = new BookService();
            bookById = bookByIdService.getBookById(id);
            
            bookById.setISBN(book.getISBN());
            bookById.setEditorial(book.getEditorial());
            bookById.setPublicationDate(book.getPublicationDate());
            bookById.setRate(book.getRate());
            bookById.setTitle(book.getTitle());
   
            
            BookService bookService = new BookService();
            result = bookService.updateBook(bookById);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
    @DELETE
    @Path("/book/{id}/delete")  //delete books (with no relations)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAuthor(@PathParam("id") Long id){
        Boolean result = false;
        try {
            
            BookService bookService = new BookService();
            result = bookService.deleteBook(id);
            
            return Response.ok(result).build();
            
        } catch (NullPointerException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();   
        }
    }
    
}

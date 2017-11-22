/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joshmr94
 */
@Entity
@Table(name = "book")
public class Book implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    
    @Column(name = "category", nullable = false, length = 255)
    private String category;
    
    @Column(name = "genre", nullable = false, length = 255)
    private String genre;
    
    @Column(name = "ISBN", nullable = false, length = 255)
    private String ISBN;
    
    @Column(name = "editorial", nullable = true, length = 255)
    private String editorial;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "publication_date", nullable = true)
    private Date publicationDate;
    
    @ManyToMany(mappedBy = "books") //mapped for books attribute in User
    @JsonIgnore
    private List<LUser> users;
    
    @ManyToMany(mappedBy = "books") //mapped for books attribute in Author
    @JsonIgnore
    private List<Author> authors;

    public Book(Long id, String title, String category, String genre, String ISBN, String editorial, Date publicationDate, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.genre = genre;
        this.ISBN = ISBN;
        this.editorial = editorial;
        this.publicationDate = publicationDate;
        this.authors = authors;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<LUser> getUsers() {
        return users;
    }

    public void setUsers(List<LUser> users) {
        this.users = users;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }   

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", category=" + category + ", genre=" + genre + ", ISBN=" + ISBN + ", editorial=" + editorial + ", publicationDate=" + publicationDate + ", users=" + users + ", authors=" + authors + '}';
    }
       
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshmr94.easylibrarium.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author joshmr94
 */
@Entity
@Table(name = "luser")
public class LUser implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "username", nullable = false, length = 255, unique = true)
    private String username;
    
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    
    @Column(name = "email", nullable = true, length = 255)
    private String email;
    
    @Column(nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;
    
    /**
     * User types enum
     */
    public enum UserType {
        ADMIN,
        USER
    }
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="books_luser",
            joinColumns=@JoinColumn(name = "luser_id", referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name="book_id", referencedColumnName = "id")
    )
    private List<Book> books;

    public LUser() {
    }

    public LUser(Long id, String username, String password, String description, String email, UserType userType, List<Book> books) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.description = description;
        this.email = email;
        this.userType = userType;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "LUser{" + "id=" + id + ", username=" + username + ", password=" + password + ", description=" + description + ", email=" + email + ", userType=" + userType + ", books=" + books + '}';
    }
    
    
    
}

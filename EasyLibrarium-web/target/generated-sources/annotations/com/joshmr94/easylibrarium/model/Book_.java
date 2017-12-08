package com.joshmr94.easylibrarium.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, String> editorial;
	public static volatile SingularAttribute<Book, String> ISBN;
	public static volatile SingularAttribute<Book, Integer> rate;
	public static volatile ListAttribute<Book, Genre> genres;
	public static volatile SingularAttribute<Book, Long> id;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Date> publicationDate;
	public static volatile ListAttribute<Book, LUser> users;
	public static volatile ListAttribute<Book, Author> authors;

}


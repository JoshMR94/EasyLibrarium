package com.joshmr94.easylibrarium.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Genre.class)
public abstract class Genre_ {

	public static volatile ListAttribute<Genre, Book> books;
	public static volatile SingularAttribute<Genre, String> name;
	public static volatile SingularAttribute<Genre, Long> id;

}


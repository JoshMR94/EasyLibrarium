package com.joshmr94.easylibrarium.model;

import com.joshmr94.easylibrarium.model.LUser.UserType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LUser.class)
public abstract class LUser_ {

	public static volatile SingularAttribute<LUser, String> password;
	public static volatile ListAttribute<LUser, Book> books;
	public static volatile SingularAttribute<LUser, String> description;
	public static volatile SingularAttribute<LUser, Long> id;
	public static volatile SingularAttribute<LUser, UserType> userType;
	public static volatile SingularAttribute<LUser, String> email;
	public static volatile SingularAttribute<LUser, String> username;

}


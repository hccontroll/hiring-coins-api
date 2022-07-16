package com.hiringcoders.domain.model;

import java.time.OffsetDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ {

	public static volatile SingularAttribute<Client, Long> coinBalance;
	public static volatile SingularAttribute<Client, String> name;
	public static volatile SingularAttribute<Client, OffsetDateTime> lastPurchase;
	public static volatile SingularAttribute<Client, Long> id;
	public static volatile SingularAttribute<Client, String> uuid;
	public static volatile SingularAttribute<Client, String> email;

	public static final String COIN_BALANCE = "coinBalance";
	public static final String NAME = "name";
	public static final String LAST_PURCHASE = "lastPurchase";
	public static final String ID = "id";
	public static final String UUID = "uuid";
	public static final String EMAIL = "email";

}


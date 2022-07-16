package com.hiringcoders.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transaction.class)
public abstract class Transaction_ {

	public static volatile SingularAttribute<Transaction, BigDecimal> purchaseValue;
	public static volatile SingularAttribute<Transaction, OffsetDateTime> createdAt;
	public static volatile SingularAttribute<Transaction, OffsetDateTime> purchaseDate;
	public static volatile SingularAttribute<Transaction, Long> coins;
	public static volatile SingularAttribute<Transaction, String> purchaseId;
	public static volatile SingularAttribute<Transaction, Client> client;
	public static volatile SingularAttribute<Transaction, Long> id;
	public static volatile SingularAttribute<Transaction, TransactionType> type;
	public static volatile SingularAttribute<Transaction, String> uuid;

	public static final String PURCHASE_VALUE = "purchaseValue";
	public static final String CREATED_AT = "createdAt";
	public static final String PURCHASE_DATE = "purchaseDate";
	public static final String COINS = "coins";
	public static final String PURCHASE_ID = "purchaseId";
	public static final String CLIENT = "client";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String UUID = "uuid";

}


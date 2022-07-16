package com.hiringcoders.api.v1.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.hiringcoders.domain.model.TransactionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionModel {
	
	private String uuid;
	
	private String clientUuid;
	
	private String clientName;
	
	private String clientEmail;
	
	private String purchaseId;
	
	private BigDecimal purchaseValue;
	
	private OffsetDateTime purchaseDate;
	
	private TransactionType type;
	
	private Long coins;

}
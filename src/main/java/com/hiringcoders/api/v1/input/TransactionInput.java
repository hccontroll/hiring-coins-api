package com.hiringcoders.api.v1.input;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.hiringcoders.domain.model.TransactionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionInput {
	
	private String clientUuid;
	
	private String purchaseId;
	
	private BigDecimal purchaseValue;
	
	private OffsetDateTime purchaseDate;
	
	private TransactionType type;
	
	private Long coins;

}
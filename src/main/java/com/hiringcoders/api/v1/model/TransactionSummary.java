package com.hiringcoders.api.v1.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.hiringcoders.domain.model.TransactionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionSummary {
	
	private String uuid;
	
	private String purchaseId;
	
	private BigDecimal purchaseValue;
	
	private OffsetDateTime purchaseDateTime;
	
	private TransactionType type;
	
	private Long coins;

}
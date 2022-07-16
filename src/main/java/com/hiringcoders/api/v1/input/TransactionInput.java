package com.hiringcoders.api.v1.input;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.hiringcoders.domain.model.TransactionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionInput {

	@NotBlank
	@Size(max = 40)
	private String clientUuid;
	
	@Size(max = 100)
	private String purchaseId;
	
	@Positive
	private BigDecimal purchaseValue;
	
	private OffsetDateTime purchaseDate;
	
	@NotNull
	private TransactionType type;
	
	@NotNull
	@Positive
	private Long coins;

}
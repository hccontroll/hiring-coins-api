package com.hiringcoders.api.v1.input;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.hiringcoders.core.validation.Purchase;
import com.hiringcoders.domain.model.TransactionType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Purchase(purchaseIdField = "purchaseId", purchaseValueField = "purchaseValue", purchaseDateField = "purchaseDate")
@Getter
@Setter
public class TransactionInput {

	@Schema(example = "533988cb-8cda-49b5-8607-c53b649701e9", description = "UUID do Cliente", required = true)
	@NotBlank
	@Size(max = 40)
	private String clientUuid;

	@Schema(example = "c53b649701e9", description = "ID da Compra Associada", required = false)
	@Size(max = 100)
	private String purchaseId;

	@Schema(example = "50.6", description = "Valor da Compra Associada", required = false)
	@Positive
	private BigDecimal purchaseValue;

	@Schema(example = "2022-07-16T13:51:05Z", description = "Data/Hora da Compra Associada", required = false)
	private OffsetDateTime purchaseDate;

	@Schema(example = "CREDIT", description = "Tipo da Transação (Crédito ou Débito)", required = true)
	@NotNull
	private TransactionType type;

	@Schema(example = "50", description = "Saldo de Hiring Coins da Transação", required = true)
	@NotNull
	@Positive
	private Long coins;

}
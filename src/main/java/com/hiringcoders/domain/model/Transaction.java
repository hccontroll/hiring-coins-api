package com.hiringcoders.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
public class Transaction {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String uuid;
	
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	private String purchaseId;
	
	private BigDecimal purchaseValue;
	
	private OffsetDateTime purchaseDate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TransactionType type;
	
	@Column(nullable = false)
	private Long coins;
	
	@CreationTimestamp
	private OffsetDateTime createdAt;
	
	@PrePersist
	private void generateUUID() {
		setUuid(UUID.randomUUID().toString());
	}
	
	public boolean isCredit() {
		return TransactionType.CREDIT.equals(this.type);
	}
	
	public boolean isDebit() {
		return TransactionType.DEBIT.equals(this.type);
	}

}

package com.hiringcoders.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.hiringcoders.domain.exception.InsufficientCoinBalanceException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
public class Client {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String uuid;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private Long coinBalance;
	
	private OffsetDateTime lastPurchase;
	
	public Client() {
		this.coinBalance = Long.valueOf(0);
	}
	
	@PrePersist
	private void generateUUID() {
		setUuid(UUID.randomUUID().toString());
	}

	public void registerTransaction(Transaction transaction) {
		transaction.setClient(this);
		
		if (transaction.isCredit()) {
			creditTransaction(transaction);
		} else {
			debitTransaction(transaction);
		}
		
		registerLastPurchase(transaction);
	}
	
	private void creditTransaction(Transaction transaction) {
		this.coinBalance += transaction.getCoins();
	}

	private void debitTransaction(Transaction transaction) {
		if (transaction.getCoins() > this.coinBalance) {
			throw new InsufficientCoinBalanceException();
		}
		
		this.coinBalance -= transaction.getCoins();
	}
	
	private void registerLastPurchase(Transaction transaction) {
		if (transaction.getPurchaseDate() != null) {
			this.setLastPurchase(transaction.getPurchaseDate());
		}		
	}
	
}
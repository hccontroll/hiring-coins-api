package com.hiringcoders.api.v1.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientModel {
	
	private String uuid;
	
	private String name;
	
	private String email;

	private OffsetDateTime lastPurchase;
	
	private Long coinBalance;
	
}
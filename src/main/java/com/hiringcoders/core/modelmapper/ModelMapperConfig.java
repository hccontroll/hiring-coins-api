package com.hiringcoders.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hiringcoders.api.v1.input.TransactionInput;
import com.hiringcoders.domain.model.Transaction;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();

		modelMapper.createTypeMap(TransactionInput.class, Transaction.class)
				.addMappings(mapper -> mapper.skip(Transaction::setId));

		return modelMapper;
	}

}

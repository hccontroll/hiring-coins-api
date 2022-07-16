package com.hiringcoders.infrastructure.repository;

import static com.hiringcoders.infrastructure.repository.specification.ClientSpecification.usingFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.hiringcoders.domain.filter.ClientFilter;
import com.hiringcoders.domain.model.Client;
import com.hiringcoders.domain.repository.ClientRepository;
import com.hiringcoders.domain.repository.ClientRepositoryQueries;

@Repository
public class ClientRepositoryImpl implements ClientRepositoryQueries {

	@Autowired
	@Lazy
	private ClientRepository clientRepository;

	@Override
	public Page<Client> findUsingFilter(ClientFilter filter, Pageable pageable) {
		return clientRepository.findAll(usingFilter(filter), pageable);
	}

}

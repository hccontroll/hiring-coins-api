package com.hiringcoders.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hiringcoders.domain.filter.ClientFilter;
import com.hiringcoders.domain.model.Client;

public interface ClientRepositoryQueries {
	
	Page<Client> findUsingFilter(ClientFilter filter, Pageable pageable);

}
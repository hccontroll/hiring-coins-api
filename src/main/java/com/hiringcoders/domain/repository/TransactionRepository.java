package com.hiringcoders.domain.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiringcoders.domain.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	Page<Transaction> findByClientId(Long clientId, Pageable pageable);
	
	Optional<Transaction> findByUuid(String uuid);

}
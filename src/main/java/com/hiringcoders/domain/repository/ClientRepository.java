package com.hiringcoders.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiringcoders.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, ClientRepositoryQueries {
	
	Optional<Client> findByUuid(String uuid);
	
	Optional<Client> findByEmail(String email);

}
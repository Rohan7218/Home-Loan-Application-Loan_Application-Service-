package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.LedgerDetails;

@Repository
public interface LedgerDetailsRepository extends JpaRepository<LedgerDetails, Integer>
{

}

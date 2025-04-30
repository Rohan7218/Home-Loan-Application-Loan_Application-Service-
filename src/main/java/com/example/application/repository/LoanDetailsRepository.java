package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.LoanDetails;

@Repository
public interface LoanDetailsRepository extends JpaRepository<LoanDetails,	 Integer>
{

}

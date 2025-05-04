package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.IncomeDetails;
@Repository
public interface IncomeDetailsRepository extends JpaRepository<IncomeDetails, Integer>
{

}

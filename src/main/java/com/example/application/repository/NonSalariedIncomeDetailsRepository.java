package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.NonSalaried;

@Repository
public interface NonSalariedIncomeDetailsRepository extends JpaRepository<NonSalaried, Integer>
{

}

package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.Salaried;

@Repository
public interface SalariedIncomeDetailsRepository extends JpaRepository<Salaried, Integer>
{

}

package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.EmployeeDetails;
@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer>
{

}

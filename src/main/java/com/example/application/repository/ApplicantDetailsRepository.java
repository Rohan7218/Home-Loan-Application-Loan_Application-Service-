package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.ApplicantDetails;

@Repository
public interface ApplicantDetailsRepository extends JpaRepository<ApplicantDetails, Integer> 
{

}

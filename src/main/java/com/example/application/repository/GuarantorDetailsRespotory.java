package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.GuarantorDetails;

@Repository
public interface GuarantorDetailsRespotory extends JpaRepository<GuarantorDetails, Integer>
{

}

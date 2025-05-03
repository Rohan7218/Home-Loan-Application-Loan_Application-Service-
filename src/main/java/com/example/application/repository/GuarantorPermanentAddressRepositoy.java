package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.GuarantorPermanentAddress;

@Repository
public interface GuarantorPermanentAddressRepositoy extends JpaRepository<GuarantorPermanentAddress, Integer>{

}

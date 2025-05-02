package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.GuarantorLoaclAddress;

@Repository
public interface GuarantorLoaclAddressRepository extends JpaRepository<GuarantorLoaclAddress, Integer>{

}

package com.example.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Guarantor_Details")
public class GuarantorDetails 
{
	@Id
	@SequenceGenerator(name = "GuarantorDetails_ID", sequenceName = "GuarantorDetails_ID", allocationSize = 1, initialValue =101)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "GuarantorDetails_ID")
	@Column(name ="Guarantor_Id")
	private Integer GuarantorDetailsID;
}

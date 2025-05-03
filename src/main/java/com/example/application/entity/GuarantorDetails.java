package com.example.application.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name ="Guarantor_Name")
	private String guarantorFirstName;
	
	@Column(name ="Guarantor_Middle_Name")
	private String guarantorMiddleName;
	
	@Column(name ="Guarantor_Last_Name")
	private String guarantorLastName;
	
	@Column(name ="Guarantor_DateOfBirth")
	private LocalDate guarantorDateOfBirth;
	
	@Column(name ="Guarantor_Relationship_with_Customer")
	private String guarantorRelationshipwithCustomer;
	
	@Column(name ="Guarantor_MobileNumber")
	private Long guarantorMobileNumber;
	
	@Column(name ="Guarantor_AdharCardNo")
	private Long guarantorAdharCardNo;
	
	@Column(name ="Guarantor_MortgageDetails")
	private String guarantorMortgageDetails;
	
	@Column(name ="Guarantor_JobDetails")
	private String guarantorJobDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="Guarantor_LOcal_Address")
	private GuarantorLocalAddress guarantorLoaclAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="Guarantor_Permanent_Address")
	private GuarantorPermanentAddress guarantorPermanentAddress;

}

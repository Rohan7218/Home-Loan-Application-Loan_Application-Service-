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
@Table(name = "Guarantor_Permanent_Address")
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuarantorPermanentAddress {

	@Id
	@SequenceGenerator(name = "Guarantor_Permanent_AddressId",sequenceName = "Guarantor_Permanent_AddressId",allocationSize = 1,initialValue = 101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Guarantor_Permanent_AddressId" )
	@Column(name = "Permanent_Local_Address_ID")
	private Integer permanentAddressId;

	@Column(name = "Guarantor_Permanent_Areaname")
	private String permanentAreaname;

	@Column(name = "Guarantor_Permanent_Cityname")
	private String permanentCityname;

	@Column(name = "Guarantor_Permanent_District")
	private String permanentDistrict;

	@Column(name = "Guarantor_Permanent_State")
	private String permanentState;

	@Column(name = "Guarantor_Permanent_Pincode")
	private Integer permanentPincode;

	@Column(name = "Guarantor_Permanent_Housenumber")
	private Integer permanentHouseNumber;

	@Column(name = "Guarantor_Local_Streetname")
	private String permanentStreetName;
}

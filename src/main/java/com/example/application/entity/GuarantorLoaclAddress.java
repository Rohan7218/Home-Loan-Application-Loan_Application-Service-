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
@Table(name = "Guarantor_Local_Address")
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuarantorLoaclAddress {

	@Id
	@SequenceGenerator(name = "Guarantor_Local_AddressId",sequenceName = "Guarantor_Local_AddressId",allocationSize = 1,initialValue = 101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Guarantor_Local_AddressId" )
	@Column(name = "Guarantor_Local_Address_ID")
	private Integer localAddressId;

	@Column(name = "Guarantor_Local_Areaname")
	private String localAreaname;

	@Column(name = "Guarantor_Local_Cityname")
	private String localCityname;

	@Column(name = "Guarantor_Local_District")
	private String localDistrict;

	@Column(name = "Guarantor_Local_State")
	private String localState;

	@Column(name = "Guarantor_Local_Pincode")
	private Integer localPincode;

	@Column(name = "Guarantor_Local_Housenumber")
	private Integer localHouseNumber;

	@Column(name = "Guarantor_Local_Streetname")
	private String localStreetName;
}

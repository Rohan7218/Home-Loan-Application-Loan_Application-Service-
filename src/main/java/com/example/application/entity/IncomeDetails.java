package com.example.application.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.example.application.dto.OccupationEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Income_Details")
public class IncomeDetails
{
	@Id
	@SequenceGenerator(name = "IncomeDetails_ID", sequenceName = "IncomeDetails_ID", allocationSize = 1, initialValue =101)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "IncomeDetails_ID")
	@Column(name ="Income_Id")
	private Integer incomeId;
	
	@Enumerated(EnumType.STRING)
	private OccupationEnum occupation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "salaried_Id")
	private Salaried salariedId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Non_Salaried_Id")
	private NonSalaried NonSalariedId;
	
}

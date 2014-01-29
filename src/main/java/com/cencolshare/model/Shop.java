package com.cencolshare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_shops")
public class Shop {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_shop_id")
	@SequenceGenerator(name="seq_shop_id", sequenceName="seq_shop_id")
	@Column(name="shop_id")  
	private Integer id;

	@Column(name="shop_name")
	private String name;

	@Column(name = "employee_number")
	private Integer emplNumber;
	
}

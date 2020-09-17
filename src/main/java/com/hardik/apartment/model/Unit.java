package com.hardik.apartment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unit")
public class Unit {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="unique_Id")
	private int id;
	@Column(name="unit_Number")
	private int unit_number;
	@Column (name="unit_type")
	private String unit_type;
	@Column(name="unit_availability")
	private String unit_availability;

	public Unit(int id, int unit_number, String unit_type, String unit_availability) {
		super();
		this.id = id;
		this.unit_number = unit_number;
		this.unit_type = unit_type;
		this.unit_availability = unit_availability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUnit_number() {
		return unit_number;
	}

	public void setUnit_number(int unit_number) {
		this.unit_number = unit_number;
	}

	public String getUnit_type() {
		return unit_type;
	}

	public void setUnit_type(String unit_type) {
		this.unit_type = unit_type;
	}

	public String getUnit_availability() {
		return unit_availability;
	}

	public void setUnit_availability(String unit_availability) {
		this.unit_availability = unit_availability;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
	



package com.hardik.apartment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class Application {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="application_id")
	private int id;
	@Column(name="applicant_firstName")
	private String firstName;
	@Column(name="applicant_lastName")
	private String lastName;
	@Column(name="applicant_emai")
	private String email;
	@Column(name="applicant_phone")
    private String phone;
	@Column(name="applicant_apartment_Type")
    private String apartmentType;
	@Column(name="applicant_startingDate")
    private String startingDate;
	@Column(name="applicant_leaseDuration")
    private String leaseDuration;
	@Column(name="applicant_numberOfHouseHold")
    private String numberOfResident;
	@Column(name="applicant_occupation")
    private String occupation;
	public Application(int id, String firstName, String lastName, String email, String phone, String apartmentType,
			String startingDate, String leaseDuration, String numberOfResident, String occupation) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.apartmentType = apartmentType;
		this.startingDate = startingDate;
		this.leaseDuration = leaseDuration;
		this.numberOfResident = numberOfResident;
		this.occupation = occupation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getApartmentType() {
		return apartmentType;
	}
	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}
	public String getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}
	public String getLeaseDuration() {
		return leaseDuration;
	}
	public void setLeaseDuration(String leaseDuration) {
		this.leaseDuration = leaseDuration;
	}
	public String getNumberOfResident() {
		return numberOfResident;
	}
	public void setNumberOfResident(String numberOfResident) {
		this.numberOfResident = numberOfResident;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

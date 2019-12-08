/**
 * 
 */
package com.se641.se641backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author zknab
 *
 */
@Entity
public class Address implements Serializable{

	/**
	 * Default Serial Version
	 */
	private static final long serialVersionUID = -4363869787125160759L;
	
	
	@Column(name = "address_line_one")
	@NotBlank(message = "Please enter address line one")
	private String addressLineOne;
	@Column(name = "address_line_two")
	@NotBlank(message = "Please enter address line two")
	private String addressLineTwo;
	@NotBlank(message = "Please enter city")
	private String city;
	@NotBlank(message = "Please enter state")
	private String state;
	private String country;
	@Column(name = "postal_code")
	@NotBlank(message = "Please enter postal code")
	private String postalCode;
	private boolean shipping;
	private boolean billing;
	
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User user;
	

	/**
	 * 
	 */
	public Address() {
	}

	/**
	 * @param addressLineOne
	 * @param addressLineTwo
	 * @param city
	 * @param state
	 * @param country
	 * @param postalCode
	 * @param shipping
	 * @param billing

	 */
	public Address(String addressLineOne, String addressLineTwo, String city, String state, String country,
			String postalCode, boolean shipping, boolean billing) {
//		super();
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.shipping = shipping;
		this.billing = billing;
		
	}

	/**
	 * @return the addressLineOne
	 */
	public String getAddressLineOne() {
		return addressLineOne;
	}

	/**
	 * @param addressLineOne the addressLineOne to set
	 */
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	/**
	 * @return the addressLineTwo
	 */
	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	/**
	 * @param addressLineTwo the addressLineTwo to set
	 */
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the shipping
	 */
	public boolean isShipping() {
		return shipping;
	}

	/**
	 * @param shipping the shipping to set
	 */
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	/**
	 * @return the billing
	 */
	public boolean isBilling() {
		return billing;
	}

	/**
	 * @param billing the billing to set
	 */
	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", postalCode=" + postalCode + ", shipping=" + shipping
				+ ", billing=" + billing + ", id=" + id + ", user=" + user + "]";
	}
	
	///
	
	
	
}

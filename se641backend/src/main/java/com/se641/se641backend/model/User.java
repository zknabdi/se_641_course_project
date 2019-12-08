/**
 * 
 */
package com.se641.se641backend.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author zknab
 *
 */
@Entity
@Table(name ="user_detail")
public class User implements Serializable{
	
	/**
	 * 	Default Serial Version
	 */
	private static final long serialVersionUID = 225672610604652457L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	@NotBlank(message = "Please enter first name")
	private String firstName;
	@Column(name = "last_name")
	@NotBlank(message = "Please enter last name")
	private String lastName;
	@NotBlank(message = "Please enter email")
	private String email;
	@NotBlank(message = "Please enter contact number")
	private String contactNumber;
	private String role;
	private String password;
	
	
	/*
	 *  String to confirm password transient field
	 */
	@Transient
	private String confirmePassword;
	
	private boolean enabled = true;
	@OneToOne(mappedBy = "user", cascade =CascadeType.ALL)
	private Cart cart;
	
	/**
	 * 
	 */
	public User() {
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param contactNumber
	 * @param role
	 * @param password

	 */
	public User(int id, String firstName, String lastName, String email, String contactNumber, String role,
			String password) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.role = role;
		this.password = password;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmePassword
	 */
	public String getConfirmePassword() {
		return confirmePassword;
	}

	/**
	 * @param confirmePassword the confirmePassword to set
	 */
	public void setConfirmePassword(String confirmePassword) {
		this.confirmePassword = confirmePassword;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password
				+ ", confirmePassword=" + confirmePassword + ", enabled=" + enabled + ", cart=" + cart + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}

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
import javax.persistence.OneToOne;

/**
 * @author zknab
 *
 */
@Entity
public class Cart implements Serializable {

	/**
	 * Default Serial Version
	 */
	private static final long serialVersionUID = 2175327504974486841L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/*---------*/
	// @JoinColumn(name = "uid")
	@OneToOne
	private User user;
	/*---------*/

	@Column(name = "grand_total")
	private double grandTotal;
	@Column(name = "cart_lines")
	private int cartLines;
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
	/**
	 * @return the grandTotal
	 */
	public double getGrandTotal() {
		return grandTotal;
	}
	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	/**
	 * @return the cartLines
	 */
	public int getCartLines() {
		return cartLines;
	}
	/**
	 * @param cartLines the cartLines to set
	 */
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	
	
	

}

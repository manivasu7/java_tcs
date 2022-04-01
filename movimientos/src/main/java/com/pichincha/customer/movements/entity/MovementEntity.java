/**
 * 
 */
package com.pichincha.customer.movements.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jjoseph
 *
 */
@Entity
@Table(name = "TBL_MOVEMENTS")
@Getter
@Setter
public class MovementEntity implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "accountNumberOrgin")
	private String accountNumberOrgin;
	@Column(name = "accountNumberDestination")
	private String accountNumberDestination;
	@Column(name = "description")
	private String description;
	
	public MovementEntity() {}
	
	public MovementEntity(String accountNumberOrgin, String accountNumberDestination, String description) {
		this.accountNumberOrgin = accountNumberOrgin;
		this.accountNumberDestination = accountNumberDestination;
		this.description = description;
	}
	

}

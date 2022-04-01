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
@Table(name = "TBL_ACCOUNT")
@Getter
@Setter
public class AccountEntity implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "accountNumber")
	private String accountNumber;
	@Column(name = "accountName")
	private String accountName;
	@Column(name = "identificationNumber")
	private String identificationNumber;
	@Column (name = "status")
	private Boolean status;
	
	public AccountEntity(){}
	
	public AccountEntity(String accountNumber, String accountName, String identificationNumber, Boolean status) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.identificationNumber = identificationNumber;
		this.status = status;
	}
	

}

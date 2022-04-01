package com.cgranada.java_tcs1.dto;

import com.cgranada.java_tcs1.model.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

	private Integer id;
	private String accountNumber;
	private String acoountOwner;
	
	public  Account toEntity() {
		return new Account(id,accountNumber,acoountOwner);
	}
}

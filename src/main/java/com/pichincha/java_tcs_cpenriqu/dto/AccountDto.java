package com.pichincha.java_tcs_cpenriqu.dto;


import com.pichincha.java_tcs_cpenriqu.model.Account;

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
	private String name;
	private String code;
	
	public Account toEntity() {
		return new Account(id,name,code);
	}
}
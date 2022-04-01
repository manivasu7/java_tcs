package com.pichincha.java_tcs_cpenriqu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementDto {

	private Integer id;
	private String name;
	private String code;
	private AccountDto country;
	
}
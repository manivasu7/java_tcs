package com.cgranada.java_tcs1.dto;

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
	private String dateIniOp;
	private Integer mount;
	private AccountDto account;
}

package com.example.java_tcs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovimientosDto {

	private Integer id;
	private String name;
	private String code;
	private CuentasDto cuentas;
}

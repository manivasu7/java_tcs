package com.example.java_tcs.dto;


import com.example.java_tcs.model.Cuentas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentasDto {

	private Integer id;
	private String name;
	private String code;
	
	public Cuentas toEntity() {
		return new Cuentas(id,name,code);
	}
}


package com.bp.cuenta.dto;

import com.bp.cuenta.model.Cuenta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDto {
	private Integer id;
	private String numeroCuenta;
	private String saldo;
	
	public Cuenta toEntity() {
		return new Cuenta(id, numeroCuenta, saldo);
	}

}

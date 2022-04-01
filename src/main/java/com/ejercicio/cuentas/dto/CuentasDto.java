package com.ejercicio.cuentas.dto;

import com.ejercicio.cuentas.model.Cuentas;

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
	private String nombre_cliente;
	private String ciudad;
	private String ocupacion;
	
	public Cuentas toEntity() {
		return new Cuentas(id, nombre_cliente, ciudad, ocupacion);
	}
}

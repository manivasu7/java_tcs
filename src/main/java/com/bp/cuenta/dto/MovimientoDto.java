package com.bp.cuenta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoDto {

	private Integer id;
	private String descripcion;
	private String fecha;
	private CuentaDto cuenta;	

}

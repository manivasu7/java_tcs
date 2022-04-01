package com.ejercicio.cuentas.dto;

import java.sql.Date;

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
	private Date fecha_movimiento;
	private String tipo_movimiento;
	private Double valor_movimiento;
	private CuentasDto cuenta;
	
}

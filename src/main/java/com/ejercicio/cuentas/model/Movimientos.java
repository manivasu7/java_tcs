package com.ejercicio.cuentas.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ejercicio.cuentas.dto.CuentasDto;
import com.ejercicio.cuentas.dto.MovimientosDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimientos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fecha_movimiento;
	private String tipo_movimiento;
	private Double valor_movimiento;
	
	@ManyToOne
	private Cuentas cuenta;
	
	public MovimientosDto ToDto() {
		CuentasDto obj = null;
		if(cuenta != null)
		{
			obj=cuenta.ToDto();
		}
		return new MovimientosDto(id, fecha_movimiento,tipo_movimiento,valor_movimiento, obj);
	}
}

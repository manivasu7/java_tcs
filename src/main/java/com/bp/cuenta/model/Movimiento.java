package com.bp.cuenta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bp.cuenta.dto.CuentaDto;
import com.bp.cuenta.dto.MovimientoDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;
	private String fecha;
	
	@ManyToOne
	private Cuenta cuenta;
	
	public MovimientoDto ToDto() {
		CuentaDto cuentaObj = null;
		if(cuenta != null)
		{
			cuentaObj=cuenta.ToDto();
		}
		return new MovimientoDto(id,descripcion,fecha,cuentaObj);
	}
}

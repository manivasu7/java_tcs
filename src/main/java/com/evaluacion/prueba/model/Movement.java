package com.evaluacion.prueba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.evaluacion.prueba.dto.CuentaDto;
import com.evaluacion.prueba.dto.MovementDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dateMovement;
	private float value;
	
	@ManyToOne
	private Cuenta cuenta;
	
	public MovementDto ToDto() {
		CuentaDto obj = null;
		if(cuenta != null)
		{
			obj=cuenta.ToDto();
		}
		return new MovementDto();
	}
	;
}

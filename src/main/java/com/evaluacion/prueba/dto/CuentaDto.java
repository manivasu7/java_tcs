package com.evaluacion.prueba.dto;

import com.evaluacion.prueba.model.Cuenta;
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
	private Integer idCostumer;
	private String nameCostumer;
	private Float balance;
	
	public Cuenta toEntity() {
		return new Cuenta();
	}
}

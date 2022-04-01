package com.evaluacion.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementDto {

	private Integer id;
	private Integer idCostumer;
	private String nameCostumer;
	private Float balance;
}

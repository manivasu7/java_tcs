package com.ejercicio.accounts.demoaccounts.dto;

import java.util.Date;

import com.ejercicio.accounts.demoaccounts.model.Movement;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementDto {

	private long id;
	private String descriptionMovement;
	private String typeMovement;
	private double amount;
	private Date dateMovement;

	@JsonIgnore
	public Movement getAsEntity() {
		return new Movement(this.id, this.descriptionMovement, this.typeMovement, this.amount, this.dateMovement);
	}

}

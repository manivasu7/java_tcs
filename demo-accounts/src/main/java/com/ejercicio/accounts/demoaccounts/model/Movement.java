package com.ejercicio.accounts.demoaccounts.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ejercicio.accounts.demoaccounts.dto.MovementDto;

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
	private long id;
	private String descriptionMovement;
	private String typeMovement;
	private double amount;
	private Date dateMovement;

	public MovementDto getAsTo() {
		return new MovementDto(this.id, this.descriptionMovement, this.descriptionMovement, this.amount,
				this.dateMovement);
	}

}

package com.pichincha.exam.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.validation.constraints.NotBlank;

import com.pichincha.exam.model.Account;
import com.pichincha.exam.model.Movement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovementDto {

	private Long movementId;
	@NotBlank(message = "Movement description is mandatory")
	private String description;
	@NotBlank(message = "Journal is mandatory")
	private String journal;
	@NotBlank(message = "Amount is mandatory")
	private String amount;
	@NotBlank(message = "Movent type is mandatory. Debit or Credit")
	private String movementType;
	@NotBlank(message = "Account information is required")
	private AccountDto account;
	
	public Movement toEntity() {
		Account account = null;
		if(this.account != null) {
			account = this.account.toEntity();
		}
		BigDecimal modelVal = new BigDecimal(amount);
		BigDecimal displayVal = modelVal.setScale(2, RoundingMode.HALF_EVEN);
		return new Movement(movementId,description,journal, displayVal,movementType, account);
	}

	
}

package com.pichincha.exam.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.pichincha.exam.model.Account;
import com.pichincha.exam.model.Movement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

	private Long acountId;
	@NotBlank(message = "Account number is mandatory")
	private String accountNumber;
	@NotBlank(message = "Account type is mandatory")
	private String accountType;
	private String totalAmount;
	@NotBlank(message = "Account currency is mandatory")
	private String currency;
	
	private List<MovementDto> movements;
	
	
	public void setCurrency(Currency currency) {
	    this.currency = currency.getCurrencyCode(); 
	}

	public Currency getCurrency() {
	    return Currency.getInstance(currency); 
	}

	public Account toEntity() {
		List<Movement> movements = null;
		if(this.movements!=null) {
			movements = this.movements.stream().map(m -> m.toEntity()).collect(Collectors.toList());
		}
		BigDecimal modelVal = new BigDecimal(totalAmount);
		BigDecimal displayVal = modelVal.setScale(2, RoundingMode.HALF_EVEN);
		return new Account(acountId,accountNumber,accountType,displayVal,currency,movements);
	}
}

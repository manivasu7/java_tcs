package com.pichincha.exam.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pichincha.exam.dto.AccountDto;
import com.pichincha.exam.dto.MovementDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movementId;
	private String description;
	private String journal;
	private BigDecimal amount;
	private String movementType;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	public MovementDto toDto() {
		NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
		usdCostFormat.setMinimumFractionDigits(2);
		usdCostFormat.setMaximumFractionDigits(2);
		AccountDto account = null;
		if (this.account != null) {
			account = this.account.toDto();
			usdCostFormat.setCurrency(account.getCurrency());
		}
		
		
		
		return new MovementDto(movementId, description, journal, usdCostFormat.format(amount.doubleValue()),
				movementType, account);
	}

}

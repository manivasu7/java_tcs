package com.pichincha.exam.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.pichincha.exam.dto.AccountDto;
import com.pichincha.exam.dto.MovementDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name ="account", uniqueConstraints = {@UniqueConstraint(columnNames = {"accountNumber"})})
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long acountId;
	private String accountNumber;
	private String accountType;
	private BigDecimal totalAmount;
	@Embedded
	private String currency;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Movement> movements;
	
	
	public void setCurrency(Currency currency) {
	    this.currency = currency.getCurrencyCode(); 
	}

	public Currency getCurrency() {
	    return Currency.getInstance(currency); 
	}
	
	public AccountDto toDto() {
		List<MovementDto> movements = null;
		if(this.movements!=null) {
			movements = this.movements.stream().map(m -> m.toDto()).collect(Collectors.toList());
		}
		NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
		usdCostFormat.setMinimumFractionDigits( 2 );
		usdCostFormat.setMaximumFractionDigits( 2 );
		usdCostFormat.setCurrency(Currency.getInstance(currency));
		return new AccountDto(acountId,accountNumber,accountType,usdCostFormat.format(totalAmount.doubleValue()),currency,movements);
	}
}

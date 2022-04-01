package com.ejercicio.accounts.demoaccounts.dto;

import java.util.ArrayList;
import java.util.List;

import com.ejercicio.accounts.demoaccounts.model.Account;
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
public class AccountDto {

	private long id;
	private String name;
	private String numberAccount;
	private String typeAccount;
	private String typeInteres;
	private double balance;
	private List<Movement> listMovements = new ArrayList<>();

	@JsonIgnore
	public Account getAsEntity() {
		return new Account(this.id, this.name, this.numberAccount, this.typeAccount, this.typeInteres, this.balance,
				this.listMovements);
	}

}

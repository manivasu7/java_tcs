package com.ejercicio.accounts.demoaccounts.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.ejercicio.accounts.demoaccounts.dto.AccountDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String numberAccount;
	private String typeAccount;
	private String typeInteres;
	private double balance;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountMovement", referencedColumnName = "id", nullable = false)
	private List<Movement> listMovements = new ArrayList<>();

	public AccountDto getAsTo() {
		return new AccountDto(this.id, this.name, this.numberAccount, this.typeAccount, this.typeInteres, this.balance,
				this.listMovements);
	}

}

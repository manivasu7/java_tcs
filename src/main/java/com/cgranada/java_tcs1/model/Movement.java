package com.cgranada.java_tcs1.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.cgranada.java_tcs1.dto.AccountDto;
import com.cgranada.java_tcs1.dto.MovementDto;

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
	private Integer id;
	private String dateIniOp;
	private Integer mount;
	
	@ManyToOne
	private Account account;
	
	public MovementDto ToDto() {
		AccountDto accountDto = null;
		if(account != null)
		{
			accountDto=account.ToDto();
		}
		return new MovementDto(id,dateIniOp,mount,accountDto);
				
	}
	
}

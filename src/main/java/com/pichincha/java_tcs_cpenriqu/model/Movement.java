package com.pichincha.java_tcs_cpenriqu.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.pichincha.java_tcs_cpenriqu.dto.AccountDto;
import com.pichincha.java_tcs_cpenriqu.dto.MovementDto;

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
	private String name;
	private String code;
	
	@ManyToOne
	private Account account;
	
	
	public MovementDto ToDto() {
		AccountDto obj = null;
		if(account != null)
		{
			obj=account.ToDto();
		}
		return new MovementDto(id,name,code,obj);
	}
	
}
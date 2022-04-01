package com.example.java_tcs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.java_tcs.dto.CuentasDto;
import com.example.java_tcs.dto.MovimientosDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimientos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String code;
	
	@ManyToOne
	private Cuentas cuentas;
	
	
	public MovimientosDto ToDto() {
		CuentasDto obj = null;
		if(cuentas != null)
		{
			obj=cuentas.ToDto();
		}
		return new MovimientosDto(id,name,code,obj);
	}
}

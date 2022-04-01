package com.vsosapac.java_tcs1.service;

import java.util.List;
import java.util.Optional;

import com.vsosapac.java_tcs1.entity.model.Cuenta;
import com.vsosapac.java_tcs1.entity.model.Movimiento;

public interface IMovimientoService {

	public Iterable<Movimiento> FindAll();

	public Optional<Movimiento> FindById(Long Id);

	public Movimiento Save(Movimiento movimiento);

	public void DeleteById(Long Id);
	
	public List<Movimiento> FindByCuenta(int cuentaId);

}

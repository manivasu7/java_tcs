package com.ejercicio.cuentas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.cuentas.model.Movimientos;
import com.ejercicio.cuentas.repository.MovimientosRepo;

@Service
public class MovimientosService {
	@Autowired
	private MovimientosRepo movimientoRepo;
	
	public List<Movimientos> getMovimientos()
	{
		return movimientoRepo.findAll();
	}
	
	public Movimientos save(Movimientos movimiento) {

		return movimientoRepo.save(movimiento);
	}
	
	public void delete(int id)
	{
		movimientoRepo.deleteById(id);
	}

	//updating a record
	public void update(Movimientos movimiento, int id)
	{
		movimientoRepo.save(movimiento);
	}

	public Optional<Movimientos> findById(Integer id) {				
		
		return movimientoRepo.findById(id);
	}

}

package com.bp.cuenta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.cuenta.model.Movimiento;
import com.bp.cuenta.repository.MovimientoRepo;

@Service
public class MovimientoService {
	@Autowired
	private MovimientoRepo movimientoRepo;
	
	public List<Movimiento> getMovimientos(){
		return movimientoRepo.findAll();
	}
	
	public Movimiento save(Movimiento movimiento) {
		return movimientoRepo.save(movimiento);	
	}
	
	public void delete (int id) {
		movimientoRepo.deleteById(id);
	}
	
	public void update (Movimiento movimiento, int id) {
		movimientoRepo.save(movimiento);
	}
	
	public Optional <Movimiento> findById(Integer id){
		return movimientoRepo.findById(id);
	}
	
}

package com.rrmejiap.java_tcs1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrmejiap.java_tcs1.model.Movimientos;
import com.rrmejiap.java_tcs1.repositiry.MovimientosRepo;

@Service
public class MovimientosService {
	@Autowired
	private MovimientosRepo movimientosRepo;

	public List<Movimientos> getMovimientos() {
		return movimientosRepo.findAll();
	}

	public Movimientos saveContry(Movimientos movimientos) {
		// TODO Auto-generated method stub
		return movimientosRepo.save(movimientos);
	}

	public void delete(int id) {
		movimientosRepo.deleteById(id);
	}

	// updating a record
	public void update(Movimientos movimientos, int id) {
		movimientosRepo.save(movimientos);
	}

	public Optional<Movimientos> findById(Integer id) {
		// TODO Auto-generated method stub
		return movimientosRepo.findById(id);
	}

}

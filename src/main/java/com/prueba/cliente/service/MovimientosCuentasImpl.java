package com.prueba.cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.cliente.exception.NoResourceException;
import com.prueba.cliente.model.MovimientoDeCuentasDeClientes;
import com.prueba.cliente.repository.IMovimientosCuentasClientes;

@Service
public class MovimientosCuentasImpl implements IMovimientosCuentasService {
	
	@Autowired
	IMovimientosCuentasClientes movimientosCuentasClientesRepository;

	@Override
	public List<MovimientoDeCuentasDeClientes> getAllMovimientos() {
		List<MovimientoDeCuentasDeClientes> movimientos = movimientosCuentasClientesRepository.findAll();
		return movimientos;
	}

	@Override
	public MovimientoDeCuentasDeClientes createMovimiento(MovimientoDeCuentasDeClientes movimiento) {
		return movimientosCuentasClientesRepository.save(movimiento);
	}

	@Override
	public MovimientoDeCuentasDeClientes updateMovimiento(Long id, MovimientoDeCuentasDeClientes movimiento)
			throws NoResourceException {

		Optional<MovimientoDeCuentasDeClientes> movimientoBusqueda = movimientosCuentasClientesRepository.findById(id);
        if (movimientoBusqueda.isPresent()) {
            return movimientosCuentasClientesRepository.save(movimiento);
        }
        else {
            throw  new NoResourceException("No existe el movimiento con id : "+id);
        }
        
	}

	@Override
	public void deleteMovimiento(Long id) throws NoResourceException {

		Optional<MovimientoDeCuentasDeClientes> movimientoBusqueda = movimientosCuentasClientesRepository.findById(id);
		if(movimientoBusqueda.isPresent()){
			movimientosCuentasClientesRepository.delete(movimientoBusqueda.get());
        }else{
            throw  new NoResourceException("No existe el movimiento con id : "+id);
        }
	}
	
	
	
}

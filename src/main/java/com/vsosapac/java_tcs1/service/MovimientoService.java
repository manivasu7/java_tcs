package com.vsosapac.java_tcs1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsosapac.java_tcs1.entity.model.Movimiento;
import com.vsosapac.java_tcs1.repository.ICuentaRepository;
import com.vsosapac.java_tcs1.repository.IMovimientoRepository;

@Service
public class MovimientoService implements IMovimientoService {

	@Autowired
	private IMovimientoRepository iMovimientoRepository;
	
	@Autowired
	private ICuentaRepository iCuentaRepository;
	
	@Override
	public Iterable<Movimiento> FindAll() {
		return iMovimientoRepository.findAll();
	}

	@Override
	public Optional<Movimiento> FindById(Long Id) {
		return iMovimientoRepository.findById(Id);
	}

	@Override
	public Movimiento Save(Movimiento movimiento) {
		return iMovimientoRepository.save(movimiento);
	}

	@Override
	public void DeleteById(Long Id) {
		iMovimientoRepository.deleteById(Id);

	}

	@Override
	public List<Movimiento> FindByCuenta(int cuentaId) {
	    
		 var resultado = iMovimientoRepository.findAll();
		 
		 List<Movimiento> movimientoFiltrado = new ArrayList<Movimiento>();
		 
		 for (Movimiento movimiento : resultado) {
			if (movimiento.getCuenta().getId() == cuentaId ) {
				
				movimientoFiltrado.add(movimiento);
			}
		}
		 
		 return  movimientoFiltrado;
	}

}

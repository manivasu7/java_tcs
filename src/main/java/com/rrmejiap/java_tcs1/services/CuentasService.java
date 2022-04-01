package com.rrmejiap.java_tcs1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrmejiap.java_tcs1.model.Cuentas;
import com.rrmejiap.java_tcs1.repositiry.CuentasRepo;

@Service
public class CuentasService {
	@Autowired
	private CuentasRepo cuentasRepo;

	public List<Cuentas> getCuentas() {
		return cuentasRepo.findAll();
	}

	public Cuentas saveContry(Cuentas cuentas) {
		// TODO Auto-generated method stub
		return cuentasRepo.save(cuentas);
	}

	public void delete(int id) {
		cuentasRepo.deleteById(id);
	}

	// updating a record
	public void update(Cuentas cuentas, int id) {
		cuentasRepo.save(cuentas);
	}

	public Optional<Cuentas> findById(Integer id) {
		// TODO Auto-generated method stub
		return cuentasRepo.findById(id);
	}

}

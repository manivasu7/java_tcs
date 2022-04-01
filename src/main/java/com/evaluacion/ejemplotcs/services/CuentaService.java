package com.evaluacion.ejemplotcs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.ejemplotcs.model.Cuenta;
import com.evaluacion.ejemplotcs.repository.CuentaRepo;

//defining the business logic  
@Service 
public class CuentaService {
	@Autowired  
	CuentaRepo cuentaRepo;  
	//getting all books record by using the method findaAll() of CrudRepository  
	public List<Cuenta> getAllCuenta()   
	{  
	List<Cuenta> cuenta = new ArrayList<Cuenta>();  
	cuentaRepo.findAll().forEach(cuenta1 -> cuenta.add(cuenta1));  
	return cuenta;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Cuenta getCuentaById(int id)   
	{  
	return cuentaRepo.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Cuenta cuenta)   
	{  
		cuentaRepo.save(cuenta);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		cuentaRepo.deleteById(id);  
	}  
	//updating a record  
	public void update(Cuenta cuenta, int id)   
	{  
		cuentaRepo.save(cuenta);  
	} 
}

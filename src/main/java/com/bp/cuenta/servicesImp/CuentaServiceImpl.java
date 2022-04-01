package com.bp.cuenta.servicesImp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.cuenta.dto.CuentaDto;
import com.bp.cuenta.model.Cuenta;
import com.bp.cuenta.repository.CuentaRepo;
import com.bp.cuenta.services.CuentaService;
import com.bp.cuenta.services.exception.ResourceNotFoundException;

@Service
public class CuentaServiceImpl implements CuentaService{
	@Autowired
	private CuentaRepo cuentaRepo;
	
	public List<CuentaDto> getCuenta(){
		List<Cuenta> listCuenta = cuentaRepo.findAll();
		return listCuenta.stream().map(c -> c.ToDto()).collect(Collectors.toList());
	}
		
	public CuentaDto update (CuentaDto cuenta, int id) throws ResourceNotFoundException{
		Optional<CuentaDto> cuentaData = findCuenta(id);
		if(cuentaData.isPresent()) {
			Cuenta objCuenta = cuentaData.get().toEntity();
			objCuenta.setNumeroCuenta(cuenta.getNumeroCuenta());
			objCuenta.setSaldo(cuenta.getSaldo());
			return cuentaRepo.save(objCuenta).ToDto();
			
		}else {
			throw new ResourceNotFoundException("Cuenta no existe");
		}
	}

	public CuentaDto saveCuenta(CuentaDto cuenta) {
		return cuentaRepo.save(cuenta.toEntity()).ToDto();
	}
	
	public void deleteCuenta (int id) throws ResourceNotFoundException{
		Optional<CuentaDto> cuentaData = findCuenta(id);
		if(cuentaData.isPresent()) {
			cuentaRepo.deleteById(id);
		}else {
			throw new ResourceNotFoundException("Cuenta no existe");
		}
	}
	
	public Optional<CuentaDto> findCuenta(Integer id){
		Optional<Cuenta> objCuenta = cuentaRepo.findById(id);
		Optional<CuentaDto> objCuentaDto;
		if(objCuenta.isPresent()) {
			objCuentaDto = Optional.of(objCuenta.get().ToDto());
		}else
		{
			objCuentaDto = Optional.empty();
		}
		return objCuentaDto;
	}
}

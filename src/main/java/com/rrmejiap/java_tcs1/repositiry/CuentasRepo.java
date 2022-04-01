package com.rrmejiap.java_tcs1.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrmejiap.java_tcs1.model.Cuentas;

@Repository
public interface CuentasRepo extends JpaRepository<Cuentas, Integer> {
	

}

package com.rrmejiap.java_tcs1.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrmejiap.java_tcs1.model.Movimientos;

@Repository
public interface MovimientosRepo extends JpaRepository<Movimientos, Integer> {

}

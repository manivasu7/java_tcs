package com.ejercicio.contabilidad.repository;

import com.ejercicio.contabilidad.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Accounts, Integer> {
}

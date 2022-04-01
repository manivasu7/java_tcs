package com.pichincha.cuenta.java_tcs.repository;

import com.pichincha.cuenta.java_tcs.entity.Movement;
import org.springframework.data.repository.CrudRepository;

public interface IMovementRepository extends CrudRepository<Movement, Integer> {
}

package com.eddu.java_tcs1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eddu.java_tcs1.model.Movement;

@Repository
public interface MovementRepository extends  JpaRepository<Movement , Integer> {

}

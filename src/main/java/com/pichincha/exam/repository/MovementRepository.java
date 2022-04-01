package com.pichincha.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pichincha.exam.model.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
	@Query(value = "SELECT m.* FROM MOVEMENT m  , ACCOUNT a where  m.ACCOUNT_ID =  a.ACOUNT_ID and account_number = :account_number",
	            nativeQuery = true)
	List<Movement> findByAccountNumber(@Param("account_number") String accountNumber);

}

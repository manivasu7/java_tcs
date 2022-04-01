package com.pichincha.bcb.gestiondecuentes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pichincha.bcb.gestiondecuentes.entity.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer>{
	
	List<AccountEntity> findAllByAccountNumber(String accountNumber);

}

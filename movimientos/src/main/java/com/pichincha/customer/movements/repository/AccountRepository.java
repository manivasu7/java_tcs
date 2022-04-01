/**
 * 
 */
package com.pichincha.customer.movements.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.customer.movements.entity.AccountEntity;


/**
 * @author jjoseph
 *
 */
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	  List<AccountEntity> findByStatus(Boolean status);
	  List<AccountEntity> findByAccountNumber(String accountNumber);
}

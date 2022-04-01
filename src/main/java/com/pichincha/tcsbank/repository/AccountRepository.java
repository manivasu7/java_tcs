package com.pichincha.tcsbank.repository;

import com.pichincha.tcsbank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}

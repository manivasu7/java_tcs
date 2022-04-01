package com.pichincha.service;

import com.pichincha.service.model.Account;
import com.pichincha.service.model.Movements;
import com.pichincha.service.repository.AccountRepository;
import com.pichincha.service.repository.MovementsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run (AccountRepository accountRepository){
		return args -> {
			accountRepository.save(new Account(null,"00000001","CC","Mario","Almeida" ,200.00));
			accountRepository.save(new Account(null,"00000001","CC","Dylan","Almeida" ,1200.00));
		};
	}

}

package com.pichincha.backend.practica.repository;

import com.pichincha.backend.practica.dto.AcountDto;
import com.pichincha.backend.practica.model.Acount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcountRepository extends JpaRepository<AcountDto,Long> {
}

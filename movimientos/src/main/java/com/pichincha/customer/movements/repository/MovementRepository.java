/**
 * 
 */
package com.pichincha.customer.movements.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.customer.movements.entity.MovementEntity;

/**
 * @author Onqui
 *
 */
public interface MovementRepository  extends JpaRepository<MovementEntity, Long>{

}

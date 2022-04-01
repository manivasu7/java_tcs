package com.cgranada.java_tcs1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgranada.java_tcs1.model.Movement;
import com.cgranada.java_tcs1.service.MovementService;

@RestController
@RequestMapping("/api/v1/movement")
public class MovementController {
	@Autowired
	private MovementService movementService;
	
	@GetMapping()
	public List<Movement> getMovements() {
		return movementService.getmMovements();
	}
	
	@PostMapping()
	public ResponseEntity<?> postMovement(@RequestBody Movement movement) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movementService.save(movement));
	}
	
	@DeleteMapping("/{movemetid}")
	private void deleteMovement(@PathVariable("movementid") int id)
	{
		movementService.delete(id);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Movement> updateMovement(@PathVariable("id") Integer id, @RequestBody Movement movement) {
	 Optional<Movement> tutorialData = movementService.findById(id);
	 if (tutorialData.isPresent()) {
	  Movement _movement = tutorialData.get();
	  _movement.setDateIniOp(movement.getDateIniOp());
	  _movement.setMount(movement.getMount());
	  return new ResponseEntity<>(movementService.save(_movement), HttpStatus.OK);
	 } else {
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	}
	
}

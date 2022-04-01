package com.mayank.examproj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mayank.examproj.dto.MovementDto;

@Entity
public class Movement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	public long origin;
	public long destino;
	public float value;

	public MovementDto getAsTo() {
		return new MovementDto(this.id, this.origin, this.destino, this.value);
	}

	public Movement() {
	}

	public Movement(long id, long origin, long destino, float value) {
		super();
		this.id = id;
		this.origin = origin;
		this.destino = destino;
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrigin() {
		return origin;
	}

	public void setOrigin(long origin) {
		this.origin = origin;
	}

	public long getDestino() {
		return destino;
	}

	public void setDestino(long destino) {
		this.destino = destino;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}

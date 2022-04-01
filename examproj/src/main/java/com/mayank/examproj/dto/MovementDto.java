package com.mayank.examproj.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mayank.examproj.model.Movement;

public class MovementDto {

	public long id;
	public long origin;
	public long destino;
	public float value;

	@JsonIgnore
	public Movement getAsEntity() {
		return new Movement(this.id, this.origin, this.destino, this.value);
	}

	public MovementDto() {
	}

	public MovementDto(long id, long origin, long destino, float value) {
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

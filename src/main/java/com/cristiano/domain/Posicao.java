package com.cristiano.domain;

import com.cristiano.exception.InvalidPositionException;



public class Posicao {

	private final int x;
	private final int y;

	private Posicao(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Posicao fixPosition(int x, int y){
		return new Posicao(x, y);
	}

	public Posicao moveForwardTo(Direction direcao, Malha malha) {
		Posicao newPosition = direcao.move(this);
		if(!malha.contains(newPosition)){
			throw new InvalidPositionException("Posição não existe na malha.");
		}
		return newPosition;
	}

	public boolean isValidPosition(Malha malha) {
		return malha.contains(this);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicao other = (Posicao) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

package com.cristiano.domain;


public abstract class CorpoEspacial {

	protected Posicao posicao;
	protected Direction direction;
	protected Malha malha;
	
	protected CorpoEspacial(Malha malha, Posicao posicao, Direction direction) {
		this.malha = malha;
		this.posicao = posicao;
		this.direction = direction;
	}
	
	public void move() {
		posicao = posicao.moveForwardTo(direction, malha);
	}
	
	public void turnLeft() {
		direction = getLeftDirection();
	}

	public void turnRight() {
		direction = getRightDirection();
	}
	
	/**
	 * Retorna a direção a direita que a sonta esta apontada
	 *
	 * @return
	 */
	public Direction getLeftDirection() {
		return direction.getLeft();
	}

	/**
	 * Retorna a direção a esquerda que a sonta esta apontada
	 *
	 * @return
	 */
	public Direction getRightDirection() {
		return direction.getRight();
	}
	
	public Direction getDirection() {
		return direction;
	}

	public Posicao getPosicao() {
		return posicao;
	}
	
	public boolean isAt(Posicao posicao){
		return posicao.equals(this.posicao);
	}
}

package com.cristiano.domain;

public final class Sonda {

	private final int horizontal;
	private final int vertical;
	private final Direction direction;
	private final Malha malha;

	private Sonda(Malha malha, int horizontal, int vertical, Direction direction) {
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.direction = direction;
		this.malha = malha;
	}

	/**
	 * Aterriza a {@link Sonda} na posição especificada
	 * 
	 * @param horizontal
	 * @param vertical
	 * @param apontadaPara
	 * @return {@link Sonda}
	 */
	public static Sonda land(Malha malha, int horizontal, int vertical, Direction apontadaPara) {
		return new Sonda(malha, horizontal, vertical, apontadaPara);
	}

	/**
	 * Retorna a direção a direita que a sonta esta apontada
	 * 
	 * @return
	 */
	public Direction getLeftDirection() {
		return direction.getLeft(this);
	}

	/**
	 * Retorna a direção a esquerda que a sonta esta apontada
	 * 
	 * @return
	 */
	public Direction getRightDirection() {
		return direction.getRight(this);
	}

	/**
	 * Retorna um sonta com a nova direção
	 * 
	 * @param {@link
	 * 			Direction}
	 * @return {@link Sonda}
	 */
	public Sonda changeDirection(Direction direction) {
		return new Sonda(malha, horizontal, vertical, direction);
	}

	/**
	 * Movimenta para a unidade a frente que a sonda esta apontada
	 * 
	 * @return {@link Sonda}
	 */
	public Sonda move() {
		return direction.move(this);
	}

	/**
	 * Retorna uma nova sonda com a posição especifica.
	 * 
	 * @param horizontal
	 * @param vertical
	 * @return {@link Sonda}
	 */
	public Sonda moveTo(int horizontal, int vertical) {
		return new Sonda(malha, horizontal, vertical, direction);
	}

	public int getMalhaHorizontalSize() {
		return malha.getHorizontal();
	}
	
	public int getMalhaVerticalSize(){
		return malha.getVertical();
	}

	public int getHorizontal() {
		return horizontal;
	}

	public int getVertical() {
		return vertical;
	}

	public Direction getDirection() {
		return direction;
	}

}

package com.cristiano.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cristiano.exception.InvalidPositionException;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public final class Sonda {

	@XmlElement
	private final int horizontal;
	
	@XmlElement
	private final int vertical;
	
	@XmlElement
	private final Direction direction;
	private final Malha malha;

	private Sonda(Malha malha, int horizontal, int vertical, Direction direction) {
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.direction = direction;
		this.malha = malha;
	}

	/**
	 * Aterriza a {@link Sonda} na posiÃ§Ã£o especificada
	 * 
	 * @param horizontal
	 * @param vertical
	 * @param apontadaPara
	 * @return {@link Sonda}
	 */
	public static Sonda land(Malha malha, int horizontal, int vertical, Direction apontadaPara) {
		isValidPosition(malha, horizontal, vertical);
		return new Sonda(malha, horizontal, vertical, apontadaPara);
	}

	/**
	 * Retorna a direÃ§Ã£o a direita que a sonta esta apontada
	 * 
	 * @return
	 */
	public Direction getLeftDirection() {
		return direction.getLeft(this);
	}

	/**
	 * Retorna a direÃ§Ã£o a esquerda que a sonta esta apontada
	 * 
	 * @return
	 */
	public Direction getRightDirection() {
		return direction.getRight(this);
	}

	/**
	 * Retorna um sonta com a nova direÃ§Ã£o
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
	 * Retorna uma nova sonda com a posiÃ§Ã£o especifica.
	 * 
	 * @param horizontal
	 * @param vertical
	 * @return {@link Sonda}
	 */
	public Sonda moveTo(int horizontal, int vertical) {
		isValidPosition(malha, horizontal, vertical);
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
	
	private static void isValidPosition(Malha malha, int posH, int posV){
		if(posH > malha.getHorizontal() || posH < 0){
			throw new InvalidPositionException("Não existe na malha a posição HORIZONTAL: " + posH);
		}
		if(posV > malha.getVertical() || posV < 0){
			throw new InvalidPositionException("Não existe na malha a posição HORIZONTAL: " + posV);
		}
	}

}

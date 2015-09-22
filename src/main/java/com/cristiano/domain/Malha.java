package com.cristiano.domain;

public final class Malha {

	private Posicao topRight;
	private Posicao bottomLeft;

	private Malha(Posicao topRight) {
		this.topRight = topRight;
		this.bottomLeft = Posicao.fixPosition(0, 0);
	}

	public boolean contains(Posicao outra) {
		if ((outra.getX() <= topRight.getX() && outra.getY() <= topRight.getY()) && (outra.getX() >= bottomLeft.getX() && outra.getY() >= bottomLeft.getY())) {
			return true;
		}
		return false;
	}

	public static Malha build(Posicao topRight) {
		return new Malha(topRight);
	}
	
	public Posicao getTopRight() {
		return topRight;
	}
	
	public Posicao getBottomLeft() {
		return bottomLeft;
	}
}

package com.cristiano.domain;

public final class Malha {

	private final int horizontal;
	private final int vertical;

	private Malha(int horizontal, int vertical) {
		this.horizontal = horizontal;
		this.vertical = vertical;
	}

	public static Malha build(int horizontal, int vertical) {
		return new Malha(horizontal, vertical);
	}

	public int getHorizontal() {
		return horizontal;
	}

	public int getVertical() {
		return vertical;
	}

}

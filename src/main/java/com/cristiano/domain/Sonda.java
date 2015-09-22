package com.cristiano.domain;


public final class Sonda extends CorpoEspacial {

	private Sonda(Malha malha, Posicao posicao, Direction direction) {
		super(malha, posicao, direction);
	}

	/**
	 * Aterriza a {@link Sonda} na posição especificada
	 *
	 * @param horizontal
	 * @param vertical
	 * @param apontadaPara
	 * @return {@link Sonda}
	 */
	public static Sonda land(Malha malha, Posicao posicao, Direction apontadaPara) {
		return new Sonda(malha, posicao, apontadaPara);
	}

	

}

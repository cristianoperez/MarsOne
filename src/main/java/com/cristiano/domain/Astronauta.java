package com.cristiano.domain;


public final class Astronauta extends CorpoEspacial{

	private Astronauta(Malha malha, Posicao posicao, Direction direction) {
		super(malha, posicao, direction);
	}
	
	public static Astronauta land(Malha malha, Posicao posicao, Direction apontadaPara) {
		return new Astronauta(malha, posicao, apontadaPara);
	}
	
}

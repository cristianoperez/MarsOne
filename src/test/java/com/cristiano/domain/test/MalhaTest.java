package com.cristiano.domain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cristiano.domain.Malha;
import com.cristiano.domain.Posicao;

public class MalhaTest {
	private final int X = 10;
	private final int Y = 10;
	private final Posicao posicao = Posicao.fixPosition(X, Y);

	@Test
	public void buildMalha() {
		Malha malha = Malha.build(posicao);
		assertEquals(X, malha.getTopRight().getX());
		assertEquals(Y, malha.getTopRight().getY());
		assertEquals(0, malha.getBottomLeft().getX());
		assertEquals(0, malha.getBottomLeft().getX());
	}
	
	@Test
	public void malhaContainsPositionTopRight() {
		Malha malha = Malha.build(posicao);
		assertTrue(malha.contains(posicao));
	}
	
	@Test
	public void malhaContainsPositionBottomLeft() {
		Posicao pos = Posicao.fixPosition(0, 0);
		Malha malha = Malha.build(pos);
		assertTrue(malha.contains(pos));
	}
	
	@Test
	public void malhaDontContainsPosition() {
		Malha malha = Malha.build(posicao);
		Posicao pos = Posicao.fixPosition(100, 100);
		assertFalse(malha.contains(pos));
	}
}

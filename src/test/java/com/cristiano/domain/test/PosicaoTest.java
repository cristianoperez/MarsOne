package com.cristiano.domain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cristiano.domain.Direction;
import com.cristiano.domain.Malha;
import com.cristiano.domain.Posicao;
import com.cristiano.exception.InvalidPositionException;

public class PosicaoTest {

	private final int X = 10;
	private final int Y = 10;
	private Malha malha;

	@Test
	public void fixPosition(){
		Posicao posicao = Posicao.fixPosition(X, Y);
		
		assertEquals(X, posicao.getX());
		assertEquals(Y, posicao.getY());
	}
	
	@Test(expected = InvalidPositionException.class)
	public void moveEToInvalidPosition() {
		Posicao topRight = Posicao.fixPosition(X, Y);
		malha = Malha.build(topRight);

		topRight.moveForwardTo(Direction.E, malha);
	}

	@Test(expected = InvalidPositionException.class)
	public void moveNToInvalidPosition() {
		Posicao topRight = Posicao.fixPosition(X, Y);
		malha = Malha.build(topRight);

		topRight.moveForwardTo(Direction.N, malha);
	}

	@Test(expected = InvalidPositionException.class)
	public void moveWToInvalidPosition() {
		Posicao topRight = Posicao.fixPosition(0, 0);
		malha = Malha.build(topRight);

		topRight.moveForwardTo(Direction.W, malha);
	}

	@Test(expected = InvalidPositionException.class)
	public void moveSToInvalidPosition() {
		Posicao topRight = Posicao.fixPosition(0, 0);
		malha = Malha.build(topRight);

		topRight.moveForwardTo(Direction.S, malha);
	}

	@Test
	public void moveNtoValidPosition() {
		Posicao topRight = Posicao.fixPosition(X, Y);
		malha = Malha.build(topRight);
		
		Posicao pos = Posicao.fixPosition(X, 7);
		Posicao newPosition = pos.moveForwardTo(Direction.N, malha);
		
		assertEquals(8, newPosition.getY());
		assertEquals(10, newPosition.getX());
	}
	@Test
	public void moveStoValidPosition() {
		Posicao topRight = Posicao.fixPosition(X, Y);
		malha = Malha.build(topRight);
		
		Posicao newPosition = topRight.moveForwardTo(Direction.S, malha);
		
		assertEquals(9, newPosition.getY());
		assertEquals(10, newPosition.getX());
	}

	@Test
	public void moveEtoValidPosition() {
		Posicao topRight = Posicao.fixPosition(X, Y);
		malha = Malha.build(topRight);
		
		Posicao pos = Posicao.fixPosition(9, Y);
		Posicao newPosition = pos.moveForwardTo(Direction.E, malha);
		
		assertEquals(10, newPosition.getY());
		assertEquals(10, newPosition.getX());
	}

	@Test
	public void moveWtoValidPosition() {
		Posicao topRight = Posicao.fixPosition(X, Y);
		malha = Malha.build(topRight);
		
		Posicao newPosition = topRight.moveForwardTo(Direction.W, malha);
		
		assertEquals(10, newPosition.getY());
		assertEquals(9, newPosition.getX());
	}
	
	@Test
	public void isValidPosition() {
		Posicao topRight = Posicao.fixPosition(X, Y);
		malha = Malha.build(topRight);
		
		assertTrue(topRight.isValidPosition(malha));
	}

	@Test
	public void isInvalidPosition() {
		Posicao topRight = Posicao.fixPosition(X, Y);
		malha = Malha.build(topRight);
		
		Posicao pos = Posicao.fixPosition(100, Y);
		
		assertFalse(pos.isValidPosition(malha));
	}
}

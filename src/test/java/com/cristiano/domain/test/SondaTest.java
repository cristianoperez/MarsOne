package com.cristiano.domain.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cristiano.domain.Direction;
import com.cristiano.domain.InvalidPositionException;
import com.cristiano.domain.Malha;
import com.cristiano.domain.Sonda;

public class SondaTest {

	private Sonda sonda;
	private Malha malha;
	private final int H = 10;
	private final int V = 10;
	private final Direction DIR = Direction.E;

	@Before
	public void init() {
		malha = Malha.build(V, H);
		sonda = Sonda.land(malha, H, V, DIR);
	}

	@Test
	public void buildMalha() {
		assertEquals(H, malha.getHorizontal());
		assertEquals(V, malha.getVertical());
	}

	@Test
	public void aterrizarSonda() {
		assertEquals(H, sonda.getHorizontal());
		assertEquals(V, sonda.getVertical());
		assertEquals(DIR, sonda.getDirection());
	}

	public void invalidLandPosition() {

	}

	@Test(expected = InvalidPositionException.class)
	public void moveEToInvalidPosition() {
		Sonda sonda = Sonda.land(malha, H, V, Direction.E);
		sonda.move(malha);
	}

	@Test(expected = InvalidPositionException.class)
	public void moveNToInvalidPosition() {
		Sonda sonda = Sonda.land(malha, H, V, Direction.N);
		sonda.move(malha);
	}

	@Test(expected = InvalidPositionException.class)
	public void moveWToInvalidPosition() {
		Sonda sonda = Sonda.land(malha, 0, 0, Direction.W);
		sonda.move(malha);
	}

	@Test(expected = InvalidPositionException.class)
	public void moveSToInvalidPosition() {
		Sonda sonda = Sonda.land(malha, 0, 0, Direction.S);
		sonda.move(malha);
	}

	@Test
	public void moveNtoValidPosition() {
		Sonda sonda = Sonda.land(malha, H, 9, Direction.N);
		sonda = sonda.move(malha);

		assertEquals(10, sonda.getVertical());
	}

	@Test
	public void moveStoValidPosition() {
		Sonda sonda = Sonda.land(malha, H, V, Direction.S);
		sonda = sonda.move(malha);

		assertEquals(9, sonda.getVertical());
	}

	@Test
	public void moveEtoValidPosition() {
		Sonda sonda = Sonda.land(malha, 9, V, Direction.E);
		sonda = sonda.move(malha);

		assertEquals(10, sonda.getHorizontal());
	}

	@Test
	public void moveWtoValidPosition() {
		Sonda sonda = Sonda.land(malha, H, V, Direction.W);
		sonda = sonda.move(malha);

		assertEquals(9, sonda.getHorizontal());
	}
}

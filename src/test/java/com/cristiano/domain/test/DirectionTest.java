package com.cristiano.domain.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.cristiano.domain.Direction;

public class DirectionTest {
	
	@Test
	public void ordemCorreta(){
		List<Direction> direcoesDisponiveis = Direction.getDirecoesDisponiveis();
		assertEquals(Direction.N, direcoesDisponiveis.get(0));
		assertEquals(Direction.E, direcoesDisponiveis.get(1));
		assertEquals(Direction.S, direcoesDisponiveis.get(2));
		assertEquals(Direction.W, direcoesDisponiveis.get(3));	
	}
	
	@Test
	public void directionsFromN(){
		Direction dir = Direction.N;
		assertEquals(Direction.W, dir.getLeft());
		assertEquals(Direction.E, dir.getRight());
	}
	
	@Test
	public void directionsFromE(){
		Direction dir = Direction.E;
		assertEquals(Direction.N, dir.getLeft());
		assertEquals(Direction.S, dir.getRight());
	}
	
	@Test
	public void directionsFromS(){
		Direction dir = Direction.S;
		assertEquals(Direction.E, dir.getLeft());
		assertEquals(Direction.W, dir.getRight());
	}
	
	@Test
	public void directionsFromW(){
		Direction dir = Direction.W;
		assertEquals(Direction.S, dir.getLeft());
		assertEquals(Direction.N, dir.getRight());
	}

}

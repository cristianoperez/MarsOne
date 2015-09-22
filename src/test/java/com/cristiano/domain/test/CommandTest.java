package com.cristiano.domain.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cristiano.domain.Astronauta;
import com.cristiano.domain.Command;
import com.cristiano.domain.Direction;
import com.cristiano.domain.Malha;
import com.cristiano.domain.Posicao;
import com.cristiano.domain.Sonda;

public class CommandTest {

	private Sonda sonda;
	private Astronauta astronauta;
	
	private Malha malha;
	private final int X = 10;
	private final int Y = 10;
	private final Posicao posicao = Posicao.fixPosition(X, Y);
	private final Direction DIR = Direction.W;
	
	@Before
	public void init() {
		malha = Malha.build(posicao);
		sonda = Sonda.land(malha, posicao, DIR);
		astronauta = Astronauta.land(malha, posicao, DIR);
	}
	
	
	@Test
	public void commandM(){
		Command command = Command.M;
		command.execute(sonda);
		
		command.execute(astronauta);
		
		Assert.assertEquals(9, sonda.getPosicao().getX());
		Assert.assertEquals(9, astronauta.getPosicao().getX());
	}
	
	@Test
	public void commandL(){
		Command command = Command.L;
		command.execute(sonda);
		
		command.execute(astronauta);
		
		Assert.assertEquals(Direction.S, sonda.getDirection());
		Assert.assertEquals(Direction.S, astronauta.getDirection());
	}
	
	@Test
	public void commandR(){ 
		Command command = Command.R;
		command.execute(sonda);
		
		command.execute(astronauta);
		
		Assert.assertEquals(Direction.N, sonda.getDirection());
		Assert.assertEquals(Direction.N, astronauta.getDirection());
	}
}

package com.cristiano.domain;

import java.util.List;

import com.cristiano.exception.InvalidPositionException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public enum Direction {
	N {
		@Override
		public Sonda move(Sonda sonda) throws InvalidPositionException {
			int horizontal = sonda.getHorizontal();
			int vertical = sonda.getVertical() + 1;
			if (vertical > sonda.getMalhaVerticalSize()) {
				throw new InvalidPositionException(new StringBuilder("Posição HORIZONTAL: ").append(horizontal).append(" não existe na malha").toString());
			}
			return sonda.moveTo(horizontal, vertical);
		}
	},
	S {
		@Override
		public Sonda move(Sonda sonda) throws InvalidPositionException {
			int horizontal = sonda.getHorizontal();
			int vertical = sonda.getVertical() - 1;
			if(vertical < 0){
				throw new InvalidPositionException(new StringBuilder("Posição HORIZONTAL: ").append(horizontal).append(" não existe na malha").toString());
			}
			return sonda.moveTo(horizontal, vertical);
		}
	},
	E {
		@Override
		public Sonda move(Sonda sonda) throws InvalidPositionException {
			int horizontal = sonda.getHorizontal() + 1;
			int vertical = sonda.getVertical();
			if(horizontal > sonda.getMalhaHorizontalSize()){
				throw new InvalidPositionException(new StringBuilder("Posição VERTICAL: ").append(vertical).append(" não existe na malha").toString());
			}
			
			return sonda.moveTo(horizontal, vertical);
		}
	},
	W {
		@Override
		public Sonda move(Sonda sonda) throws InvalidPositionException {
			int horizontal = sonda.getHorizontal() - 1;
			int vertical = sonda.getVertical();
			if(horizontal < 0){
				throw new InvalidPositionException(new StringBuilder("Posição VERTICAL: ").append(vertical).append(" não existe na malha").toString());
			}
			
			return sonda.moveTo(horizontal, vertical);
		}
	};

	public Direction getL(Sonda sonda) {
		Direction direction = null;
		if (direcoesDisponiveis.indexOf(this) - 1 == -1) {
			direction = direcoesDisponiveis.get(direcoesDisponiveis.size() - 1);
		} else {
			direction = direcoesDisponiveis.get(direcoesDisponiveis.indexOf(this) - 1);
		}
		return direction;
	}

	public Direction getR(Sonda sonda) {
		Direction direction = null;
		if (direcoesDisponiveis.indexOf(this) + 1 == direcoesDisponiveis.size()) {
			direction = direcoesDisponiveis.get(0);
		} else {
			direction = direcoesDisponiveis.get(direcoesDisponiveis.indexOf(this) + 1);
		}
		return direction;
	}

	public abstract Sonda move(Sonda sonda) throws InvalidPositionException;

	private static List<Direction> direcoesDisponiveis;

	static {
		Builder<Direction> builder = ImmutableList.builder();
		builder.add(Direction.N);
		builder.add(Direction.E);
		builder.add(Direction.S);
		builder.add(Direction.W);
		direcoesDisponiveis = builder.build();
	}
}

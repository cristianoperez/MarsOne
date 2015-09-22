package com.cristiano.domain;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public enum Direction {
	N {
		@Override
		public Posicao move(Posicao posicao) {
			int horizontal = posicao.getX();
			int vertical = posicao.getY() + 1;
			return Posicao.fixPosition(horizontal, vertical);
		}
	},
	S {
		@Override
		public Posicao move(Posicao posicao) {
			int horizontal = posicao.getX();
			int vertical = posicao.getY() - 1;
			return Posicao.fixPosition(horizontal, vertical);
		}
	},
	E {
		@Override
		public Posicao move(Posicao posicao) {
			int horizontal = posicao.getX() + 1;
			int vertical = posicao.getY();
			return Posicao.fixPosition(horizontal, vertical);
		}
	},
	W {
		@Override
		public Posicao move(Posicao posicao) {
			int horizontal = posicao.getX() - 1;
			int vertical = posicao.getY();
			return Posicao.fixPosition(horizontal, vertical);
		}
	};

	public Direction getLeft() {
		Direction direction = null;
		if (direcoesDisponiveis.indexOf(this) - 1 == -1) {
			direction = direcoesDisponiveis.get(direcoesDisponiveis.size() - 1);
		} else {
			direction = direcoesDisponiveis.get(direcoesDisponiveis.indexOf(this) - 1);
		}
		return direction;
	}

	public Direction getRight() {
		Direction direction = null;
		if (direcoesDisponiveis.indexOf(this) + 1 == direcoesDisponiveis.size()) {
			direction = direcoesDisponiveis.get(0);
		} else {
			direction = direcoesDisponiveis.get(direcoesDisponiveis.indexOf(this) + 1);
		}
		return direction;
	}

	public abstract Posicao move(Posicao posicao);
		
	private static List<Direction> direcoesDisponiveis;

	static {
		Builder<Direction> builder = ImmutableList.builder();
		builder.add(Direction.N);
		builder.add(Direction.E);
		builder.add(Direction.S);
		builder.add(Direction.W);
		direcoesDisponiveis = builder.build();
	}
	
	public static List<Direction> getDirecoesDisponiveis() {
		return direcoesDisponiveis;
	}
}

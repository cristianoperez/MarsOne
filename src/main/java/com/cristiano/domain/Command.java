package com.cristiano.domain;

public enum Command {

	L {
		@Override
		public Sonda executar(Sonda sonda, Malha malha) {
			return sonda.changeDirection(sonda.getLeftDirection());
		}
	},
	R {
		@Override
		public Sonda executar(Sonda sonda, Malha malha) {
			return sonda.changeDirection(sonda.getRightDirection());
		}
	},
	M {
		@Override
		public Sonda executar(Sonda sonda, Malha malha) {
			return sonda.move(malha);
		}
	};

	public abstract Sonda executar(Sonda sonda, Malha malha);

}

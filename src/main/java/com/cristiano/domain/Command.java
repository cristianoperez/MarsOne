package com.cristiano.domain;

public enum Command {

	L {
		@Override
		public Sonda executar(Sonda sonda) {
			return sonda.changeDirection(sonda.getLeftDirection());
		}
	},
	R {
		@Override
		public Sonda executar(Sonda sonda) {
			return sonda.changeDirection(sonda.getRightDirection());
		}
	},
	M {
		@Override
		public Sonda executar(Sonda sonda) {
			return sonda.move(sonda.getMalha());
		}
	};

	public abstract Sonda executar(Sonda sonda);
}

package com.cristiano.domain;

public enum Command {

	L {
		@Override
		public void execute(CorpoEspacial corpo) {
			corpo.turnLeft();
		}
	},
	R {
		@Override
		public void execute(CorpoEspacial corpo) {
			corpo.turnRight();
		}
	},
	M {
		@Override
		public void execute(CorpoEspacial corpo) {
			corpo.move();
		}
	};

	public abstract void execute(CorpoEspacial corpo);
	
}

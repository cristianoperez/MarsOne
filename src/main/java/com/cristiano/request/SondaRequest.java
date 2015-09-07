package com.cristiano.request;

import java.util.List;

import com.cristiano.domain.Command;
import com.cristiano.domain.Direction;

public class SondaRequest {

	private int horizontal;
	private int vertical;
	private Direction direction;
	private List<Command> commands;

	public int getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(int horizontal) {
		this.horizontal = horizontal;
	}

	public int getVertical() {
		return vertical;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

}

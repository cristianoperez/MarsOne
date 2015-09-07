package com.cristiano.vo.handler;

import java.util.List;

public abstract class AbstractListHandler<T> {

	private List<T> value;
	private String originalValue;

	public AbstractListHandler(String str) {
		parse(str);
	}

	public abstract void parse(String str);

	public String getOriginalValue() {
		return originalValue;
	}

	public List<T> getValue() {
		return value;
	}

	public void setValue(List<T> value) {
		this.value = value;
	}

	protected void setOriginalValue(String originalValue) {
		this.originalValue = originalValue;
	}

}

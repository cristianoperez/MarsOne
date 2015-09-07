package com.cristiano.vo.handler;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public abstract class AbstractListHandler<T> {

	private List<T> value;
	private String originalValue;

	public AbstractListHandler(String str) {
		try{
			parse(str);
		} catch(Exception e){
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity("Parametro invalido, verifique se os parametros e o formato esta correto. " +e.getMessage()).build());
		}
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

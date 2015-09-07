package com.cristiano.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cristiano.exception.InvalidPositionException;

@Provider
public class InvalidPositionExceptionMapper implements ExceptionMapper<InvalidPositionException>{

	@Override
	public Response toResponse(InvalidPositionException ex) {
		return Response.ok().entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
	}

}

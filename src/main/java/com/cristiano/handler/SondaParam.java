package com.cristiano.handler;

import java.util.Arrays;

import com.cristiano.request.SondaRequest;
import com.google.gson.Gson;

public class SondaParam extends AbstractListHandler<SondaRequest> {

	public SondaParam(String str) {
		super(str);
	}

	@Override
	public void parse(String json) {
		setOriginalValue(json);
		
		Gson gson = new Gson();
		SondaRequest[] arr = gson.fromJson(json, SondaRequest[].class);
		setValue(Arrays.asList(arr));
	}

}

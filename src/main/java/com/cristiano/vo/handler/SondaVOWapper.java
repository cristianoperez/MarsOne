package com.cristiano.vo.handler;

import java.util.Arrays;

import com.cristiano.gson.adapter.TypeCaseSensitiveEnumAdapter;
import com.cristiano.vo.SondaVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SondaVOWapper extends AbstractListHandler<SondaVO> {

	public SondaVOWapper(String str) {
		super(str);
	}

	@Override
	public void parse(String json) {
		setOriginalValue(json);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapterFactory(new TypeCaseSensitiveEnumAdapter());
		Gson gson = gsonBuilder.create();
		SondaVO[] arr = gson.fromJson(json, SondaVO[].class);
		setValue(Arrays.asList(arr));
	}

}

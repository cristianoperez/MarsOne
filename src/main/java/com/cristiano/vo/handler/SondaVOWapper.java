package com.cristiano.vo.handler;

import java.util.Arrays;

import com.cristiano.vo.SondaVO;
import com.google.gson.Gson;

public class SondaVOWapper extends AbstractListHandler<SondaVO> {

	public SondaVOWapper(String str) {
		super(str);
	}

	@Override
	public void parse(String json) {
		setOriginalValue(json);
		
		Gson gson = new Gson();
		SondaVO[] arr = gson.fromJson(json, SondaVO[].class);
		setValue(Arrays.asList(arr));
	}

}

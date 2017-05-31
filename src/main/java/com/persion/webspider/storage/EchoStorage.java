package com.persion.webspider.storage;

import com.persion.webspider.process.ResultItem;

public class EchoStorage implements PageContentStorage {

	@Override
	public void save(ResultItem info) {
		
		System.out.println(info.resultInfo);
	}

}

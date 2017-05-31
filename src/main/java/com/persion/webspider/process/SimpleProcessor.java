package com.persion.webspider.process;

import java.util.List;

import com.persion.webspider.handle.XpathRule;
import com.persion.webspider.page.AbstractProcessor;
import com.persion.webspider.page.WebPage;
import com.persion.webspider.storage.PageContentStorage;

public class SimpleProcessor  extends AbstractProcessor{
	
	private PageContentStorage storage ;
	
	public SimpleProcessor(PageContentStorage storage){
		this.storage = storage;
	} 

	@Override
	public void execute(WebPage page, XpathRule rule) {
		ResultItem item = new ResultItem();
		List<String> ruleinfo = rule.getTagRule();
		for(String rule1:ruleinfo){
			String context = page.getHtml().xpath(rule1).get();
			item.resultInfo.put(rule1, context);
			
		}
		if(storage!=null){
			this.storage.save(item);
		}

		
	}



}

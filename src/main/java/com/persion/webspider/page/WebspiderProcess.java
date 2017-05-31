package com.persion.webspider.page;

import com.persion.webspider.handle.XpathRule;
import com.persion.webspider.storage.PageContentStorage;

import us.codecraft.webmagic.processor.PageProcessor;

public interface WebspiderProcess extends PageProcessor {
	
	public  void setRule(XpathRule rule);
	
	public void setStage(PageContentStorage stage);
	
	public XpathRule getRule();
	
	
	
	
	

}

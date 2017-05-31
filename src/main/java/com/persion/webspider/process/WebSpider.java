package com.persion.webspider.process;

import java.util.concurrent.ExecutorService;

import com.persion.webspider.page.WebspiderProcess;

import us.codecraft.webmagic.Spider;

public class WebSpider extends Spider{
	
	public WebSpider(WebspiderProcess pageProcessor) {
		super(pageProcessor);
		this.addUrl(pageProcessor.getRule().getDomainUrl());
		
	}
	
	public void addUrl(String url){
		super.addUrl(url);
		
	}
	
	public void setThreadNum( int threadNum ){
		super.thread(threadNum);
		
	}
	
	public void setThread(ExecutorService executorService, int threadNum){
		super.thread(executorService, threadNum);
	}
	
	public void startUp(){
		super.run();
	}
	
	

	
	

}

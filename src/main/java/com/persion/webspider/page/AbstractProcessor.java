package com.persion.webspider.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.persion.webspider.handle.XpathRule;
import com.persion.webspider.storage.PageContentStorage;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;

public abstract  class AbstractProcessor implements WebspiderProcess {
	
	
	private Map<String,String> hasCheck = new HashMap<String,String>();
	
	private XpathRule executeRule=null;
	
	private WebSite site = new WebSite();
	
	public void setSite(WebSite site) {
		this.site = site;
	}
	
	@Override
	public XpathRule getRule() {
		return this.executeRule;
	}
	
	

	@Override
	public void setRule(XpathRule rule) {
        this.executeRule = rule;		
	}


	public boolean hasCheck(String url){
		return hasCheck.get(url)!=null;
	}
	
	public abstract  void execute(WebPage page,XpathRule rule);

	@Override
	public void process(Page page) {
		
		System.out.println(page.getUrl());
		
		 if(!page.getUrl().regex(this.executeRule.getDomainUrl()).match()) return;
		
		 //²»·ûºÏÌõ¼ş
		 if(!page.getUrl().regex(this.executeRule.getPageRule()).match()){
	            //åŠ å…¥æ»¡è¶³æ¡ä»¶çš„é“¾æ?
	        	List<String> okurls = new ArrayList<String>();
	        	List<String> urls = page.getHtml().xpath(this.executeRule.getLinkRule()).all();
	        	for(String url:urls){
	        		if(url.startsWith(this.executeRule.getDomainUrl())){
	        			if(hasCheck.get(url)==null){
	            			okurls.add(url);

	        			}
	        		}
	        	}

	            page.addTargetRequests(okurls);
	        }
		 else {
			    hasCheck.put(page.getUrl().get(),"1");
			    
			    WebPage webpage = new WebPage(page);
			    this.execute(webpage, this.executeRule);
//	        	
//	            //è·å–é¡µé¢éœ?è¦çš„å†…å®¹
//	            System.out.println("æŠ“å–çš„å†…å®¹ï¼š"+
//	                    page.getHtml().xpath(this.executeRule.getTagRule()).get()
//	                   );
			 
		 }
	}

	@Override
	public Site getSite() {
		return this.site;
	}

	@Override
	public void setStage(PageContentStorage stage) {
		
	}

}

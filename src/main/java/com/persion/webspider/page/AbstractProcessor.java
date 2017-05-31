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
		
		
		
		 if(!page.getUrl().regex(this.executeRule.getDomainUrl()).match()) return;
		 System.out.println(page.getUrl());
		 //不符合条件
		 if(!page.getUrl().regex(this.executeRule.getPageRule()).match()){
			// System.out.println("不符合");
	            //鍔犲叆婊¤冻鏉′欢鐨勯摼鎺?
	        	List<String> okurls = new ArrayList<String>();
	        	List<String> urls = page.getHtml().xpath(this.executeRule.getLinkRule()).all();
	        	for(String url:urls){
	        		if(url.startsWith(this.executeRule.getDomainUrl())){
	        			// System.out.println("url++++"+url);
	        			if(hasCheck.get(url)==null){
	        				if(this.executeRule.getLinkRex()!=null&&!"".equals(this.executeRule.getLinkRex())){
	        					if(url.startsWith(this.executeRule.getLinkRex())){
		        					okurls.add(url);
		        				}
	        				}
	        				
	            			

	        			}
	        		}
	        	}

	            page.addTargetRequests(okurls);
	        }
		 else {
			    hasCheck.put(page.getUrl().get(),"1");
			    System.out.println("符合条件");
			    
			    WebPage webpage = new WebPage(page);
			    this.execute(webpage, this.executeRule);
//	        	
//	            //鑾峰彇椤甸潰闇?瑕佺殑鍐呭
//	            System.out.println("鎶撳彇鐨勫唴瀹癸細"+
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

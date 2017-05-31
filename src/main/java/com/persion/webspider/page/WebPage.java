package com.persion.webspider.page;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.selector.Selectable;

public class WebPage  extends Page{
	
	private Page page = null;
	@Override
	public Page setSkip(boolean skip) {
		return page.setSkip(skip);
	}
	@Override
	public void putField(String key, Object field) {
		// TODO Auto-generated method stub
		page.putField(key, field);
	}
	@Override
	public Html getHtml() {
		// TODO Auto-generated method stub
		return page.getHtml();
	}
	@Override
	public Json getJson() {
		// TODO Auto-generated method stub
		return page.getJson();
	}
	@Override
	public void setHtml(Html html) {
		// TODO Auto-generated method stub
		page.setHtml(html);
	}
	@Override
	public List<Request> getTargetRequests() {
		return page.getTargetRequests();
	}
	@Override
	public void addTargetRequests(List<String> requests) {
		page.addTargetRequests(requests);
	}
	@Override
	public void addTargetRequests(List<String> requests, long priority) {
		page.addTargetRequests(requests, priority);
	}
	@Override
	public void addTargetRequest(String requestString) {
		page.addTargetRequest(requestString);
	}
	@Override
	public void addTargetRequest(Request request) {
		page.addTargetRequest(request);
	}
	@Override
	public Selectable getUrl() {
		return page.getUrl();
	}
	@Override
	public Request getRequest() {
		return page.getRequest();
	}
	@Override
	public boolean isNeedCycleRetry() {
		return page.isNeedCycleRetry();
	}
	@Override
	public void setNeedCycleRetry(boolean needCycleRetry) {
		page.setNeedCycleRetry(needCycleRetry);
	}
	@Override
	public void setRequest(Request request) {
		page.setRequest(request);
	}
	@Override
	public ResultItems getResultItems() {
		return page.getResultItems();
	}
	@Override
	public int getStatusCode() {
		return page.getStatusCode();
	}
	@Override
	public void setStatusCode(int statusCode) {
		page.setStatusCode(statusCode);
	}
	@Override
	public String getRawText() {
		return page.getRawText();
	}
	@Override
	public Page setRawText(String rawText) {
		return page.setRawText(rawText);
	}
	public WebPage(Page page){
		this.page = page;
	}
	public WebPage(){
		this.page = new Page();
	}

}

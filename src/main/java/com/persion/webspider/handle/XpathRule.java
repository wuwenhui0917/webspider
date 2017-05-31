package com.persion.webspider.handle;

import java.util.ArrayList;
import java.util.List;

public class XpathRule {
	
	/*获取数据的规则*/
	private List<String> resultRule = new ArrayList<String>();
	
	private String domainUrl;
	
	private String linkRex;
	
	public String getLinkRex() {
		return linkRex;
	}

	public void setLinkRex(String linkRex) {
		this.linkRex = linkRex;
	}

	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}

	/**符合条件的页面链接规则*/
	private String pageRule;
	/**获取链接规则*/
	private String linkRule;

	public String getLinkRule() {
		return linkRule;
	}

	public void setLinkRule(String linkRule) {
		this.linkRule = linkRule;
	}

	public String getPageRule() {
		return pageRule;
	}

	public void setPageRule(String pageRule) {
		this.pageRule = pageRule;
	}

	public List<String> getTagRule() {
		return resultRule;
	}

	public void addTagRule(String resultRule) {
		this.resultRule.add(resultRule);
	}
	
	

}

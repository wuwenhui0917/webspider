package webspider;

import com.persion.webspider.handle.XpathRule;
import com.persion.webspider.page.WebSite;
import com.persion.webspider.process.SimpleProcessor;
import com.persion.webspider.process.WebSpider;
import com.persion.webspider.storage.EchoStorage;
import com.persion.webspider.storage.PageContentStorage;

public class TestProcess {
	
	public static void main(String[] a){
		
		String url = "http://news.qq.com/a/20170531/016031.htm";
		System.out.println(url.startsWith("http://news.qq.com/a/20170531/016031"));
		//设置规则
		XpathRule rule = new XpathRule();
		//设置开始扫描主站
		rule.setDomainUrl("http://news.qq.com/");
		//设置url链接
		rule.setLinkRule("//a/@href");
		//符合条件的链接
		//rule.setPageRule("http://news.qq.com/a/20170531/[a-z 0-9 -]+/[0-9]{5,10}.htm");
		rule.setPageRule("http://news.qq.com/a/20170531/[0-9]{5,10}.htm");
		rule.setLinkRex("http://news.qq.com/a/20170531/");
		//符合条件的内容
		rule.addTagRule("//*[@id=\"Cnt-Main-Article-QQ\"]");
		//持久化内容
		PageContentStorage echo= new EchoStorage();
		//处理器
		SimpleProcessor process = new SimpleProcessor(echo);
		process.setRule(rule);
		
		WebSite site = new WebSite();
		site.setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		process.setSite(site);
		
		WebSpider wesplier = new WebSpider(process);
		//wesplier.addUrl(rule.getDomainUrl());
		wesplier.setThreadNum(10);
		wesplier.run();
		
		
		
		
	}

}

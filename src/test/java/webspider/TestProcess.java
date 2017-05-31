package webspider;

import com.persion.webspider.handle.XpathRule;
import com.persion.webspider.page.WebSite;
import com.persion.webspider.process.SimpleProcessor;
import com.persion.webspider.process.WebSpider;
import com.persion.webspider.storage.EchoStorage;
import com.persion.webspider.storage.PageContentStorage;

public class TestProcess {
	
	public static void main(String[] a){
		//���ù���
		XpathRule rule = new XpathRule();
		//���ÿ�ʼɨ����վ
		rule.setDomainUrl("http://www.zaowannews.cn");
		//����url����
		rule.setLinkRule("//a/@href");
		//��������������
		rule.setPageRule("http://www.zaowannews.cn/a/[a-z 0-9 -]+/[0-9]{5,10}.html");
		//��������������
		rule.addTagRule("//div[@class='content']");
		//�־û�����
		PageContentStorage echo= new EchoStorage();
		//������
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

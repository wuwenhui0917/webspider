# webspider

   ## 是一个简易版的爬虫框架，主要分为3个模块：处理模块，规则模块，存储模块

   ### 处理模块：主要实现爬虫的爬取功能，提供了一套接口设计，可直接扩展内容
   ### 规则模块：主要是实现爬取规则。主要是配置要爬去的网站，爬取规则，爬取内容的规则。
       支持xpath的方式。是用户主要扩展的类
   ### 存储模块：主要是实现内容的持久化类，可以将其放入文件系统。hdfs文件系统，或者kafka，redis等任何支持存储的地方，
    支持可扩展


   ##测试：
     public static void main(String[] a){
		//设置规则
		XpathRule rule = new XpathRule();
		//设置开始扫描主站
		rule.setDomainUrl("http://www.zaowannews.cn");
		//设置url链接
		rule.setLinkRule("//a/@href");
		//符合条件的链接
		rule.setPageRule("http://www.zaowannews.cn/a/[a-z 0-9 -]+/[0-9]{5,10}.html");
		//符合条件的内容
		rule.addTagRule("//div[@class='content']");
		//持久化内容，这个是打印持久化
		PageContentStorage echo= new EchoStorage();
		//处理器
		SimpleProcessor process = new SimpleProcessor(echo);
		process.setRule(rule);
		
		//主要扩展了，为了防止有的网站通过userAgent去防爬虫，需要设置userAgent，
		WebSite site = new WebSite();
		site.setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		process.setSite(site);
		
		//启动器开始
		WebSpider wesplier = new WebSpider(process);
		//设置10个线程同时处理
		wesplier.setThreadNum(10);
		//启动
		wesplier.run();
		
		
	}



  
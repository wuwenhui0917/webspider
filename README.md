# webspider

   ## ��һ�����װ�������ܣ���Ҫ��Ϊ3��ģ�飺����ģ�飬����ģ�飬�洢ģ��

   ### ����ģ�飺��Ҫʵ���������ȡ���ܣ��ṩ��һ�׽ӿ���ƣ���ֱ����չ����
   ### ����ģ�飺��Ҫ��ʵ����ȡ������Ҫ������Ҫ��ȥ����վ����ȡ������ȡ���ݵĹ���
       ֧��xpath�ķ�ʽ�����û���Ҫ��չ����
   ### �洢ģ�飺��Ҫ��ʵ�����ݵĳ־û��࣬���Խ�������ļ�ϵͳ��hdfs�ļ�ϵͳ������kafka��redis���κ�֧�ִ洢�ĵط���
    ֧�ֿ���չ


   ##���ԣ�
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
		//�־û����ݣ�����Ǵ�ӡ�־û�
		PageContentStorage echo= new EchoStorage();
		//������
		SimpleProcessor process = new SimpleProcessor(echo);
		process.setRule(rule);
		
		//��Ҫ��չ�ˣ�Ϊ�˷�ֹ�е���վͨ��userAgentȥ�����棬��Ҫ����userAgent��
		WebSite site = new WebSite();
		site.setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		process.setSite(site);
		
		//��������ʼ
		WebSpider wesplier = new WebSpider(process);
		//����10���߳�ͬʱ����
		wesplier.setThreadNum(10);
		//����
		wesplier.run();
		
		
	}



  
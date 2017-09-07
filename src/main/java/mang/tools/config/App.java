package mang.tools.config;

import java.util.List;
import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mang.tools.config.service.ConfigService;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");


		DOMConfigurator.configure(ClassLoader.getSystemResource("conf/log4j.xml"));

//		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/applicationContext-mysql.xml");
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/applicationContext-oracle.xml");

		// TestSnService service=ctx.getBean(TestSnService.class);
		ConfigService service = (ConfigService) ctx.getBean("configService");
		List lis=service.queryConfig("test");
		
		Map<String,String> map=service.queryConfigMap("test");
		
		String value=service.queryConfig("test", "0101");
		

		System.out.println("hah");
	}
}

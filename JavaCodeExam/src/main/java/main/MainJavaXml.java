package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JavaMainConf;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainJavaXml {

	public static void main(String[] args) {
		
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(
						JavaMainConf.class);
						//설정파일 매개변수만 달라짐
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("dbflarla4966@naver.com");
		regReq.setName("김유림");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		regSvc.regist(regReq);
		
		infoPrinter.printMemberInfo("dbflarla4966@naver.com");
		
		((AnnotationConfigApplicationContext)ctx).close();

	}

}
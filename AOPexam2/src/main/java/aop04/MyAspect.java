package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//횡단 관심사 정의 클래스(POJO기반) 
public class MyAspect {
	public void bootingAndLogin(JoinPoint jp) {
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅 및 " + pwd + "를 입력하여 로그인");
	}
}

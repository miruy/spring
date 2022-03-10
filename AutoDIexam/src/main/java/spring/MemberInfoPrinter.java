package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//회원정보를 출력하는 클래스(이메일로 검색)
public class MemberInfoPrinter {
	
	@Autowired
	private MemberDao memDao;
	private MemberPrinter printer;
	
	//addCtx.xml에서 property태그(속성지정)를 사용하기 위해 setter메서드 생성
	//addCtx.xml파일로부터 set메서드가 의존객체를 전달받음
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	@Autowired
	@Qualifier("sysout")	//Printer객체가 중복될 때 Qualifier어노테이션을 지정해주어 빈을 지정 
	public void setMemberPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	//이메일로 회원여부 검색 후 회원이면 출력하는 메서드 
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if(member == null) {
			System.out.println("회원 정보 없음!\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}

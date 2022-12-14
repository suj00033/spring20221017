package lecture.p03core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// 객체 만드는 일
		String configLocation = "/lecture/p03core/context.xml";
		
		ApplicationContext context;
		context = new ClassPathXmlApplicationContext(configLocation);
		
		Servlet s = context.getBean(Servlet.class);
		Dao d = context.getBean(Dao.class);
		
		
		System.out.println(d);
		System.out.println(s); // null이 아니면 객체가 있다.
		System.out.println("프로그램 계속 실행");
	}
}

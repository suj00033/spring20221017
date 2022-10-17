package lecture.p13core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Servlet s = context.getBean(Servlet.class);
		Dao d = context.getBean(Dao.class);
		
		System.out.println(s);
		System.out.println(d); // 얘랑
		System.out.println(s.getDao()); // 얘랑
		
		Controller c = context.getBean(Controller.class);
		System.out.println(c);
		System.out.println(c.getDao()); // 얘는 같음
		
		System.out.println("프로그램 계속 실행");
	}
}

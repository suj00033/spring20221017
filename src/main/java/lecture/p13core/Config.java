package lecture.p13core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	// 자바로 주입 설정
	
	@Bean
	public Controller controller() {
		return new Controller(dao());
	}
	
	@Bean
	public Servlet servlet() {
		Servlet s = new Servlet();
		// xml파일에서 <bean class="lecture.p03core.Servlet"></bean>과 같은 역할
		s.setDao(dao());
		return s;
	}
	
	@Bean
	public Dao dao() {
		return new Dao();
	}
}

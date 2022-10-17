package lecture.p12core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	@Autowired
	private Service service; // 컨트롤러가 서비스에 의존하도록
	
	public Service getService() {
		return service;
	}
}

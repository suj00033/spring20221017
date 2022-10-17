package lecture.p10core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	private Service service;
	
	@Autowired // 자동으로 만들어진 빈을 주입, set메소드에 장착
	public void setService(Service service) {
		this.service = service;
	}

	public Service getService() {
		return service;
	}
}

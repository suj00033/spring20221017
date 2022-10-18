package lecture.p09core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Servlet {

	private Dao dao;
	
	// 주입 가능한 빈이 있다면 이 메소드 사용해서 주입해라(set을 이용하던가, 필드를 이용하라)
	@Autowired // 필드주입을 통한 메소드
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public Dao getDao() {
		return dao;
	}
}

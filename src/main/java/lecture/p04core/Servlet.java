package lecture.p04core;

import lombok.Getter;
import lombok.Setter;

public class Servlet {
	// 의존성 주입
	@Setter
	@Getter
	private Dao dao;
}

package lecturep.p01lombok;

import lombok.Getter;
import lombok.Setter;

public class JavaBean3 {
	@Getter				// 특정메소드만 getter, setter하고 싶을때
	@Setter				// 필드에만 붙여서 사용가능
	private String name;
	
	@Getter				
	@Setter
	private int age;
	
}

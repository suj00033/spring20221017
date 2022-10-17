package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 필드 초기화 하는 생성자 생성
@AllArgsConstructor
public class JavaBean7 {
	
	private final String name;
	private final int age; // final 무조건 1번만 값할당
	private String address;
	
//	public JavaBean7(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
}

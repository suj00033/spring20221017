package lecture.p01lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class JavaBean4 {
//	@Override
//	public String toString() {
//		return "JavaBean4 [address=" + address + ", score=" + score + "]";
//	}
	private String address;
	private int score;
}

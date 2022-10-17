package lecture.p02core;

public class App {
	public static void main(String[] args) {
		// 우리가 control > 우리가 안하고 spring에게 맡길수 있음(Dependency Injection, DI) = Inversion of Control(제어역전, 제어반전)
		Servlet1 servlet1 = new Servlet1();
		servlet1.setProductDao(new ProductDao()); // set필드 (의존성 dependency)
		servlet1.doGet();
		
		System.out.println("프로그램 계속 진행");
	}
}

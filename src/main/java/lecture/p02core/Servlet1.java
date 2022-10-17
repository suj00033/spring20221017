package lecture.p02core;

//import lombok.AllArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
public class Servlet1 {
	
	@Setter
	private ProductDao productDao;
	
	public void doGet() {
		productDao.getProductName();
	}
}

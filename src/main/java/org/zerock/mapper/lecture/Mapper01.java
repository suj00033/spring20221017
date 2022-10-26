package org.zerock.mapper.lecture;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Select;

public interface Mapper01 {
	
	@Select("SELECT NOW()") // 여기서 쿼리문만 잘 작성하면 됨
	public String getCurrentTime();
	
	@Select("SELECT CustomerName FROM w3schools.Customers WHERE CustomerId = 77")
	public String getCustomerName();
	
	public String getEmployeeName();
	
	public String getProductName();
	
	public double getPrice();
	
	public int getQuantity();
	
//	public Date getBirthDate(); // import할때 util로
	
	public LocalDate getBirthDate();
}

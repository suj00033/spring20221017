package org.zerock.mapper.lecture;

import java.util.List;

import org.zerock.domain.lecture.JavaBean04;
import org.zerock.domain.lecture.JavaBean16;
import org.zerock.domain.lecture.JavaBean17;

public interface Mapper09 {

	String getCustomerNameById(int id); // (여기에 들어가는 파라미터명을 xml #{ }안에 넣어준다
	String getEmployeeFirstNameById(int id);
	
	List<String> getCustomerNameByCityAndCountry(String country, String city);
	String getSupplierNameByCityAndCountry(String country, String city);
	
	String getContactName(JavaBean04 bean1);
	String getSupplierContactName(JavaBean04 bean2);
	
	List<String> getProductName(JavaBean16 arg1, JavaBean17 arg2);
	
	
}

package org.zerock.mapper.lecture;

import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;

public interface Mapper10 {
	
	int removeCustomer();
	int removeEmployee();
	
	int removeCustomerById(int id);
	int removeEmployeeById(int id);
	
	int addCutomer(); // ~개가 입력되었습니다
	int addSuppiler();
	
	int insetCustomer(JavaBean18 customer);
	int insertSupplier(JavaBean19 supplier);
	int insetCustomerAndGetKey(JavaBean18 customer);
	int insertSupplierAndGetKey(JavaBean19 supplier);
}

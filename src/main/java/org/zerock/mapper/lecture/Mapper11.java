package org.zerock.mapper.lecture;

import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;

public interface Mapper11 {
	int updateCustomer(JavaBean18 customer);
	int updateSupplier(JavaBean19 supplier);


	JavaBean18 getCustomerById(int id);
	JavaBean19 getSupplierById(int id);
	int updateBank(int account, int money);
}

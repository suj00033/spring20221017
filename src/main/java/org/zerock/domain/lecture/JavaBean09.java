package org.zerock.domain.lecture;

import lombok.Data;

// products
@Data
public class JavaBean09 {
	private int id;
	private String name;
	private double price;
	private JavaBean10 supplier;
}

// resultMap type은 겉에 있는걸로
// 겉 자바빈
// ON으로 묶었던 공통컬럼을 안 자바빈으로
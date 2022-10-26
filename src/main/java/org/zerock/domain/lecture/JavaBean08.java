package org.zerock.domain.lecture;

import java.time.LocalDate;

import lombok.Data;

// orders
@Data
public class JavaBean08 {
	private int id;
	private LocalDate date;
	private JavaBean05 employee;
	// 또다른 빈을 갖고있도록
}

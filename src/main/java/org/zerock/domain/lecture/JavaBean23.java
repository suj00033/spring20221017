package org.zerock.domain.lecture;

import lombok.Data;

@Data
// 객체 안의 객체
public class JavaBean23 {

	private String name;
	private JavaBean24 job;
}

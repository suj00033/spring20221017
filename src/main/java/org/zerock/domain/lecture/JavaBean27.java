package org.zerock.domain.lecture;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.Data;

@Data
public class JavaBean27 {

	private String name;
	private LocalDate date;
	// 배열로 받지않고 2022-11-03으로 받고싶을때 필요한 코드
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDateTime dateTime;
} // LocalDate를 json으로 빼내려면 library 추가해야함

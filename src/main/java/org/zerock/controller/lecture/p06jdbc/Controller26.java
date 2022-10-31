package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// jdbc url /w3schools로 바꾸기
@Controller
@RequestMapping("ex26")
public class Controller26 {

	@Autowired
	private DataSource dataSource;

	@RequestMapping("sub01")
	public void met01() throws Exception {
		String sql = "INSERT INTO Customers (CustomerName) VALUES (?) ";
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, "SON HM");

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int newKey = rs.getInt(1);
				System.out.println(newKey + "번 고객입력됨");
			}
		}

	}
	
	// met02()
	// 새 직원을 입력하고 생성된 키를 sysout으로 출력하는 코드 작성
	
	@RequestMapping("sub02")
	public void met02() throws Exception {
		String sql = "INSERT INTO Employees(firstName, LastName) VALUES (?, ?) ";
		try(Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1,  "Lee");
			pstmt.setString(2, "Jin");
			
		
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int newKey = rs.getInt(1);
				System.out.println(newKey + "번 직원 입력");
			}
		}
	}
}
package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex25")
public class Controller25 {
	// WEB-INF/props/root-context에서 주소를 w3schoolsd에서 mydb1로 변경

	@Autowired
	public DataSource dataSource;
	
	@RequestMapping("sub01")
	public void met01() throws Exception {
		String sql = "INSERT INTO myTable08 (col1, col2, col3, col4, col5, col6) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		

		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, 9999999);
			pstmt.setDouble(2, 231243.312);
			pstmt.setString(3, "hello world");
			pstmt.setString(4, "sql");
			pstmt.setDate(5, java.sql.Date.valueOf("2022-10-01"));
			pstmt.setTimestamp(6, java.sql.Timestamp.valueOf("2011-11-11 12:12:12"));
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 레코드 입력 성공");
			// ex25/sub01를 입력하고 mySQL로 들어가면 테이블에 데이터가 삽입되어있음
		}
	}
	
	@RequestMapping("sub02")
	public void met02() throws Exception {
		// mydb1.myTable09 에 레코드 입력 코드 작성
		String sql = "INSERT INTO myTable09 (name, age, score, address, birthDate, inserted) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) { // mariadb로 값 넣을때
			pstmt.setString(1, "SON");
			pstmt.setInt(2, 34);
			pstmt.setDouble(3, 32.21);
			pstmt.setString(4, "London");
			pstmt.setDate(5, java.sql.Date.valueOf("1989-03-17"));
			pstmt.setTimestamp(6, java.sql.Timestamp.valueOf("2004-02-27 13:23:30"));
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 레코드 입력 성공");
		}
	}
	
	@RequestMapping("sub03")
	public void met03() throws Exception {
		String sql = "SELECT col1, col2, col3, col4, col5, col6 FROM myTable08 ";
		

		try (Connection con = dataSource.getConnection(); // mariadb에서 가져올때
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			
			while (rs.next()) {
				int col1 = rs.getInt("col1");
				double col2 = rs.getDouble("col2");
				String col3 = rs.getString("col3");
				String col4 = rs.getString("col4");
				java.sql.Date col5 = rs.getDate("col5");
				java.sql.Timestamp col6 = rs.getTimestamp("col6");
				
				System.out.println(col1);
				System.out.println(col2);
				System.out.println(col3);
				System.out.println(col4);
				System.out.println(col5);
				System.out.println(col6);
			}
		}
	}
	
	@RequestMapping("sub04")
	public void met04() throws Exception {
		String sql = "SELECT name, age, score, address, birthDate, inserted FROM myTable09 ";
		
		try (Connection con = dataSource.getConnection(); // mariadb에서 가져올때
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				String address = rs.getString("address");
				java.sql.Date birthDate = rs.getDate("birthDate");
				java.sql.Timestamp inserted = rs.getTimestamp("inserted");
				
				System.out.println(name);
				System.out.println(age);
				System.out.println(score);
				System.out.println(address);
				System.out.println(birthDate);
				System.out.println(inserted);
			}
		}
	}
}

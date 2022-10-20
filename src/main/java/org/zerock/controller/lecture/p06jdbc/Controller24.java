package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.lecture.Customer;

@Controller
@RequestMapping("ex24")
public class Controller24 {
	
	@Autowired
	private DataSource dataSource;

	@GetMapping("sub01")
	public void listAllCustomers(
			@ModelAttribute("customerList") ArrayList<Customer> list) throws Exception {
		
		String sql = "SELECT "
				+ "CustomerID id, "
				+ "CustomerName name, "
				+ "ContactName, "
				+ "Address, "
				+ "City, "
				+ "PostalCode, "
				+ "Country "
				+ "FROM Customers "
				+ "ORDER BY CustomerID DESC";
		
		try (Connection con = dataSource.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			
			while (rs.next()) {
				Customer c = new Customer();
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				c.setPostalCode(rs.getString("postalCode"));
				c.setId(rs.getInt("id"));
				c.setContactName(rs.getString("contactName"));
				
				list.add(c);
			}
		}
	}

	@GetMapping("sub02")
	public String listCustomers(
			@RequestParam(name = "page", defaultValue="1") int page,
			@ModelAttribute("customerList") ArrayList<Customer> list,
			@ModelAttribute("pageInfo") HashMap<String, Object> pageInfo) throws Exception {
		
		String sql = "SELECT "
				+ "CustomerID id, "
				+ "CustomerName name, "
				+ "ContactName, "
				+ "Address, "
				+ "City, "
				+ "PostalCode, "
				+ "Country "
				+ "FROM Customers "
				+ "ORDER BY CustomerID DESC "
				+ "LIMIT ?, ?";
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, (10 * (page - 1)));
			pstmt.setInt(2, 10);
			
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					Customer c = new Customer();
					c.setName(rs.getString("name"));
					c.setAddress(rs.getString("address"));
					c.setCity(rs.getString("city"));
					c.setCountry(rs.getString("country"));
					c.setPostalCode(rs.getString("postalCode"));
					c.setId(rs.getInt("id"));
					c.setContactName(rs.getString("contactName"));
					
					list.add(c);
				}
				
			}
			
		}
		
		// 총 고객 수
		sql = "SELECT COUNT(*) FROM Customers";
		
		int cnt = 1;
		try (Connection con = dataSource.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			
			if (rs.next()) {
				cnt = rs.getInt(1); // 쿼리문 결과 -> 총 고객수 364 라는 결과값 1개이다
			}
		}
		
		int lastPage = (cnt - 1)/10 + 1; // 363 / 10 -> 36 + 1 = 37 총 37페이지
		int leftPage = Math.max(page - 5, 1); // 현재 페이지가 32 기준으로, 왼쪽으로 5개 적어지는(27페이지) 1보다 클때 왼쪽페이지 5개 보여줌
		pageInfo.put("total", cnt);		// 전체 페이지
		pageInfo.put("lastPage", lastPage);
		pageInfo.put("current", page);  // 현재 페이지 정보, ex24/sub02만 검색해도 1페이지 active를 하기위함
		   								// 안할시에는 sub02만 쳤을때 몇페이지 활성화가 안보임
		pageInfo.put("leftPage", leftPage);
		pageInfo.put("rightPage", Math.min(leftPage + 9, lastPage)); // 27부터 + 9 -> 36페이지까지 보이도록
		
		return "ex24/sub01";
	}
}












<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<h1>fetch 요청 header 조작</h1>
	
	<button class="" id="btn1">/ex41/sub01 get, 헤더 추가</button>
<br>
	<button class="" id="btn2">/ex41/sub01 get, header</button>
<br><br><br>
	<button class="" id="btn3">/ex41/sub01 헤더 추가 (Your-Header)</button>
<br>
	<button class="" id="btn4">/ex41/sub01 헤더 추가 (Money-Bag)</button>
<br><br><br>
	<button class="" id="btn5">/ex41/sub01 헤더 변경(Accept)</button>
<br>
	<button class="" id="btn6">/ex41/sub06 헤더 변경(Accept-Encoding : "*")</button>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
<script type="text/javascript">
	const ctx = "${pageContext.request.contextPath}";
	
	// Accept
	document.querySelector("#btn5").addEventListener("click", function() {
		fetch(ctx + "/ex41/sub05", 
					{/* method : "get", get방식은 생략가능*/
					headers : {"My-Header" : "My Values",
							   "Accept" : "text/plain"
			} 
		});
	});
	
	document.querySelector("#btn6").addEventListener("click", function() {
		fetch(ctx + "/ex41/sub06", 
					{
					headers : {"Money-Bag" : "Bank",
							   "Accept-Language" : "*"} 
		});
	});

	// 하이픈(-)을 쓰려면 ""을 써야함
	document.querySelector("#btn4").addEventListener("click", function() {
		fetch(ctx + "/ex41/sub01", 
					{method : "get",
					headers : {"Money-Bag" : "Bank"} 
		});
	});

	document.querySelector("#btn3").addEventListener("click", function() {
		fetch(ctx + "/ex41/sub01", 
					{method : "get",
					headers : {"Your-Header" : "your header"} 
		});
	});
	
	// 2개의 옵션
	document.querySelector("#btn1").addEventListener("click", function() {
		fetch(ctx + "/ex41/sub01", 
					{method : "get", 
					headers : {MyHeader : "My Header Value"}
		});
	});

	// 여러 프로퍼티 가능
	document.querySelector("#btn2").addEventListener("click", function() {
		fetch(ctx + "/ex41/sub01", 
					{method : "get", 
					headers : {YourHeader : "Your Header Value", 
							   MyHeader : "My Header Value"       			 
			} 
		});
	});
</script>
</html>
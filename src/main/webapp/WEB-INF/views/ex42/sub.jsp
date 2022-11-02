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
	<h1>Accept 요청 헤더를 처리하는 Controller Method</h1>
	<button class="" id="btn1">/ex42/sub01 요청</button>
<br>
	<button class="" id="btn2">text/html 요청</button>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript">
	const ctx = "${pageContext.request.contextPath}";
	
	document.querySelector("#btn2").addEventListener("click", function() {
		fetch(ctx + "/ex42/sub01",
				{
					headers : {
						"Accept" : "text/html"
					}
				});
	});
	
	
	document.querySelector("#btn1").addEventListener("click", function() {
		fetch(ctx + "/ex42/sub01", 
					{
					headers : {
								// */* 모든 타입으로 받겠다.
							   "Accept" : "text/plain"  	// 무엇을 생산하는지 미디어 타입을 맞춰서 사용			
			} 
		});
	});



</script>
</body>
</html>
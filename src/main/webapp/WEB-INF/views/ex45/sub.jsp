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
	<h1>응답</h1>
	
	<button class="" id="btn1">/ex45/sub01 </button>
<br>
	<button class="" id="btn2">/ex45/sub02@@ accepted</button>
<br>
	<button class="" id="btn3">/ex45/sub03@@@@ 응답 header</button>
<br>
	<button class="" id="btn4">/ex45/sub04@@@@@@ 응답 header Your-Header : Your-Value</button>
<br>
	<button class="" id="btn5">/ex45/sub05@@@@@@ 응답본문 String </button>
<br>
	<button class="" id="btn6">/ex45/sub06@@@@@@ JavaBean24 </button>
<br>
	<button class="" id="btn7">/ex45/sub07@@@@@@ json {"name" : "손흥민", "address" : "서울" }</button>
<br>
	<button class="" id="btn8">/ex45/sub08@@@@@@ json 날짜 시간</button>
<br>
	<button class="" id="btn9">/ex45/sub09@@@@@@ 응답본문 complex</button>
<br>
	<button class="" id="btn10">/ex45/sub010@@@@@@ 응답본문 responseBody</button>
<br>
	<button class="" id="btn11">/ex45/sub11@@@@@@ 응답본문 JavaBean 27 responseBody</button>
<br><br>
	<button class="" id="btn13">/ex45/sub13@@@@@@ map > json</button>
<br>
	<button class="" id="btn14">/ex45/sub14@@@@@@ map complex > json</button>
<br>
	<button class="" id="btn15">/ex45/sub15########## {"car" : "tesla", "model" : "avante", "color" : ["blue", "red"]}</button>
<br>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript">
	const ctx = "${pageContext.request.contextPath}";
	
	// map complex
	document.querySelector("#btn15").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub15")
	});

	// map complex
	document.querySelector("#btn14").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub14")
	});

	// map
	document.querySelector("#btn13").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub13")
	});

	// JavaBean27
	document.querySelector("#btn11").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub11")
	});

	// JavaBean27
	document.querySelector("#btn10").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub10")
	});
	
	// JavaBean25 complex
	document.querySelector("#btn9").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub09")
	});

	// JavaBean27 (date, dateTime)
	document.querySelector("#btn8").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub08")
	});

	// JavaBean20
	document.querySelector("#btn7").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub07")
	});

	// JavaBean24
	document.querySelector("#btn6").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub06")
	});

	// String -> 본문은 response 탭에서 볼 수 있음
	document.querySelector("#btn5").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub05")
	});

	// header 변경
	document.querySelector("#btn4").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub04")
	});

	// header 변경
	document.querySelector("#btn3").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub03")
	});

	// 응답코드 accepted
	document.querySelector("#btn2").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub02")
	});

	// 응답코드 200번을 받음
	document.querySelector("#btn1").addEventListener("click", function() {
		fetch(ctx + "/ex45/sub01")
	});
	
</script>
</body>
</html>
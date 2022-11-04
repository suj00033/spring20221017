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
	<h1>응답 처리</h1>

	<button class="" id="btn1">/ex46/sub01 </button>
<br>
	<button class="" id="btn2">/ex46/sub01 순서보장 </button>
<br>
	<button class="" id="btn3">/ex46/sub01 전에 받은 함수 전해받음 </button>
<br>
	<button class="" id="btn4">/ex46/sub01 전에 받은 함수와 결합 </button>
<br>
	<button class="" id="btn5">/ex46/sub01 람다</button>
<br>
	<button class="" id="btn6">/ex46/sub01 람다 기호 생략 6</button>
<br>
	<button class="" id="btn7">/ex46/sub01 람다 기호 생략 7</button>
<br>
	<button class="" id="btn8">/ex46/sub01 람다 기호 생략 8</button>
<br><br>
	<button class="" id="btn9">/ex46/sub01 9999 response text</button>
<br>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript">
const ctx = "${pageContext.request.contextPath}";

	// 람다형식으로 기호생략 , console.log를 리턴했기때문에 7번과 다른값이 나옴
	document.querySelector("#btn9").addEventListener("click", function() {
	
		fetch(ctx + "/ex46/sub01")
		.then((response) => response.text())
		.then((data) => console.log(data))
	});

	// 람다형식으로 기호생략 , console.log를 리턴했기때문에 7번과 다른값이 나옴
	document.querySelector("#btn8").addEventListener("click", function() {
	
		fetch(ctx + "/ex46/sub01")
		.then(() => 3)
		.then(a => console.log(a * 2)) // 
		.then(b => console.log(b * 2)) // 
		.then(c => console.log(c)); // 
	});

	// 람다형식으로 기호생략
	document.querySelector("#btn7").addEventListener("click", function() {
	
		fetch(ctx + "/ex46/sub01")
		.then(() => 3)
		.then(a => a * 2) // 6
		.then(b => b * 2) // 12
		.then(c => console.log(c)); // 12
	});

	// 람다형식으로 기호생략
	document.querySelector("#btn6").addEventListener("click", function() {
	
		fetch(ctx + "/ex46/sub01")
		.then(() => "a")
		.then(v => v + "b")
		.then(v => console.log(v)); // "ab" 출력되도록 
	});
	
	// 람다형식으로
	document.querySelector("#btn5").addEventListener("click", function() {
	
		fetch(ctx + "/ex46/sub01")
		.then(() => {
			
			return "a";
		})
		.then((v) => {

			return v + "b";
		/* 	return "ab"; */
		})
		.then((v) => {
			
			console.log(v); // "ab" 출력되도록 
		});
	});

	// then이 파라미터 함수(function)을 받음
	document.querySelector("#btn4").addEventListener("click", function() {
	
		fetch(ctx + "/ex46/sub01")
		.then(function() {
			
			return "a";
		})
		.then(function(v) {

			return v + "b";
		/* 	return "ab"; */
		})
		.then(function(v) {
			
			console.log(v); // "ab" 출력되도록 
		});
	});

	// then이 파라미터 함수(function)을 받음
	document.querySelector("#btn3").addEventListener("click", function() {
	
		fetch(ctx + "/ex46/sub01")
		.then(function() {
			console.log("첫번째 then 함수");
			
			return "abc";
		})
		.then(function(data) {
			console.log("두번째 then 함수");
			console.log("첫번째 then 함수가 리턴한 값: ", data);
		});
	});

	// 분리하여 순서 보장
	document.querySelector("#btn2").addEventListener("click", function() {
	
		fetch(ctx + "/ex46/sub01")
		.then(function() {
			console.log("응답 후 실행해야하는 코드1");
			console.log("응답 후 실행해야하는 코드2");
		})
		.then(function() {
			console.log("응답 후 실행3");
			console.log("응답 후 실행4");
		});
	});

	// 작업이 바로 끝남
	document.querySelector("#btn1").addEventListener("click", function() {
	console.log("1 상태");
	
		fetch(ctx + "/ex46/sub01").then(function() {
			console.log("응답 후 실행해야하는 코드 3");
		});
	
	console.log("응답과 상관없이 계속 실행하는 코드 2");
	});

</script>
</body>
</html>
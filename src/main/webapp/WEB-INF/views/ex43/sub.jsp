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
	<h1>서버로 데이터 전송하기</h1>
	
	<button class="" id="btn1">/ex43/sub01 get 요청</button>
<br>
	<button class="" id="btn2">/ex43/sub02 get 요청</button>
<br><br>
	<button class="" id="btn3">/ex43/sub03 get 요청</button>
<br>
	<form action="" id="form1">
		name <input type="text" name="name"> <br>
		email <input type="text" name="email">
	</form>
<br>
	<button class="" id="btn4">/ex43/sub04 get</button>
	<form action="" id="form2">
		<input type="text" name="address" placeholder="address"> <br>
		<input type="text" name="age" placeholder="age">
	</form>
<br><br>
	<button class="" id="btn5">/ex43/sub05 post</button>
<br>
	<button class="" id="btn6">/ex43/sub06 post</button>
<br>
	<button class="" id="btn7">/ex43/sub07 post</button>
<br>
	<button class="" id="btn8">/ex43/sub08 post #form2 활용</button>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
<script type="text/javascript">
	const ctx = "${pageContext.request.contextPath}";
	
	// post - form1
	document.querySelector("#btn7").addEventListener("click", function() {
	const data = new URLSearchParams(new FormData(document.forms.form1));
	
	fetch(ctx + "/ex43/sub07", {
		method : "post",
		body : data
	});
})

	// post - form2
	document.querySelector("#btn8").addEventListener("click", function() {
	const data = new URLSearchParams(new FormData(document.forms.form2));
	
	fetch(ctx + "/ex43/sub08", {
		method : "post",
		body : data
	});
})
	
	
	// body(몸통)
	document.querySelector("#btn5").addEventListener("click", function() {
		fetch(ctx + "/ex43/sub05", {
			method : "post",
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			},
			body : "address=seoul&age=43"
		});
	});

	document.querySelector("#btn6").addEventListener("click", function() {
		fetch(ctx + "/ex43/sub06", {
			method : "post",
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			},
			body : "name=turu&email=dhdfgf@dghas.net"
		});
	});
	
	// form에 있는 정보를 쿼리로(띄어쓰기 처리가능)
	document.querySelector("#btn3").addEventListener("click", function() {
		
		/* const form1 = document.querySelector("#form1"); */
		/* const formData = new FromData(from1); */
		const form1 = document.forms.form1;
		const formData = new FormData(form1);
		const data = new URLSearchParams(formData);
		
		fetch(ctx + "/ex43/sub03?" + data);
	})
	
	document.querySelector("#btn4").addEventListener("click", function() {
		const form2 = document.forms.form2;
		const formData = new FormData(form2);
		const data = new URLSearchParams(formData);
		
		fetch(ctx + "/ex43/sub04?" + data);
	})

	document.querySelector("#btn2").addEventListener("click", function() {
		fetch(ctx + "/ex43/sub02?email=odhj@gmail.com&age=72");
	});
	
	document.querySelector("#btn1").addEventListener("click", function() {
		fetch(ctx + "/ex43/sub01?name=son&address=seoul");
	});
</script>
</html>
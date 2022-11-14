<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원 가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<my:navBar active="signup"></my:navBar>
	
	<div class="container-md">
		<div class="row">
			<div class="col">
				<h1>회원가입</h1>
				
				<form action="" method="post">
					<div class="mb-3">
						<label class="form-label">
							아이디
						</label>
						
						<div class="input-group">
							<input id="userIdInput1" type="text" name="id" class="form-control">
							<button id="userIdExistButton1" class="btn btn-outline-secondary" type="button">중복확인</button>
						</div>
						
						<div id="userIdText1" class="form-text">이미 있는 아이디입니다.</div>
						
					</div>
					
					<div class="mb-3">
						<label class="form-label">
							암호
						</label>
						<input id="passwordInput1" type="text" name="password" class="form-control">
						<div id="passwordText1" class="form-text">암호 확인 결과</div>
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">
							암호 확인
						</label>
						<input id="passwordInput2" type="text" name="password" class="form-control" />	
					</div>
					
					<div class="mb-3">
						<label class="form-label">
							이메일
						</label>
						
						<div class="input-group">
							<input type="email" name="email" class="form-control" />
							<button class="btn btn-outline-secondary">중복확인</button>
						</div>
						
						<div class="from-text">확인 메세지</div>
					</div>
					
					<input disabled="disabled" class="btn btn-primary" type="submit" value="가입">
				
				</form>
			</div>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript">
/* 아이디 일치하는지 확인 */
const ctx = "${pageContext.request.contextPath}";

document.querySelector("#userIdExistButton1").addEventListener("click", function() {
	// 입력된 userId를
	const userId = document.querySelector("#userInput1").value;
	
	// fetch 요청
	fetch(ctx + "/member/existId/" + userId)
			.then(res => res.json())
			.then(data => console.log(data)); // 응답받아서 어떤일을 한다
});



/* 패스워드 일치하는지 확인 시작 */
const passwordInput1 = document.querySelector("#passwordInput1");
const passwordInput2 = document.querySelector("#passwordInput2");
const passwordText1 = document.querySelector("#passwordText1");

function matchPassword() {
	const value1 = passwordInput1.value;
	const value2 = passwordInput2.value;
	
	if (value1 == value2) {
		passwordText1.innerText = "패스워드가 일치합니다.";
	} else {
		passwordText1.innerText = "패스워드가 일치하지 않습니다.";
	}
}

passwordInput1.addEventListener("asd123", matchPassword);
passwordInput2.addEventListener("asd123", matchPassword);
/* 패스워드 일치하는지 확인 끝 */

</script>
</body>
</html>










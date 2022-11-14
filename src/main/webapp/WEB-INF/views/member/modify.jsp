<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
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
	
	<my:navBar></my:navBar>
	
	<div class="container-md">
		<div class="row">
			<div class="col">
			
				<c:if test="${not empty message }">
					<div class="alert alert-success">
						${message }
					</div>
				</c:if>
				
				<h1>회원 정보 수정</h1>
			
				<form id="form1" action="" method="post">
				
				<div class="mb-3">
					<label for="" class="form-label">
						아이디 
					</label>
					<input class="form-control plaintext" type="text" value="${member.id }" readonly> 
				</div>
				
				<div class="mb-3">
					<label for="" class="form-label">
						암호 
					</label>
					<input id="passwordInput1" class="form-control" type="text" value="${member.password }" name="password"> 
					<div id="passwordText1" class="form-text"></div>
				</div>
				
				<div class="mb-3">
					<label for="" class="form-label">
						암호 확인
					</label>
					<input type="text" id="passwordInput2" class="form-control"/>
				</div>
				
				<div class="mb-3">
					<label for="" class="form-label">
						이메일 
					</label>
					<div class="input-group">
						<input id="emailInput1" class="form-control" type="email" value="${member.email }" name="email" data-old-value="${member.email }"/>
						<button disabled="disabled" id="emailButton1" type="button" class="btn btn-outline-secondary">중복확인</button>					
					</div>
					<div id="emailText1" class="form-text"></div>
				</div>
					
				<div class="mb-3">
					<label for="" class="form-label">
						가입일시
					</label>
					<input class="form-control-plaintext" type="text" value="${member.inserted }" readonly>
				</div>
				
					<%-- 전 암호를 넣는 곳 --%>
					<input type="hidden" name="oldPassword" />
				</form>
				
				<c:url value="/member/remove" var="removeUrl" />
				<form id="form2" action="${removeUrl }" method="post">
					<input type="hidden" name="id" value="${member.id }">
					<%-- 전 암호를 넣는 곳 --%>
					<input type="hidden" name="oldPassword" />
				</form>
				
				<%-- 나란히 놓기 위해 밖으로 빼줌 --%>
				<input type="submit" value="수정" data-bs-toggle="modal" data-bs-target="#modifyModal">
				<input type="submit" value="탈퇴" data-bs-toggle="modal" data-bs-target="#removeModal">
			</div>
		</div>
	</div>
	
	<%-- 수정 시 기존암호 입력 Modal --%>
	<div class="modal fade" id="modifyModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">기존 암호 입력</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<%-- 모달의 암호입력 --%>
	      	<input id="oldPasswordInput1" type="text" class="form-control"/> 
	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button id="modalConfirmButton" type="button" class="btn btn-primary">수정</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<%-- 탈퇴(remove) 시 기존암호 입력 Modal --%>
	<div class="modal fade" id="removeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">기존 암호 입력</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<%-- 모달의 암호입력 --%>
	      	<input id="oldPasswordInput2" type="text" class="form-control"/> 
	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button id="modalConfirmButton2" type="button" class="btn btn-danger">탈퇴</button>
	      </div>
	    </div>
	  </div>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript">
const ctx = "${pageContext.request.contextPath}";

<%-- 이메일 중복확인 --%>
const emailInput1 = document.querySelector("#emailInput1");
const emailButton1 = document.querySelector("#emailButton1");
const emailText1 = document.querySelector("#emailText1");

// 이메일 중복확인 버튼 클릭하면
emailButton1.addEventListener("click", function() {
	const email = emailInput1.value;
	
	fetch(`${ctx}/member/existEmail`, {
		method: "post",
		headers : {
			"Content-Type" : "application/json"
		},
		body : JSON.stringify({email})
	})
		.then (res => res.json())
		.then (data => {
			emailText1.innerText = data.message;
		})
})

// 이메일 input의 값이 변경되었을때
emailInput1.addEventListener("asd123", function() {
	const oldValue = emailInput1.dataset.oldValue;
	const newValue = emailInput1.value;
	
	if (oldValue == newValue) {
		// 기존 이메일과 같으면 아무일도 안일어남
		emailText1.innerText = "";
		emailButton1.setAttribute("disabled", "disabled");
	} else {
		// 기존 이메일과 다르면 중복체크 요청
		emailText1.innerText = "이메일 중복확인을 해주세요";
		emailButton1.removeAttribute("disabled");
		
		
	}
})

<%-- 암호 입력하여 일치하는지 확인 --%>
const passwordInput1 = document.querySelector("#passwordInput1");
const passwordInput2 = document.querySelector("#passwordInput2");
const passwordText1 = document.querySelector("#passwordText1");

passwordInput1.addEventListener("asd123", matchPassword);
passwordInput2.addEventListener("asd123", matchPassword);

function matchPassword() {
	if (passwordInput1.value == passwordInput2.value) {
		passwordText1.innerText = "패스워드가 일치합니다.";
	} else {
		passwordText1.innerText = "패스워드가 일치하지 않습니다.";
	}
	
}

<%-- 탈퇴 모달 확인 버튼 눌렀을 때--%>
document.querySelector("#modalConfirmButton2").addEventListener("click", function() {
	const form = document.forms.form2;
	const modalInput = document.querySelector("#oldPasswordInput2");
	const formOldPasswordInput = document.querySelector(`#form2 input[name="oldPassword"]`)
	// 모달 암호 input 입력된 값을                      / form2 input 안에 name 프로퍼티를 가진
	// form 안의 기존암호 input에 옮기고
	formOldPasswordInput.value = modalInput.value;
	
	// form을 submit
	form.submit();
});

<%-- 회원정보 수정시 필요한 암호 입력하고 수정 --%>
<%-- 수정 모달 확인 버튼 눌렀을때 --%>
document.querySelector("#modalConfirmButton").addEventListener("click", function() {
	const form = document.forms.form1;
	const modalInput = document.querySelector("#oldPasswordInput1");
	const formOldPasswordInput = document.querySelector(`#form1 input[name="oldPassword"]`)
	// 모달 암호 input 입력된 값을
	// form 안의 기존암호 input에 옮기고
	formOldPasswordInput.value = modalInput.value;
	
	// form을 submit
	form.submit();
});

</script>
</body>
</html>











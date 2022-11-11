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
					아이디 <input type="text" value="${member.id }" readonly> <br>
					암호 <input type="text" value="${member.password }" name="password"> <br>
					이메일 <input type="email" value="${member.email }" name="email"> <br>
					가입일시 <input type="text" value="${member.inserted }" readonly> <br>
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











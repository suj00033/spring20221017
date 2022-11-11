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
							<input type="text" name="id" class="form-control">
							<button class="btn btn-outline-secondary" type="button">중복확인</button>
						</div>
						
						<div class="form-text">이미 있는 아이디입니다.</div>
						
					</div>
					
					<div class="mb-3">
						<label class="form-label">
							암호
						</label>
						<input type="password" name="password" class="form-control">
						<div class="form-text">암호 확인 결과</div>
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">
							암호 확인
						</label>
						<input type="password" name="password" class="form-control" />	
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
					
					<input class="btn btn-primary" type="submit" value="가입">
				
				</form>
			</div>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>










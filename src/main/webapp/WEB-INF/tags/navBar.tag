<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="active" required="false" %>

<style>
#searchTypeSelect {
	width: auto;
}
</style>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/board/list" var="listLink"></c:url>
<c:url value="/board/register" var="registerLink"></c:url>


<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">게시판</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link ${active eq 'list' ? 'active' : '' }" href="${listLink }">목록</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ${active eq 'register' ? 'active' : '' }" href="${registerLink }">작성</a>
        </li>
      </ul>
      
      <!-- 검색창 옆에 검색필터 -->
       <form action="${listLink }" class="d-flex" role="search">
      	<select name="t" id="searchTypeSelect" class="form-select">
      		<option value="all">전체</option>
      		<option value="title" ${param.t == 'title' ? 'selected' : '' }>제목</option>
      		<option value="content" ${param.t == 'content' ? 'selected' : '' }>본문</option>
      		<option value="writer" ${param.t == 'writer' ? 'selected' : '' }>작성자</option>
      	</select>

	<!-- 검색창 / input value="${param.q }"는 검색창에 검색어 남아있도록 -->
        <input value="${param.q }" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="q">
        <button class="btn btn-outline-success" type="submit">
        	<i class="fa-solid fa-magnifying-glass"></i>
        </button>
      </form>
    </div>
  </div>
</nav>
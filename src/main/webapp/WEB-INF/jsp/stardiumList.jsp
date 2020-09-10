<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>게시글 관리</title>
</head>
<body>
<div class="container">
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link active" href="/stardium">경기장</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/team">팀</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/player">선수</a>
    </li>
     </li>
      <li class="nav-item">
      <a class="nav-link" href="/teamPlayer">팀별 선수</a>
    </li>
    <li class="nav-item">
      <a class="nav-link active" href="/stardium/saveForm">경기장 등록</a>
    </li>
  </ul>
</div>
<div class="container">


  <table class="table">
    <thead>
  
      <tr>
        <th>번호</th>
        <th>경기장</th>
      </tr>
      
    </thead>
     <tbody id ="tbody">
     <c:forEach var="stardium" items = "${stardium}">
   
      <tr>
        <td>${stardium.id}</td>
        <td>${stardium.stardiumName}</td>
        <td><button class="${stardium.id} btn btn-danger btn-delete">삭제</button></td>
      </tr>
   
    </c:forEach>
     </tbody>
  </table>
</div>
</body>
<script>
let index = {
		init : function() {
			
			$(".btn-delete").on("click", ()=>{
				this.deleteById();
			});
			
		},
		
		deleteById: function() {
			let id = event.target.className.split(" ")[0];
			console.log(1, id);
			
			$.ajax({
				type:"delete",
				url: "/stardium/delete/"+id,
				dataType : "text"
			}).done((resp)=>{
				alert("삭제성공");
				location.href = "/stardium";
			}).fail((error)=>{
				alert("삭제실패");
				console.log(2, error.response);
			});
		}
}
index.init();
</script>
</html>
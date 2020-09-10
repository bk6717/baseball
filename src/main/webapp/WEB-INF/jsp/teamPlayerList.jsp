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
      <a class="nav-link " href="/stardium">경기장</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/team">팀</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/player">선수</a>
    </li>
    <li class="nav-item">
      <a class="nav-link active" href="/teamPlayer">팀별 선수</a>
    </li>
    <li class="nav-item">
      <a class="nav-link active" href="/player/saveForm">방출하기</a>
    </li>
  </ul>

</div>
<div class="container">


  <table class="table">
    <thead>
  
      <tr>
      	
        <th>ID</th>
        <th>이름</th>
        <th>소속</th>
        <th>포지션</th>
        <th>퇴출이유</th>
        <th>퇴출일</th>
         
      </tr>
    </thead>
     <tbody id ="tbody">
     <c:forEach var="player" items = "${player}">
   
        <form action="/player/outPlayer" method="post">
      <tr>
      
    
        <td>${player.id}</td>
        <td>${player.name}</td>
        <td>${player.team.name}</td>
        <td>${player.position}</td>
        <td><input type ="text" value="${player.outPlayer.reason }"></td>
        <td><input type ="date" value="${player.outPlayer.outDay }"></td>
        <td><button class="${player.id} btn btn-danger btn-delete"
        			type="submit">퇴출</button></td>
      </tr>
        </form>
   
    </c:forEach>
     </tbody>
  </table>
</div>
<script>

</script>
</html>
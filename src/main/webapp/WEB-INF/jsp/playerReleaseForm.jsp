<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>선수 퇴출 페이지</h1>
<form action="/player/outPlayer" method="post">

  <div class="input-group mb-3" >
    <div class="input-group-prepend">
      <span class="input-group-text">퇴출 사유</span>
    </div>
    <input type="text" class="form-control" name="reason">
  </div>
  <button type="submit">확인</button>
</form>
</body>
</html>
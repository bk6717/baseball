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
      <a class="nav-link" href="/stardium">경기장</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/team">팀</a>
    </li>
    <li class="nav-item">
      <a class="nav-link active" href="/player">선수</a>
    </li>
      <li class="nav-item">
      <a class="nav-link" href="/teamPlayer">팀별 선수</a>
    </li>
    <li class="nav-item">
      <a class="nav-link active" href="/player/saveForm">선수 등록</a>
    </li>
  </ul>
  <div>
  
  <c:forEach var="team" items="${team}">
   <button type="button" class="${team.id} btn btn-dark btn-lotte" onclick="">${team.name}</button>
   
  </c:forEach>
  
  
  </div>
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
   
      <tr>
    
        <td>${player.id}</td>
        <td>${player.name}</td>
        <td>${player.team.name}</td>
        <td>${player.position}</td>
        <td>${player.outPlayer.reason}</td>
        <td>${player.outPlayer.outDay }</td>
        <td><button class="${player.id} btn btn-danger btn-delete">삭제</button></td>
        
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
			
			$(".btn-lotte").on("click", ()=>{
				this.lotte();
			});
			
			
		},
		
		lotte: function() {
			
			let id = event.target.className.split(" ")[0];
			
			$.ajax({
				type : "get",
				url : "/teamPlayer/"+ id,
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				dataType : "json"
			}).done((resp)=>{
				console.log(resp);
				$("#tbody").empty();
				for(var player of resp){
					
					var data = "";
					
					if(player.outPlayer == null){
				var data = "<tr>\r\n" +
					"    \r\n" + 
					"        <td>"+player.id+"</td>\r\n" + 
					"        <td>"+player.name+"</td>\r\n" + 
					"        <td>"+player.team.name+"</td>\r\n" + 
					"        <td>"+player.position+"</td>\r\n" + 
					"        <td></td>\r\n" + 
					"        <td></td>\r\n" + 
					"        <td><button class=\""+player.id+" btn btn-danger btn-delete\">삭제</button></td>\r\n" + 
					"        \r\n" + 
					"      </tr>";
					}else{
					
						var data =	"    \r\n" + 
						"        <td>"+player.id+"</td>\r\n" + 
						"        <td>"+player.name+"</td>\r\n" + 
						"        <td>"+player.team.name+"</td>\r\n" + 
						"        <td>"+player.position+"</td>\r\n" + 
						"        <td>"+player.outPlayer.reason+"</td>\r\n" +
						"        <td>"+player.outPlayer.outday+"</td>\r\n" +
						"        <td><button class=\""+player.id+" btn btn-danger btn-delete\">삭제</button></td>\r\n" + 
						"        \r\n" + 
						"      </tr>";
						}
					$("#tbody").append(data);
					}
				
				
			}).fail((error)=>{
				alert(1, error.response);
				console.log(error.response);
			});
		},
		
		deleteById: function() {
			let id = event.target.className.split(" ")[0];
			console.log(1, id);
			
			$.ajax({
				type:"delete",
				url: "/player/delete/"+id,
				dataType : "text"
			}).done((resp)=>{
				alert("삭제성공");
				location.href = "/player";
			}).fail((error)=>{
				alert("삭제실패");
				console.log(2, error.response);
			});
		}
}
index.init();
</script>
</html>
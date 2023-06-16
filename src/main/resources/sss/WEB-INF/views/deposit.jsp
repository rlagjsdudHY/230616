<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Document</title>
		<link rel="stylesheet" href="/style/style.css">
		<style>
		
		</style>
	</head>
	<body>
		<div id="wrap">
			<h1>입출금 거래등록</h1>
			<button onclick="location.href='/list'">거래내역</button>
			<button onclick="location.href='/main'">계좌등록</button>
			<hr>
			<div>계좌번호 선택</div>
			
	<form action="/depositAmount">
		<select name="accountNumber">
		<c:forEach var="list" items="${bankList}">
			 <option >${list.accountNumber}</option>
		</c:forEach>
		</select>
	<c:forEach var="list" items="${bankList}">
		<input type="hidden" name="balance" value="${list.balance}">
	</c:forEach>
	
		<div>입금</div>
		거래액 <input type="text" name="depositAmount">
		(잔액 : )
		<button type="submit">등록</button>
		<button type="reset">취소</button>
	</form> 
	
	<hr>
	
	
	<div>계좌번호 선택</div>
	<form action="/drawalAmount">
		<select name="accountNumber">
		<c:forEach var="list" items="${bankList}">
			 <option >${list.accountNumber}</option>
		</c:forEach>
		</select>
	<c:forEach var="list" items="${bankList}">
		<input type="hidden" name="balance" value="${list.balance}">
	</c:forEach>
	
	
		<div>출금</div>
		거래액 <input type="text" name="drawalAmount">
		(잔액:  )
		<button type="submit">등록</button>
		<button type="reset">취소</button>
	</form>
		
			
		</div>	
		<!-- div#wrap -->
		<script src="/script/jquery-3.6.4.min.js"></script>
        <script src="/script/script.js"></script>	
	</body>
</html>
   
 
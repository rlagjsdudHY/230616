<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
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
			<h1>거래내역</h1>
			<button onclick="location.href='/main'">계좌등록</button>
			<button onclick="location.href='/deposit'">입출금등록</button>
			<hr>
			<div class="listHeader listColumn dFlex">
				<span>번호</span>
				<span>계좌번호</span>
				<span>입금액</span>
				<span>출금액</span>
				<span>잔액</span>
			</div>
			<c:forEach var="list" items="${bankList}" varStatus="status">
				<div class="listRow listColumn dFlex" data-link="${list.num}" >
					<span>${list.num}</span>
					<span>${list.accountNumber}</span>
					<span>${list.depositAmount}</span>
					<span>${list.drawalAmount}</span>
					<span>${list.balance }</span>
				</div>
			</c:forEach>
			
			<form action="/search" mothod="post">
				<input type="text" name="keyword" placeholder="검색어를 입력하세요">
				<button type="submit">검색</button>
			</form>
			
			
		</div>	
		<!-- div#wrap -->
		<script src="/script/jquery-3.6.4.min.js"></script>
        <script src="/script/script.js"></script>	
	</body>
</html>
   
 
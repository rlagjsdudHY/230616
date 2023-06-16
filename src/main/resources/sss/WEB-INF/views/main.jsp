<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
			<h1>신규 계좌등록</h1>
			<button onclick="location.href='/list'">거래내역</button>
			<button onclick="location.href='/deposit'">입출금등록</button>
			<hr>
		<form action="/apply">
			계좌 번호 <input type="text" name="accountNumber"><br>
			예금주 ID <input type="text" name="holderID"><br>
				<button type="submit">등록</button>		
		</form>
				<button type="text" onclick="location.href='/list'">취소</button>		
		</div>	
		<!-- div#wrap -->
		<script src="/script/jquery-3.6.4.min.js"></script>
        <script src="/script/script.js"></script>	
	</body>
</html>
   
 
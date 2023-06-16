<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" href="/style/style.css">
<style>
div#wrap {
	text-align: center;
}
</style>
</head>
<body>
	<div id="wrap">
		<h1>거래내용상세보기</h1>
		<button onclick="location.href='/deposit'">입출금등록</button>
		<button onclick="location.href='/list'">거래내역</button>
		<button onclick="location.href='/main'">계좌등록</button>
		<hr>
			<form action="/mtdModifyProc">
		<div class="listColumn ">

				 <div>계좌번호 : ${resultList.accountNumber}</div>
                     <div>입금 : ${resultList.depositAmount}</div>
                     <div>출금 : ${resultList.drawalAmount}</div>
                     <div>잔액 : ${resultList.balance }</div>
				<div>
					메모 : <input type="text" value="${resultList.memo}" name="memo">
				</div>
				<input type="hidden" name="num" value="${resultList.num}">
		</div>
				<button type="submit">수정하기</button>
		</form>
	</div>
	<!-- div#wrap -->
	<script src="/script/jquery-3.6.4.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>


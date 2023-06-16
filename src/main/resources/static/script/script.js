/**
 * 
 */
 
 $(function(){
 	// 입력 페이지
 	$("button#goInsert").click(function(){
 		location.href="/applyForm";
 	});
 	
 	// 목록 페이지
 	$("button#goList").click(function(){
 		location.href="/selList";
 	});
 	
 	// 상세내용 보기
 	$("div.listRow").click(function(){
 		let num = $(this).attr("data-link");
 		//alert("num : " + num);
 		location.href="/result?num="+num;
 	});
 	
 	// 내용 수정
 	$("button#goMod").click(function(){
 		let num = $(this).val();
 		//alert("num : "+ num );
 		location.href="/mod?num="+num;
 	});
 	
 	
 }); 
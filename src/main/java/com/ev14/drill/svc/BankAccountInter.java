package com.ev14.drill.svc;

import java.util.List;
import java.util.Map;

import com.ev14.drill.dto.BankRecordDto;

public interface BankAccountInter {

	//계좌등록
	public void accountInsert(Map<String,String> map);
	
	//목록보기
	public List<BankRecordDto> bankList();
	
	//글검색
	public List<BankRecordDto> bankSearch(String keyword);
	
	//입금처리
	public void bankDeposit(Map<String,String> map);
	//출금처리
	public void bankdrawal(Map<String,String> map);
	//글 상세보기
	public BankRecordDto bankResult(int num);
	
	//메모수정하기
	public void bankModify(String memo,String num);
	
}

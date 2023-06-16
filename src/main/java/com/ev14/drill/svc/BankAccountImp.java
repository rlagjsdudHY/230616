package com.ev14.drill.svc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ev14.drill.dao.BankAccountDao;
import com.ev14.drill.dto.BankRecordDto;

@Service
public class BankAccountImp implements BankAccountInter{

	@Autowired
	private BankAccountDao bankAccountDao;
	
	//계좌등록
	@Override
	public void accountInsert(Map<String,String> map) {
		bankAccountDao.accountInsert(map);
	}
	
	@Override //목록보기
	public List<BankRecordDto> bankList(){
		
		return bankAccountDao.bankList();
	}
	
	@Override //글검색
	public List<BankRecordDto> bankSearch(String keyword){
		
		return bankAccountDao.bankSearch(keyword);
	}
	
	@Override //입금처리
	//입금처리
		public void bankDeposit(Map<String,String> map) {
		
		  bankAccountDao.bankDeposit(map);
	}
	@Override //출금처리
	//출금처리
	public void bankdrawal(Map<String,String> map) {
		
		bankAccountDao.bankdrawal(map);
	}
	@Override //글상세보기
	//글 상세보기
		public BankRecordDto bankResult(int num) {
		
		return bankAccountDao.bankResult(num);
	}
	@Override //메모수정하기
	public void bankModify(String memo,String num) {
		bankAccountDao.bankModify(memo,num);
	}
	

}

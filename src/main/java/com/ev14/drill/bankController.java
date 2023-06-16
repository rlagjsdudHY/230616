package com.ev14.drill;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ev14.drill.dto.BankRecordDto;
import com.ev14.drill.svc.BankAccountInter;

@Controller
public class bankController {

	@Autowired
	private BankAccountInter bankAccountInter;
	
	@RequestMapping("/main") //계좌등록 겸 메인페이지
	public String mainMtd(Model model) {
		
		
		return "/main";
	}
	
	@RequestMapping("/apply") //계좌등록처리
	public String applyMtd(Model model , HttpServletRequest req) {
		
		try {
			String accountNumber = req.getParameter("accountNumber");
			String holderID =req.getParameter("holderID");
			
			Map<String,String> map = new HashMap<>();
			map.put("item1", accountNumber);
			map.put("item2", holderID);
			
			model.addAttribute(req);
			
			bankAccountInter.accountInsert(map);
		 
		} catch (Exception e) {
			e.getMessage();
		}
		
		return "redirect:/main";
	}
	
	@RequestMapping("/list") //거래내용 리스트
	public String mtdList(Model model) {
		model.addAttribute("bankList", bankAccountInter.bankList());
		return "/list";
	}
	
	@RequestMapping("/search") //거래내용 검색기능
	public String mtdSearch(Model model, HttpServletRequest req) {
			String keyword = req.getParameter("keyword");
			try {
				if(!bankAccountInter.bankSearch(keyword).isEmpty()) {
				model.addAttribute("bankList", bankAccountInter.bankSearch(keyword));
			}else if(keyword == null ||  keyword.isEmpty()) {
				model.addAttribute("bankList", bankAccountInter.bankList());
			}
			} catch (Exception e) {
				e.getMessage();
			}
		return "/list";
	}
	@RequestMapping("/deposit") //입출금페이지
	public String mtdDeposit(Model model) {
		model.addAttribute("bankList", bankAccountInter.bankList());
		return "/deposit";
	}
	
	@RequestMapping("/depositAmount") //입금처리
	public String mtdDepositProc(Model model , HttpServletRequest req) {
		try {
	String accountNumber = req.getParameter("accountNumber");//계좌
	String depositAmount = req.getParameter("depositAmount");//입금액
	String balance = req.getParameter("balance");//잔고
			
			int a = Integer.parseInt(depositAmount); //입금액
			int b = Integer.parseInt(balance); // 잔고
			int c = a+b; //입금처리
			
			String balanceA =Integer.toString(c); //최종잔고
			System.out.println(balance);
			System.out.println(balanceA);
			System.out.println(depositAmount);
			System.out.println(accountNumber);
			Map<String,String> map = new HashMap<>();
			map.put("item1", accountNumber);
			map.put("item2", depositAmount);
			map.put("item3", balanceA);
			
			
			bankAccountInter.bankDeposit(map);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		return "redirect:list";
	}
	@RequestMapping("/drawalAmount") //출금처리
	public String mtdDrawalProc(Model model , HttpServletRequest req) {
		try {
			String accountNumber = req.getParameter("accountNumber");//계좌
			String drawalAmount = req.getParameter("drawalAmount");//출금액
			String balance = req.getParameter("balance");//잔고
			
			int a = Integer.parseInt(drawalAmount); //출금액
			int b = Integer.parseInt(balance); // 잔고
			int c = b-a; //입금처리
			
			String balanceA =Integer.toString(c); //최종잔고
			System.out.println(balance);
			System.out.println(balanceA);
			System.out.println(drawalAmount);
			System.out.println(accountNumber);
			Map<String,String> map = new HashMap<>();
			map.put("item1", accountNumber);
			map.put("item2", drawalAmount);
			map.put("item3", balanceA);
			
			model.addAttribute(req);
			bankAccountInter.bankdrawal(map);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		return "redirect:list";
	}
	
	@RequestMapping("/result") //거래내용 상세보기
	public String mtdResult (Model model, HttpServletRequest req) {
		int num = Integer.parseInt(req.getParameter("num"));
		model.addAttribute("resultList", bankAccountInter.bankResult(num));
		
		return "/result";
	}
	
	@RequestMapping("/modify") //수정페이지
	public String mtdModify(Model model, HttpServletRequest req) {
		int num = Integer.parseInt(req.getParameter("num"));
		model.addAttribute("resultList",bankAccountInter.bankResult(num));
		
		return "/modify";
	}
	@RequestMapping("/mtdModifyProc") //수정하기 처리
	public String mtdModifyProc(Model model, HttpServletRequest req) {
		String memo = req.getParameter("memo");
		String num = req.getParameter("num");
		System.out.println(num);
		try {
			
			model.addAttribute(req);
			
			bankAccountInter.bankModify(memo,num);
			
		} catch (Exception e) {
			e.getMessage();
		}
		return "redirect:list";
	}
	
	
}


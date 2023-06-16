package com.ev14.drill.dto;

import lombok.Data;

@Data
public class BankRecordDto {
	private int num;
	private String accountNumber;
	private String depositAmount;
	private String drawalAmount;
	private String balance;
	private String memo;
}
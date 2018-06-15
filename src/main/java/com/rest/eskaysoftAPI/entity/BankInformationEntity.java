package com.rest.eskaysoftAPI.entity;

import java.util.List;

public class BankInformationEntity {

	private List<BankInformation> bankinformation;

	public List<BankInformation> getBankInformation() {
		return bankinformation;
	}

	public void setBankInformation(List<BankInformation> bankinformation) {
		this.bankinformation = bankinformation;
	}
}
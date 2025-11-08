package com.neub.authApi.response;

import java.util.List;

import com.neub.authApi.entitiy.CenterVaccineStock;

public class StockQueryResponse {
	private List<CenterVaccineStock> centerVaccineStockList;

	public List<CenterVaccineStock> getCenterVaccineStockList() {
		return centerVaccineStockList;
	}

	public void setCenterVaccineStockList(List<CenterVaccineStock> centerVaccineStockList) {
		this.centerVaccineStockList = centerVaccineStockList;
	}
	
	
}

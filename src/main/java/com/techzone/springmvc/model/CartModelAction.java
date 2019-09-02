package com.techzone.springmvc.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CartModelAction {

	public Long getTotal(List<ItemModel> items) {

		Long total = 0L;
		for (ItemModel i : items) {
//			total += (i.getProduct().getPrice() * i.getQuantity())
//					* ((100 - i.getProduct().getSale().getPercent()) / 100);
			float sumValuePriceProduct = (float)i.getProduct().getPrice() * (float)i.getQuantity();
			System.err.println("Sum Value Price Product : " + sumValuePriceProduct);
			float salePercentForProduct = (float)(100 - i.getProduct().getSale().getPercent()) / (float)100;
			System.err.println("sale Percent : " + salePercentForProduct);
			total += (long)(sumValuePriceProduct * salePercentForProduct);
		}
		System.err.println("Total this bill : " + total);
		return total;
	}

	public Long getRevenue(List<ItemModel> items) {
		Long revenue = 0L;
		for (ItemModel i : items) {
			revenue += i.getQuantity();
		}
		return revenue;
	}

	// change quantity

}

package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.BillInfoDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.BillInfo;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BillInfoService;

@Service
public class BillInfoServiceImpl implements BillInfoService {
	
	@Autowired
	BillInfoDao biDao;
	
	public List<BillInfo> getAll(long first, long count, String sortBy, String sortType){
		if ("sort-by-bill-id".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return biDao.getAll(first, count, "bill_id", "asc");
			} else
				return biDao.getAll(first, count, "bill_id", "desc");
		}
		if ("sort-by-payment-value".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return biDao.getAll(first, count, "payment_value", "asc");
			} else
				return biDao.getAll(first, count, "payment_value", "desc");
		}
		if ("sort-by-currency-of-payment".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return biDao.getAll(first, count, "currency_of_payment", "asc");
			} else
				return biDao.getAll(first, count, "currency_of_payment", "desc");
		}
		if ("sort-by-billing-number".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return biDao.getAll(first, count, "billing_number", "asc");
			} else
				return biDao.getAll(first, count, "billing_number", "desc");
		}
		if ("sort-by-creation-date".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return biDao.getAll(first, count, "creation_date", "asc");
			} else
				return biDao.getAll(first, count, "creation_date", "desc");
		}
		if ("sort-by-is-paid".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return biDao.getAll(first, count, "is_paid", "asc");
			} else
				return biDao.getAll(first, count, "is_paid", "desc");
		}
		if ("sort-by-first-name".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return biDao.getAll(first, count, "first_name", "asc");
			} else
				return biDao.getAll(first, count, "first_name", "desc");
		}
		if ("sort-by-last-name".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return biDao.getAll(first, count, "last_name", "asc");
			} else
				return biDao.getAll(first, count, "last_name", "desc");
		}
		if ("sort-by-email".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return biDao.getAll(first, count, "email", "asc");
			} else
				return biDao.getAll(first, count, "email", "desc");
		}
		return biDao.getAll(first, count, "bill_id", "asc");
	}
	
	public int getCount(){
		return biDao.getCount();
	}

}

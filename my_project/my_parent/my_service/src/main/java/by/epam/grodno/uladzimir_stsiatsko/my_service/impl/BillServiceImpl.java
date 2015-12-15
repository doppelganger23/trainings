package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.BillDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Bill;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	BillDao billDao;
	
	@Override
	public void addBill(Bill bill){
		billDao.insert(bill);
	}
	
	@Override
	public double countPrice (Bill bill){
		List<Double> priceParts = billDao.getPriceElements(bill);
		Double price = 0.0;
		for (Double part : priceParts){
			price+=part;
		}
		return price;
	}
}

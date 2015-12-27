package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.BankDetailDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.BankDetail;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BankDetailService;

@Service
public class BankDetailServiceImpl implements BankDetailService{
	
	@Autowired
	private BankDetailDao bdDao;
	
	@Override
	public List<BankDetail> findAll(){
		return bdDao.getAll();
	}
	
	@Override
	public List<String> findAllTypes(){
		return bdDao.getAllTypes();
	}
	
	@Override
	public double getByrExchangeRate(String currencyType){
		double result = bdDao.getByrExchangeRate(currencyType);
		if(result == 0){
			throw new IllegalArgumentException("currency type not supported");
		}
		return result;
	}
	
	@Override
	public int getBillingNumber(String currencyType){
		int result = bdDao.getBillingNumber(currencyType);
		if(result == 0){
			throw new IllegalArgumentException("currency type not supported");
		}
		return result;
	}

}

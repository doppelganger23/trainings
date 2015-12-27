package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.BankDetailDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.mapper.BankDetailMapper;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.BankDetail;

@Repository
public class BankDetailDaoImpl implements BankDetailDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<String> getAllTypes(){
		return jdbcTemplate.query("SELECT currency_of_payment FROM bank_detail;", new SingleColumnRowMapper<String>());
	}
	
	@Override
	public List<BankDetail> getAll(){
		return jdbcTemplate.query("SELECT * FROM bank_detail;", new BankDetailMapper());
	}

	//заменен на ^, удалить?
	@Override
	public double getByrExchangeRate(String currencyType) {
		Object[] args = { currencyType };
		try {
			return jdbcTemplate.queryForObject(
					"SELECT byr_exchange_rate FROM bank_detail WHERE currency_of_payment = ? ;", Double.class, args);
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}
	
	//аналогично ^
	@Override
	public int getBillingNumber(String currencyType) {
		try {
			Object[] args = { currencyType };
			Integer billingNumber = jdbcTemplate.queryForObject(
					"SELECT billing_number FROM bank_detail WHERE currency_of_payment = ? ;", Integer.class, args);
			return billingNumber;
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

}

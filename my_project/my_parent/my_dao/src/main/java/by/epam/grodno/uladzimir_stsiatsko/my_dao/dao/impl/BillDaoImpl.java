package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.BillDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Bill;

@Repository
public class BillDaoImpl implements BillDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(Bill bill) {
		jdbcTemplate.update(
				"INSERT INTO bill (passenger_id, trip_list_id, payment_value, is_paid, billing_nimber, from_block, to_block) VALUES (?,?,?,?,?,?,?);",
				bill.getPassengerId(), bill.getTripListId(), bill.getPaymentValue(), bill.isPaid(),
				bill.getBillingNumber(), bill.getFromBlock(), bill.getToBlock());
	}
	
	@Override
	public List<Double> getPriceElements(Bill bill){
		Object[] args = {bill.getTripListId(), bill.getFromBlock(), bill.getToBlock()};
		return jdbcTemplate.query("SELECT km_price*km summ FROM search_view v WHERE trip_id = ? AND block BETWEEN ? AND ? ;", args, new SingleColumnRowMapper<Double>());
	}

}

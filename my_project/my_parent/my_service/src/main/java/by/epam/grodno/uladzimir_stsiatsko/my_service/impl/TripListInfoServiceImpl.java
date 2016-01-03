package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.TripListInfoDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripListInfo;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TripListInfoService;

@Service
public class TripListInfoServiceImpl implements TripListInfoService {

	@Autowired
	TripListInfoDao tliDao;

	public List<TripListInfo> getAll(long first, long count, String sortBy, String sortType) {
		if ("sort-by-id".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return tliDao.getAll(first, count, "id", "asc");
			} else
				return tliDao.getAll(first, count, "id", "desc");
		}
		if ("sort-by-train-number".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return tliDao.getAll(first, count, "train_number", "asc");
			} else
				return tliDao.getAll(first, count, "train_number", "desc");
		}
		if ("sort-by-route-type".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return tliDao.getAll(first, count, "route_type", "asc");
			} else
				return tliDao.getAll(first, count, "route_type", "desc");
		}
		if ("sort-by-route-name".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return tliDao.getAll(first, count, "route_name", "asc");
			} else
				return tliDao.getAll(first, count, "route_name", "desc");
		}
		if ("sort-by-departure-date".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return tliDao.getAll(first, count, "departure_date", "asc");
			} else
				return tliDao.getAll(first, count, "departure_date", "desc");
		}
		if ("sort-by-tickets-sold".equals(sortBy)) {
			if ("ASCENDING".equals(sortType)) {
				return tliDao.getAll(first, count, "tickets_sold", "asc");
			} else
				return tliDao.getAll(first, count, "tickets_sold", "desc");
		}
		return tliDao.getAll(first, count, "id", "asc");
	}

	public int getCount() {
		return tliDao.getCount();
	}

}

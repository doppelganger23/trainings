package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

import java.util.Comparator;

public class BothComp implements Comparator<OfficeAcc> {

	public int compare(OfficeAcc a, OfficeAcc b){
			//сначала сравнение на основе имени
			int result = a.getName().compareTo(b.getName());
			if (result != 0){
				return result;	
			}
			//потом сравнение на основе цены
			result = a.getSinglePrice() - b.getSinglePrice();
			if (result != 0){
				return result;	
			}
			//если дошли досюда, объекты равны
			return 0;
	}
}

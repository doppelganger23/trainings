package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

import java.util.Comparator;

public class PriceComp implements Comparator<OfficeAcc>{
	
	public int compare(OfficeAcc a, OfficeAcc b){
		return a.getSinglePrice() - b.getSinglePrice();
	}

}

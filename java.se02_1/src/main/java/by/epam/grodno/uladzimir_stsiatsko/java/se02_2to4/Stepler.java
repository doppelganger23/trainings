package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

import java.util.List;
import java.util.ArrayList;

public class Stepler extends OfficeAcc implements Fixative {

	private String name = "Stepler";

	/** Default constructor (price = 35) */
	public Stepler() {
		this.setPrice(35);
		// для toString
		super.name = name + " ($" + this.getSinglePrice() + ")";
	}

	/** Return list of chosen papers */
	public List<Paper> staple(Paper... papers) {
		// создаем новый лист
		List<Paper> papersPile = new ArrayList<Paper>();
		// добавляем каждый параметр в лист
		for (Paper p : papers) {
			papersPile.add(p);
		}
		// возвращаем лист
		return papersPile;
	}

}

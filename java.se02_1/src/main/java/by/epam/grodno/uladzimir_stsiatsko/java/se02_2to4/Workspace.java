package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Workspace for collecting information about all office accessories of chosen
 * employee and counting it's total price.
 * 
 * @author Uladzimir Stsiatsko For each employee use different instance of
 *         workspace.
 */
public class Workspace {

	// список для хранения принадлежностей
	private List<OfficeAcc> AccList = new ArrayList<OfficeAcc>();

	/** Add accessory to list */
	public void add(OfficeAcc... list) {
		for (OfficeAcc a : list)
			AccList.add(a);
	}

	/** Remove accessory form list */
	public void remove(OfficeAcc a) {
		AccList.remove(a);
	}

	/** Return summary price of all accessories in the list */
	public int getSumm() {
		int summ = 0;
		for (OfficeAcc a : AccList) {
			summ += a.getTotalPrice();
		}
		return summ;
	}
	
	/**Return collection of accessories*/
	public List<OfficeAcc> getAccList(){
		return AccList;
	}
	
	/**Sort collection of accessories by accessory name*/
	public void sortByName(){
		Collections.sort(AccList, new NameComp());
	}

	/**Sort collection of accessories by accessory price*/
	public void sortByPrice(){
		Collections.sort(AccList, new PriceComp());
	}
	
	/**Sort collection of accessories by accessory name and price*/
	public void sortByBoth(){
		Collections.sort(AccList, new BothComp());
	}
}

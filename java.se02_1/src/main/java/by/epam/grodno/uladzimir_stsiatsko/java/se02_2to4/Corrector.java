package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

/**
 * Corrector for erasing text information from Paper class objects.
 * 
 * @author Uladzimir Stsiatsko
 *
 */
public class Corrector extends OfficeAcc {

	private String name = "Corrector";
	
	/** Default constructor (price = 10) */
	public Corrector() {
		this.setPrice(10);
		//для toString
		super.name = name + " ($" + this.getSinglePrice() + ")";
	}

	/** Erase information from paper */
	public void correct(Paper p) {
		p.write("[...blank space...]");
	}
	
}

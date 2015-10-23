package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

/**
 * Paper class, used in Sticker and PaperPack classes and by itself for writing,
 * reading and holding text information.
 * 
 * @author Uladzimir Stsiatsko
 *
 */
public class Paper extends OfficeAcc {

	private String name = "Paper";
	private String text = "";

	public Paper() {
		// для toString
		super.name = name + " ($" + this.getSinglePrice() + ")";
	}

	/** Write a text on a paper */
	public void write(String text) {
		this.text = text;
	}

	/** Return a text from a paper */
	public String getText() {
		return this.text;
	}
	
}

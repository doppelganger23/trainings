package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

/**
 * Sticker for making marks on accessories.
 * 
 * @author Uladzimir Stsiatsko All sticker methods are in the OfficeAcc and
 *         Paper classes. This class only overrides object toString method.
 */
public class Sticker extends Paper {

	/** Return text from parent(Paper) private field */
	@Override
	public String toString() {
		return "cтикер с надписью <<" + this.getText() + ">>";
	}
}

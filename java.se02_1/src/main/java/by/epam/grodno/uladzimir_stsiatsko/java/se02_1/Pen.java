package by.epam.grodno.uladzimir_stsiatsko.java.se02_1;

/**
 * Simple Pen emulator. Represent pen with different possible colors and prices;
 * also emulates ink shortage and mechanical faults.
 * 
 * @author Uladzimir Stsiatsko
 *
 */
public class Pen {
	// цена
	private int price = 2;
	// исправность (исправна если > 0 )
	private int condition = 2;
	// стержень
	private Rod rod;
	// состояние (вкл/выкл)
	private boolean mode;

	/** Default constructor */
	public Pen() {
		this.rod = new Rod();
	}

	/** Constructor with color */
	public Pen(String color) {
		this.rod = new Rod(color);
	}

	/** Constructor with price */
	public Pen(int price) {
		this.rod = new Rod();
		this.price = price;
		this.condition = price;
	}

	/** Constructor with color and price */
	public Pen(String color, int price) {
		this.rod = new Rod(color);
		this.price = price;
		this.condition = price;
	}

	/**
	 * Turn on the pen. Turn it on before first use! Carefully, don't break it!
	 */

	public void setOn() {
		mode = true;
		// портим ручку
		condition--;
	}

	/** Turn off the pen. Carefully. don't break it! */
	public void setOff() {
		mode = false;
		// портим ручку
		condition--;
	}

	/**
	 * Write a text. If this isn't working, check a pen mode, condition and rod
	 * ink capacity.
	 */
	public void write(String someText) {

		// проверка на способность писать
		if (mode && (rod.getInk() > 0) && (condition > 0)) {

			// пишем
			System.out.println(someText);

			// теряем чернила
			rod.looseInk();
		} else {
			System.out.println("[...ручка не пишет...]");
		}
	}

	/** Refill a pen with a new rod */
	public void refill() {
		this.rod = new Rod();
	}

	/** Refill a pen with a rod of particular color */
	public void refill(String color) {
		this.rod = new Rod(color);
	}

	/** Hashcode - only price and rod color counts */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rod == null) ? 0 : rod.hashCode());
		return result;
	}

	/** Equals - only price and rod color counts */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pen)) {
			return false;
		}
		Pen other = (Pen) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		if (rod == null) {
			if (other.rod != null) {
				return false;
			}
		} else if (!rod.equals(other.rod)) {
			return false;
		}
		return true;
	}

}

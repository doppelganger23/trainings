package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

import java.util.List;
import java.util.ArrayList;

/**
 * Common parent for all Office accessory classes
 * 
 * @author Uladzimir Stsiatsko
 *
 */
public abstract class OfficeAcc {

	protected String name = "OfficeAcc";
	private int price = 1;
	private int quantity = 1;

	// список приклеенных к объекту стикеров
	private List<Sticker> stickers = new ArrayList<Sticker>();

	// для подсчета стоимости в коллекции
	/** Returns total price (considering quantity) of current accessory */
	public int getTotalPrice() {
		return this.price * this.quantity;
	}
	
	//для компаратора
	public String getName(){
		return name;
	}
	
	// геттер и сеттер цены:

	/** Set price of a single accessory of chosen type */
	public void setPrice(int price) {
		this.price = price;
	}

	/** Return current price of a single accessory of chosen type */
	public int getSinglePrice() {
		return this.price;
	}

	// геттер и сеттер количества:

	/** Set quantity of chosen accessories */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/** Return current quantity of chosen accessories */
	public int getQuantity() {
		return quantity;
	}

	// методы работы со стикерами:

	/** Print all sticker messages in console */
	public void readStickedMessages() {
		for (Sticker s : stickers)
			System.out.println(s.toString());
	}

	/** Add existing sticker to the accessory */
	public void addSticker(Sticker sticker) {
		stickers.add(sticker);
	}

	/** Remove specified sticker from accessory */
	public void removeSticker(Sticker sticker) {
		if (stickers.contains(sticker)) {
			stickers.remove(sticker);
		} else {
			System.out.println("Sticker not found!");
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}

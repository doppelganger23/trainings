package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

/**
 * PaperPack which contains 40 Papers. Return links to a Paper objects.
 * 
 * @author Uladzimir Stsiatsko
 *
 */
public class PaperPack extends OfficeAcc {

	private String name = "PaperPack";

	// массив, хранящий бумажки
	private Paper[] pack = new Paper[40];

	// количество оставшихся (неиспользованных) листов в пачке
	private int hasPapers = 40;

	/** Default constructor (price = 40) */
	public PaperPack() {
		// задаем дефолтное значение цены (родительское поле)
		this.setPrice(40);
		// пробегаем по массиву и инициализируем его элементы
		for (int i = 0; i < 40; i++) {
			pack[i] = new Paper();
		}
		// для toString
		super.name = name + " ($" + this.getSinglePrice() + ")";
	}

	/**
	 * Return link to new Paper object from a pack each time method is called.
	 * If there is nothing left in current pack, reserve pack is opened.
	 */
	public Paper getPaper() {
		// если бумажек не осталось, вскроем запасной пак и дадим оттуда
		if (hasPapers == 0) {
			System.out.println("Running out of papers, this one is got from reserve pack!");
			PaperPack reserve = new PaperPack();
			return reserve.getPaper();
		}
		// апдейтим количество бумажек
		hasPapers--;
		// выдаем последнюю бумажку
		return pack[hasPapers];
	}

	/** Print information about remaining papers */
	public void countPapers() {
		System.out.println(hasPapers + " papers left.");
	}
	
}

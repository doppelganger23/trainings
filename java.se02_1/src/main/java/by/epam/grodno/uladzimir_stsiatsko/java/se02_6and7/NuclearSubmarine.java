package by.epam.grodno.uladzimir_stsiatsko.java.se02_6and7;


@specialNote (startNote =  "You need to manually start submarine engine ", stopNote = "Engine shuts down automatically")
public class NuclearSubmarine {

	/**
	 * Submarine with nuclear engine, be carefull using it!
	 * 
	 * @author Uladzimir Stsiatsko
	 * 
	 */
	private NuclearEngine heart = new NuclearEngine();

	/** Start submarine voyage */
	
	public void start() {
		if (heart.engineReady) {
			System.out.println("Стартуем!");
		} else {
			System.out.println("Нужно подготовить двигатель к плаванию");
		}
	}

	/** Stop submarine from moving */
	//@specialNote (startNote =  "You need to manually start submarine engine first", stopNote = "Engine shuts down automatically")
	public void stop() {
		if (!heart.engineReady) {
			System.out.println("Спокойствие! Мы уже остановились...");
		} else {
			this.prepareEngine();
		}
	}

	/** Start submarine engine of shut it down */
	public void prepareEngine() {
		heart.getReady();
	}

	private class NuclearEngine {

		private boolean engineReady;

		private void getReady() {

			if (engineReady == true) {

				engineReady = false;
				System.out.println("Двигатель остановлен");

			} else {

				engineReady = true;
				System.out.println("Двигатель запущен");

			}
		}

	}

}

package by.epam.grodno.uladzimir_stsiatsko.java.se03_1;

public class Main {

	public static void main(String[] args) {
		
		CrazyLogger logger = new CrazyLogger();
		
		logger.showInfo();
		logger.log();
		logger.askForSearch();
		logger.askForPrint();
		logger.quit();
	}

}

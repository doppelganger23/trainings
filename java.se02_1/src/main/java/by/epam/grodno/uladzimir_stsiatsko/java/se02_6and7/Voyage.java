package by.epam.grodno.uladzimir_stsiatsko.java.se02_6and7;

public class Voyage {

	public static void main(String[] args) {
		NuclearSubmarine leviaphan = new NuclearSubmarine();
		leviaphan.start();
		
		leviaphan.prepareEngine();
		leviaphan.start();
		
		leviaphan.stop();
		leviaphan.stop();

	}

}

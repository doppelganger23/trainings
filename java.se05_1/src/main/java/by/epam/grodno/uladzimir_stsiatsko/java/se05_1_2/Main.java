package by.epam.grodno.uladzimir_stsiatsko.java.se05_1_2;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		ExcPropertyLoader loader = new ExcPropertyLoader();
		loader.load(".", "CaesarCipher");
		System.out.println(loader.getValue("a") + loader.getValue("b"));

	}

}

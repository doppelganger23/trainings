package by.epam.grodno.uladzimir_stsiatsko.java.se05_1_2;

import java.util.Scanner;

public class Decoder {

	private PropertyLoader prop = new PropertyLoader();
	private Scanner scan;

	//точка входа
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Decoder decoder = new Decoder();
			decoder.scan = sc;
			decoder.loadKeyFile();
			decoder.decode();
		}
	}

	//загружает файл с ключами к шифру
	public void loadKeyFile() {
		System.out.println("Enter path to the file");
		if (!prop.load(scan.nextLine())) {
			loadKeyFile();
		}
	}

	//расшифровывает заданный текст на основе файла с ключами
	public void decode() {
		System.out.println("Enter encrypted message");
		String encrText = scan.nextLine();

		char[] cryptArray = encrText.toCharArray();
		StringBuilder builder = new StringBuilder("Decoded message:\n");
		for (char c : cryptArray) {
			// поочередно декодируем и записываем каждый символ
			builder.append(prop.getValue(String.valueOf(c)));
		}
		System.out.println(builder.toString());
	}
}

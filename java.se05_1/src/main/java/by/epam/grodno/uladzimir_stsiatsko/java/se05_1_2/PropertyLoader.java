package by.epam.grodno.uladzimir_stsiatsko.java.se05_1_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//обрабатывает все исключительные ситуации самостоятельно,
//чтобы не прерывать работу вызывавшей программы
public class PropertyLoader {

	private Properties prop = new Properties();
	
	//при некорректной работе возвращает false,
	//чтобы вызов мог быть повторен с другим параметром
	public boolean load(String pathToFile) {
		try (FileInputStream in = new FileInputStream(pathToFile)) {
			prop.load(in);
			return true;
		} catch (FileNotFoundException fnf) {
			System.out.println("File not found");
			return false;
		} catch (IOException io) {
			io.printStackTrace();
			return false;
		}
	}

	//при некорректной расшифровке ключа помечает его символом [?]
	public String getValue(String key) {
		String value = prop.getProperty(key);
		if (value == null) {
			return "[?]";
		}
		return value;
	}
}

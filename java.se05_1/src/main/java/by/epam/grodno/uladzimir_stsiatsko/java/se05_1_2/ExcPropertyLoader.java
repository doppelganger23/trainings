package by.epam.grodno.uladzimir_stsiatsko.java.se05_1_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//выбрасывает исключения в некорректных ситуациях,
//чтобы использующая класс программа знала, что пошло не так
public class ExcPropertyLoader {
	
	private Properties prop = new Properties();

	//читаем из файла в Hashtable класса Properties
	public void load(String dirName, String fileName) throws FileNotFoundException, IOException {
		File path = new File(dirName);
		File propFile = new File(path, fileName + ".properties");
		try (FileInputStream in = new FileInputStream(propFile)) {
			prop.load(in);
		} 
	}
	
	//получаем значение по ключу из Hashtable класса Properties
	public String getValue(String key) throws IOException{
			if (!prop.containsKey(key)){
				throw new IOException("key '" + key + "' not found");
			}
			String value = prop.getProperty(key);
			
			if (value.equals("")){
				throw new IOException("no value for key '" + key + "' found");
			}
			return value;
	}

}

package by.epam.grodno.uladzimir_stsiatsko.java.se06_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//самописный класс для загрузки property-файлов в Map 
public class CustomPropertyLoader {

	//место хранения ключей и значений из property-файла
	private Map<String, String> propMap = new LinkedHashMap<>();
	//промежуточное хранилище
	private StringTokenizer st;
	
	//демонстрация работы
	public static void main(String[] args) {
		CustomPropertyLoader cpl = new CustomPropertyLoader();
		cpl.load("./p.txt");
		System.out.println(cpl.propMap);
		System.out.println(cpl.getValue("a"));
	}
	
	//считывает property-файл в StringTokenizer
	public void load(String path){
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
			// посимвольно считываем файл в стрингбилдер
			StringBuilder builder = new StringBuilder();
			int symbol = reader.read();
			
			while (symbol != -1) { //пока не кончатся символы
				//конвертируем, закидываем
				char c = (char)symbol;
				builder.append(c);
				//и подгружаем следующий
				symbol = reader.read();
			}

			// передаем считанный файл с указанием разделителя в поле
			st = new StringTokenizer(builder.toString(), "\n");
			// вызываем метод обработки строки
			convertToMap();
		} catch (FileNotFoundException e) {
			System.out.println("incorrect path to property file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//преобразует строку из Tokenizer-а в набор ключей и значений
	private void convertToMap() {
		//создаем промежуточный лист для строк
		List<String> propList = new ArrayList<>();
		//загружаем в него строки
		while (st.hasMoreTokens()) {//разделитель задан в load()
			propList.add(st.nextToken());
		}
		//работаем с каждой строкой
		propList.forEach(line -> {
			String key;
			String value;
			//на этот раз делим знаком =
			st = new StringTokenizer(line, "=");
			key = st.nextToken();
			//если есть значение в property-файле, пишем его
			if (st.hasMoreTokens()) {
				value = st.nextToken();
				propMap.put(key, value);
			} else { //если нет, то помечаем его отсутствие
				propMap.put(key, "[no value]");
			}
		});
	}

	//получить значение по ключу из Map-а
	public String getValue(String key) {
		return propMap.get(key);
	}

}

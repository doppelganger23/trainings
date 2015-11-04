package by.epam.grodno.uladzimir_stsiatsko.java.se04_1_1to3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Для корректной работы программе требуется файл "source.java", размещенный в
 * корневом каталоге проекта. Кодировка файла должна соответствовать кодировке
 * системы по-умолчанию. В данном случае используется файл с кодировкой UTF-8.
 */
public class Main_symbol {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = null;
		FileWriter out = null;

		try {
			// задаем путь к файлу в поток ввода
			reader = new BufferedReader(new FileReader("./source.java"));

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

			// готовимся пилить строку
			StringTokenizer st = new StringTokenizer(builder.toString());
			// ключ - слово, значение - количество вхождений
			Map<String, Integer> myMap = new TreeMap<String, Integer>();

			// работаем с каждым словом поочередно
			while (st.hasMoreTokens()) {

				String myWord = st.nextToken();

				// проверка на соответствие ключевым словам
				if (!Keywords.contains(myWord)) {
					continue;
				}

				// помещаем в мэп, считая вхождения
				if (!myMap.containsKey(myWord)) {
					myMap.put(myWord, 1);
				} else {
					int quantity = myMap.get(myWord);
					myMap.replace(myWord, quantity + 1);
				}
			}

			// готовимся делать вывод в файл
			out = new FileWriter("./result_s.txt");

			// конвертируем информацию по цепочке мэп->строка->файл
			out.write(myMap.toString());

		}
		// закрываем потоки
		finally {
			if (reader != null) {
				reader.close();
			}
			if (out != null) {
				out.close();
			}
		}

	}
}

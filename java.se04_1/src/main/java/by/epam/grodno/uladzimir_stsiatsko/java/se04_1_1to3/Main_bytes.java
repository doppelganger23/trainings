package by.epam.grodno.uladzimir_stsiatsko.java.se04_1_1to3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Для корректной работы программе требуется файл "source.java", размещенный в корневом каталоге проекта.
 * Кодировка файла должна соответствовать кодировке системы по-умолчанию.
 * В данном случае используется файл с кодировкой UTF-8.
 * */
public class Main_bytes {

	public static void main(String[] args) throws IOException{

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			// задаем путь к файлу в поток ввода
			in = new FileInputStream("./source.java");

			// считываем файл в массив байтов
			byte[] bytes = new byte[in.available()];
			in.read(bytes);

			//готовимся пилить строку
			StringTokenizer st = new StringTokenizer(new String(bytes));
			//ключ - слово, значение - количество вхождений
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
					int quantity = myMap.get(myWord);//получаем количество вхождений
					myMap.replace(myWord, quantity + 1);//и инкрементируем его
				}
			}

			// готовимся делать вывод в файл
			out = new FileOutputStream("./result_b.txt");

			// конвертируем информацию по цепочке мэп->строка->байты->файл
			out.write(myMap.toString().getBytes());
			
		}
		// закрываем потоки
		finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
		
	}
}

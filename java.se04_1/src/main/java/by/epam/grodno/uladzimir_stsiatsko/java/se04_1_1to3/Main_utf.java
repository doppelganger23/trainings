package by.epam.grodno.uladzimir_stsiatsko.java.se04_1_1to3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_utf {

	public static void main(String[] args) throws IOException{

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			// задаем путь к файлу в поток ввода
			in = new FileInputStream("./utf8.txt");

			// считываем файл в массив байтов
			byte[] bytes = new byte[in.available()];
			in.read(bytes);

			//перегоняем в строку для смены кодировки
			String myText = new String(bytes, "utf-8");
			
			// готовимся делать вывод в файл
			out = new FileOutputStream("./utf16.txt");

			// конвертируем в utf-16 и пишем
			out.write(myText.getBytes("utf-16"));
			
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

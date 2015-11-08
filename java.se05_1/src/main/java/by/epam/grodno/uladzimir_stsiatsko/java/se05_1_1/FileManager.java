package by.epam.grodno.uladzimir_stsiatsko.java.se05_1_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	// для возврата после обработки ошибок
	private File prevDir;
	// вызовы добавлены для корректной работы перехода к внешней директории
	// (иначе первый раз остается в текущей)
	private File curDir = new File(".").getAbsoluteFile().getParentFile();
	private File curFile;
	private StringBuilder fileText;

	public File getCurDir() {
		return curDir;
	}

	// чтение текста из файла
	public void readFile(String fileName) {
		curFile = new File(curDir, fileName);
		if (curFile.exists() && curFile.canRead()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(curFile))) {

				fileText = new StringBuilder();
				int symbol = reader.read();
				while (symbol != -1) { // пока не кончатся символы
					// конвертируем, закидываем
					char c = (char) symbol;
					fileText.append(c);
					// и подгружаем следующий
					symbol = reader.read();
				}

			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(fileText);
		} else {
			System.out.println("Such file not exists or you don't have permissions to read it");
		}
	}

	// дозапись текста в файл
	public void writeToFile(String fileName, String text) {
		curFile = new File(curDir, fileName);
		if (curFile.exists() && curFile.canRead() && curFile.canWrite()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(curFile))) {

				fileText = new StringBuilder();
				int symbol = reader.read();

				while (symbol != -1) { // пока не кончатся символы
					// конвертируем, закидываем
					char c = (char) symbol;
					fileText.append(c);
					// и подгружаем следующий
					symbol = reader.read();
				} // считали весь файл
					// и дописали в него текст
				fileText.append(text);
				fileText.append("\n");

			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			} catch (IOException e) {
				e.printStackTrace();
			}

			try (FileWriter writer = new FileWriter(curFile)) {
				// перезаписываем файл суммарной информацией
				writer.write(fileText.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Such file not exists or you don't have permissions to modify it");
		}
	}

	// переходит в другую директорию
	public void moveTo(File newDir) {
		prevDir = curDir;
		curDir = newDir; // переместились

		if (!curDir.isDirectory()) {
			if (curDir.isFile()) {
				System.out.println("It's a file, not a directory!");
			} else {
				System.out.println("No such directory!");
			}
			curDir = prevDir;// переместились обратно
		}
		
	}// отобразилась новая директория

	// смещается на директорию выше
	public void outerDir() {
		if (curDir.getParentFile() != null) {
			moveTo(curDir.getParentFile());
		}
	}

	// показывает текущую директорию
	public void showDir() {
		try {
			System.out.println("Current directory: " + curDir.getCanonicalPath().toString());
		} catch (IOException io) {
			io.getMessage();
			io.printStackTrace();
		}
	}

	// показывает файлы в текущей директории
	public void showFiles() {
		System.out.println("_____________________\nEmbedded directories:\n_____________________");
		for (File f : curDir.listFiles()){
			if(f.isDirectory()){
				System.out.println(f.getName());
			}
		}
		System.out.println("_____________________\nEmbedded files:\n_____________________");
		for (File f : curDir.listFiles()){
			if(f.isFile()){
				System.out.println(f.getName());
			}
		}
	}

	// создает новый файл с указанным именем
	public void makeNewFile(String filename) {
		curFile = new File(curDir, filename);

		if (curFile.exists()) {
			System.out.println("File with that name allready exists");
		}

		try {
			curFile.createNewFile();
		} catch (IOException io) {
			io.getMessage();
		}
	}

	// удаляет файл с указанным именем
	public void deleteFile(String name) {
		curFile = new File(curDir, name);
		if (curFile.exists()) {
			curFile.delete();
		} else {
			System.out.println("There is no such file in this directory");
		}
	}
}

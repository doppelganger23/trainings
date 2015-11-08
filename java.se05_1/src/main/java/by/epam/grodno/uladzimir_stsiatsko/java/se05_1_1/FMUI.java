package by.epam.grodno.uladzimir_stsiatsko.java.se05_1_1;

import java.io.File;
import java.util.Scanner;

public class FMUI {

	private boolean isWorking = true; // для повторного показа меню
	private String options = "Press:\n"
			+ " - 'S' to show files and subdirectories;\n\n"
			+ " - 'E' to enter subdirectory;\n"
			+ " - 'O' to move to outer directory;\n"
			+ " - 'C' to change directory;\n\n"
			+ " - 'M' to make new file;\n"
			+ " - 'W' to write to the file;\n"
			+ " - 'R' to read file;\n"
			+ " - 'D' to delete file;\n\n"	
			+ " - 'Q' to quit program ";
	private String input; // ввод пользователя

	private FileManager fm;
	private Scanner scan;

	//точка входа
	public static void main(String[] args) {
		FMUI ui = new FMUI();
		ui.init();
	}

	// инициализация программы
	public void init() {
		try (Scanner scanner = new Scanner(System.in)) {
			scan = scanner;
			fm = new FileManager();
			showMenu();
		}
	}

	// главное меню программы
	public void showMenu() {
		System.out.println("--------------------------------------------------");
		fm.showDir();
		System.out.println(options);
		input = scan.nextLine().toUpperCase();

		// разбор команд
		switch (input) {
		case "C":
			changeDir();
			break;
		case "D":
			delFile();
			break;
		case "M":
			makeFile();
			break;
		case "E":
			subDir();
			break;
		case "O":
			fm.outerDir();
			break;
		case "R":
			readFile();
			break;
		case "S":
			fm.showFiles();
			break;
		case "W":
			addText();
			break;
		case "Q":
			quit();
			break;
		default:
			System.out.println("Wrong command!");
			break;
		}

		// возврат в главное меню после отработки всех операций
		if (isWorking) {
			showMenu();
		}
		// иначе обратно по стеку вызовов к завершению работы
	}

	//создать файл в текущей директории
	private void makeFile() {
		System.out.println("Input new file name");
		input = scan.nextLine();
		fm.makeNewFile(input);
	}

	//прочитать файл из текущей директории
	private void readFile(){
		System.out.println("Input name of file from this directory");
		input = scan.nextLine();
		fm.readFile(input);
	}
	
	//дозапись текста в файл
	private void addText(){
		System.out.println("Input name of file you want to modify");
		input = scan.nextLine();
		System.out.println("Input text you want to add to the file");
		String input2 = scan.nextLine();
		fm.writeToFile(input, input2);
	}
	
	//удаление файла
	private void delFile() {
		System.out.println("Input name of file you want to delete");
		input = scan.nextLine();
		fm.deleteFile(input);
	}

	//переход к директории по полному пути
	private void changeDir() {
		System.out.println("Input absolute path to the directory");
		input = scan.nextLine();
		fm.moveTo(new File(input));
	}

	//переход к вложенной директории
	private void subDir() {
		System.out.println("Input directory name");
		input = scan.nextLine();
		fm.moveTo(new File(fm.getCurDir(), input));
	}

	//выход из программы
	public void quit() {
		isWorking = false;
	}
}

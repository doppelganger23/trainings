package by.epam.grodno.uladzimir_stsiatsko.java.se03_1_2;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Loader class which operates resources.
 * Uses console UI.
 * @author Uladzimir Stsiatsko
 *
 */
public class Loader {
	private ResourceBundle qBundle; // вопросы
	private ResourceBundle aBundle; // ответы
	private ResourceBundle mBundle; // сообщения
	// сканер и переменная, хранящая ответы
	private Scanner scan = new Scanner(System.in);
	private String symbol;
	// локаль
	private Locale currentLocale;

	/** Launches program user interface in console */
	public void init() {
		System.out.println("Choose Locale(en_EN/ru_RU):\nPress E for English, R for Russian");
		// сканируем ответ
		symbol = scan.nextLine();
		// не принимаем неправильные символы
		while (!(symbol.equalsIgnoreCase("E") || symbol.equalsIgnoreCase("R"))) {
			symbol = scan.nextLine();
		}
		// задаем локаль
		if (symbol.equalsIgnoreCase("E")) {
			currentLocale = new Locale("en", "US");
		} else {
			currentLocale = new Locale("ru", "RU");
		}
		// определяем локаль для каждой ResourceBundle
		qBundle = ResourceBundle.getBundle("by.epam.grodno.uladzimir_stsiatsko.java.se03_1_2.QBundle", currentLocale);
		aBundle = ResourceBundle.getBundle("by.epam.grodno.uladzimir_stsiatsko.java.se03_1_2.ABundle", currentLocale);
		mBundle = ResourceBundle.getBundle("by.epam.grodno.uladzimir_stsiatsko.java.se03_1_2.MBundle", currentLocale);
		// переходим к списку вопросов
		this.showQuestions();
	}

	// список вопросов + диалоговое меню
	private void showQuestions() {
		// просим пользователя ввести номер вопроса
		System.out.println(mBundle.getObject("QHeader"));
		System.out.println("----------");

		// выводим список вопросов (ключ-номер_вопроса тчк значение-вопрос),
		qBundle.keySet().forEach(k -> System.out.println(k + ". " + qBundle.getObject(k)));
		// сканируем запрос пользователя
		symbol = scan.nextLine();
		// не принимаем неправильные символы
		while (!(symbol.equalsIgnoreCase("1") || symbol.equalsIgnoreCase("2") || symbol.equalsIgnoreCase("3")
				|| symbol.equalsIgnoreCase("Q"))) {
			symbol = scan.nextLine();
		}

		// разбираем варианты ответов и передаем их как ключ далее
		if (symbol.equalsIgnoreCase("1")) {
			this.showAnswer("1");
		} else if (symbol.equalsIgnoreCase("2")) {
			this.showAnswer("2");
		} else if (symbol.equalsIgnoreCase("3")) {
			this.showAnswer("3");
		}
		// ну, или выходим
		else {
			this.quit();
		}
	}

	// ответ на вопрос + диалоговое меню
	private void showAnswer(String number) {
		System.out.println("----------");
		// заголовок ответа
		System.out.println(mBundle.getObject("AHeader"));
		// ответ
		System.out.println(aBundle.getObject(number) + "\n"); 
		// запрос дальнейших действий
		System.out.println(mBundle.getObject("Return")); 

		// сканируем ответ пользователя
		symbol = scan.nextLine();
		// не принимаем неправильные символы
		while (!(symbol.equalsIgnoreCase("R") || symbol.equalsIgnoreCase("Q"))) {
			symbol = scan.nextLine();
		}

		// выполняем запрос пользователя
		if (symbol.equalsIgnoreCase("R")) {
			this.showQuestions();
		} else {
			this.quit();
		}
	}

	// выход из программы
	private void quit() {
		System.out.println("----------");
		System.out.println(mBundle.getObject("Quit"));
		scan.close();
	}
}

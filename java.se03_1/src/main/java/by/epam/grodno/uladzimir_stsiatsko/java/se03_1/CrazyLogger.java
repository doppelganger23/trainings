package by.epam.grodno.uladzimir_stsiatsko.java.se03_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Crazy Logger. Can log your messages with dates and search one by text
 * fragment.
 * 
 * @author Uladzimir Stsiatsko
 *
 *         There is 2 implementation of logging process, first use TreeMap while
 *         second use StringBuilder. First implementation is preferred because
 *         of suitable search tool, while second exists only because task
 *         conditions require to use StringBuilder.
 */
public class CrazyLogger {
	// для использования в приватном методе find, не может быть локальной
	private String searchResult = "";
	// лог в виде TreeMap
	private Map<Date, String> log = new TreeMap<Date, String>();
	// лог в виде String (для StringBuilder-а)
	private String logfile = "";

	// тулзы логгера
	private Scanner scan = new Scanner(System.in);
	private StringBuilder builder = new StringBuilder();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy : hh-mm");

	/** Start logging user messages (using both TreeMap and StringBuilder) */
	public void log() {
		String messageText = "";
		String formatedDate = "";
		Date pureDate = null;

		// бесконечный цикл, выход при помощи break
		while (true) {

			System.out.println("Input log message");
			// Сохраняем введенную строку и дату ввода
			messageText = scan.nextLine();
			pureDate = new Date();// для мэпа (нужна разница в милисекундах)
			formatedDate = sdf.format(pureDate);

			// делаем запись в формате логфайла
			// (через StringBuilder)
			builder.append(String.format("%s - %s;\n", formatedDate, messageText));
			// (то же через TreeMap)
			log.put(pureDate, messageText);

			System.out.println("Do you have another message? (y/n)");
			// Считываем ответ в формате (y/n),
			String symbol = scan.nextLine();
			// не принимая неверные символы.
			while (!(symbol.equalsIgnoreCase("y") || symbol.equalsIgnoreCase("n"))) {
				symbol = scan.nextLine();
			}

			if (symbol.equalsIgnoreCase("y")) {
				// Повторно прогоняем весь цикл логгирования
				continue;
			} else {
				// или выходим из цикла.
				System.out.println("All messages succesfully logged.");
				break;
			}
		}

		// Дописываем накопленную билдером информацию в стринговый лог файл.
		logfile += builder.toString();
	}

	/** Print messages logged using TreeMap */
	public void printMapLog() {
		// для каждого ключа в множестве ключей из мэпа лога
		log.keySet().forEach(k ->
		// распечатать ключ и соответствующее ему в мэпе значение
		System.out.println(sdf.format(k) + " - " + log.get(k) + ";"));
	}

	/** Print messages logged using StringBuilder */
	public void printStringLog() {
		System.out.println(logfile);
	}

	// интерфейс поиска для пользователя, делегирует выполнение самого поиска
	// методу find (для удобочитаемости)
	/** Search messages logged in TreeMap for given Char sequence */
	public void search() {
		System.out.println("Input search quiery");
		String quiery = scan.nextLine();
		this.find(quiery);
		System.out.println("This messages matches your quiery:\n" + searchResult);

		System.out.println("Search something else? (y/n)");
		// Считываем ответ в формате (y/n),
		String symbol = scan.nextLine();
		// не принимая неверные символы.
		while (!(symbol.equalsIgnoreCase("y") || symbol.equalsIgnoreCase("n"))) {
			symbol = scan.nextLine();
		}

		if (symbol.equalsIgnoreCase("y")) {
			searchResult = "";
			this.search();
		}
	}

	// непосредственная реализация поиска по TreeMap
	private String find(String quiery) {

		// для каждого ключа в мэпе
		// если соответствующее значение содержит в себе запрос
		// сохранить пару ключ-значение в виде строки в нужном формате
		log.keySet().forEach(k -> {
			if (log.get(k).contains(quiery)) {
				searchResult += String.format("%s - %s;\n", sdf.format(k), log.get(k));
			}
		});
		return searchResult;
	}

	/** Quit the program correctly */
	public void quit() {
		scan.close();
		System.out.println("Goodbye!");
	}

	// для демонстрации
	public void showInfo() {
		System.out.println(
				"Hi!\n I am Crazy Logger!\n I can log all your messages and find some of them later, if you will need.\n Let me prove this:\n-----------------------------------------");
	}

	// для демонстрации
	public void askForSearch() {
		System.out.println("Proceed to search? (y/n)");
		// Считываем ответ в формате (y/n),
		String symbol = scan.nextLine();
		// не принимая неверные символы.
		while (!(symbol.equalsIgnoreCase("y") || symbol.equalsIgnoreCase("n"))) {
			symbol = scan.nextLine();
		}

		if (symbol.equalsIgnoreCase("y")) {
			this.search();
		}
	}

	// для демонстрации
	public void askForPrint() {
		System.out.println("Print all log (y/n)?");
		// Считываем ответ в формате (y/n),
		String symbol = scan.nextLine();
		// не принимая неверные символы.
		while (!(symbol.equalsIgnoreCase("y") || symbol.equalsIgnoreCase("n"))) {
			symbol = scan.nextLine();
		}

		if (symbol.equalsIgnoreCase("y")) {
			// Выводим весь лог
			this.printMapLog();
		}
	}
}

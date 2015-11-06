package by.epam.grodno.uladzimir_stsiatsko.java.se04_1_4;

import java.util.Scanner;

public class CollectionMenu {

	private Scanner scan;
	private FilmCollectionHandler handler = new FilmCollectionHandler();

	private String options = "Press:\n - 'L' to Load existing film collection\n - 'S' to Save collection\n - 'O' to Show current collection\n - 'D' to Delete films from the collection\n - 'A' to Add film to the collection\n - 'E' to Edit film credits\n - 'Q' to Quit program";
	private String symbol;// ответ пользователя
	private boolean isQuitting;// флаг

	// точка входа
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			CollectionMenu menu = new CollectionMenu();
			menu.setScanner(scanner);
			System.out.println("Working with new collection by default.");
			menu.showOptionScreen();
		}
	}

	// задаем сканер
	public void setScanner(Scanner s){
		this.scan = s;
	}
	
	// загрузка главного меню
	//с переходами к остальным
	private void showOptionScreen() {
		System.out.println("------------------------------------------------------------------------");

		System.out.println(options);
		symbol = scan.nextLine().toUpperCase();

		// проверка на допустимые символы
		while (!(symbol.equals("L") || symbol.equals("S") || symbol.equals("O") || symbol.equals("D")
				|| symbol.equals("A") || symbol.equals("E") || symbol.equals("Q"))) {
			symbol = scan.nextLine().toUpperCase();
		}

		// разбор команд
		switch (symbol) {
		case "L":
			this.toLoadScreen();
			break;
		case "S":
			this.toSaveScreen();
			break;
		case "O":
			handler.showCollection();
			this.showOptionScreen();
			break;
		case "D":
			this.toDeleteFilmScreen();
			break;
		case "A":
			this.toAddFilmScreen();
			break;
		case "E":
			this.toEditScreen();
			break;
		default:
			this.quit();
			break;
		}

	}

	//к загрузке коллекции
	private void toLoadScreen() {
		try {

			System.out.println("Input absolute path with the file name");
			handler.load(scan.nextLine());
			System.out.println("Loaded successfully");
			this.showOptionScreen();

		} catch (Exception e) {
			System.out.println("Exception in loading file. Try './films.txt'");
			e.printStackTrace();
		}
	}

	//к сохранению коллекции
	private void toSaveScreen() {
		try {

			System.out.println("Input absolute path with the file name");
			handler.save(scan.nextLine());
			System.out.println("Saved successfully");

			if (!isQuitting) {
				this.showOptionScreen();
			}

		} catch (Exception e) {

			try {
				handler.save("./films.txt");
				System.out
						.println("Exception in program! Collection changers saved in project directory as 'films.txt'");
				e.printStackTrace();

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	//к добавлению фильма
	private void toAddFilmScreen() {

		System.out.println("Input title of the film you want to add");
		handler.addFilm(scan.nextLine());
		this.showOptionScreen();
	}

	//к удалению фильма
		private void toDeleteFilmScreen() {

			System.out.println("Input title of the film you want to delete");
			handler.delFilm(scan.nextLine());
			this.showOptionScreen();
		}

	//к редактированию фильма
	private void toEditScreen() {

		System.out.println("Input title of the film you want to edit");
		String thatFilm = scan.nextLine();
		System.out.println("Starring:");
		handler.showCredits(thatFilm);

		System.out.println("Press 'D' to Delete actor, A to add, Q for Quit");
		symbol = scan.nextLine().toUpperCase();

		while (!(symbol.equals("D") || symbol.equals("A") || symbol.equals("Q"))) {
			symbol = scan.nextLine().toUpperCase();
		}

		if (symbol.equals("D")) {
			this.DeleteActorScreen(thatFilm);
		} else if (symbol.equals("A")) {
			this.AddActorScreen(thatFilm);
		} else
			this.quit();
	}

	//к добавлению актера
		private void AddActorScreen(String thatFilm) {

			System.out.println("Input Name of Actor you want to add to the film credits");
			String actorName = scan.nextLine();

			handler.addActor(thatFilm, actorName);
			this.showOptionScreen();
		}
	
	//к удалению актера
	private void DeleteActorScreen(String thatFilm) {
		System.out.println("Input Name of Actor you want to delete from the film credits");
		String actorName = scan.nextLine();

		handler.remActor(thatFilm, actorName);
		this.showOptionScreen();
	}

	//процедура выхода через сохранение
	private void quit() {

		System.out.println("Save changes in the collection before quit? (Y/N)");
		symbol = scan.nextLine().toUpperCase();

		while (!(symbol.equals("Y") || symbol.equals("N"))) {
			symbol = scan.nextLine().toUpperCase();
		}

		if (symbol.equals("Y")) {
			this.isQuitting = true;
			this.toSaveScreen();
		}

	}

}

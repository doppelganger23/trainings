package by.epam.grodno.uladzimir_stsiatsko.java.se04_1_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmCollectionHandler {
	// коллекция, которую будем (де)сериализовать
	private Map<String, ArrayList<String>> films = new HashMap<String, ArrayList<String>>();

	// добавить фильм
	public void addFilm(String film) {
			if (films.containsKey(film)) {
				System.out.println("Film '" + film + "' is allready in the collection");
			} else {
				films.put(film, new ArrayList<String>());
				System.out.println("Film '" + film + "' was added to the collection");
			}
	}

	// удалить фильм
	public void delFilm(String film) {
			if (films.containsKey(film)) {
				films.remove(film);
				System.out.println("Film '" + film + "' was removed from the collection");
			} else {
				System.out.println("Film '" + film + "' not found in the collection");
			}
	}

	// добавить актера
	public void addActor(String film, String newActor) {
		if (films.containsKey(film)) {
			List<String> credits = films.get(film);
				if (credits.contains(newActor)) {
					System.out.println("Actor '" + newActor + "' is allready in the film credits");
				} else {
					credits.add(newActor);
					System.out.println("Actor '" + newActor + "' was added to the film credits");
				}

		} else {
			System.out.println("Film '" + film + "' not found in the collection");
		}
	}

	// удалить актера
	public void remActor(String film, String actor) {
		if (films.containsKey(film)) {
			List<String> credits = films.get(film);
				if (!credits.contains(actor)) {
					System.out.println("Actor '" + actor + "' wasn't in the film credits");
				} else {
					credits.remove(actor);
					System.out.println("Actor '" + actor + "' was removed from the film credits");
				}

		} else {
			System.out.println("Film '" + film + "' not found in the collection");
		}
	}

	// просмотреть коллекцию
	public void showCollection() {
		films.keySet().forEach(k -> System.out.println(k + "   ***Starring*** : " + films.get(k) ));
	}
	
	public void showCredits(String film){
		System.out.println(films.get(film));
	}

	// сериализовать коллекцию
	public void save(String nameWithDir) throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nameWithDir))) {
			out.writeObject(films);
		}
	}

	// десериализовать коллекцию
	@SuppressWarnings("unchecked")
	public void load(String pathToFile) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(pathToFile));) {
			this.films = (Map<String, ArrayList<String>>) in.readObject();
		}
	}

}

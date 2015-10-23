package by.epam.grodno.uladzimir_stsiatsko.java.se02_5;

public class Main {

	public static void main(String[] args) {
		
		//запуск ядра программы
		Application app = new Application();
		
		//создаем студентов внутри хэшмэпа
		app.makeNewStudent("Иванов");
		app.makeNewStudent("Петров");
		app.makeNewStudent("Сидоров");
		
		//создаем дисциплины (c индивидуальной системой оценок)
		Discipline<Integer> chem = new Discipline<Integer>("Химия");
		Discipline<Double> math = new Discipline<Double>("Математика");
		Discipline<Integer> psy = new Discipline<Integer>("Психология");
		
		//наполняем дисциплины студентами
		app.allocateStudents(chem, "Иванов", "Петров");
		app.allocateStudents(math, "Иванов", "Сидоров");
		app.allocateStudents(psy, "Петров", "Сидоров");
		
		//ставим оценки по дисциплинам
		chem.setGrade("Иванов", 8);
		chem.setGrade("Петров", 7);
		math.setGrade("Иванов", 9.3);
		math.setGrade("Сидоров", 7.4);
		psy.setGrade("Петров", 9);
		psy.setGrade("Сидоров", 8);
		
		//выводим информацию по студентам
		app.getStudentInfo("Иванов");
		app.getStudentInfo("Петров");
		app.getStudentInfo("Сидоров");
		
	}

}

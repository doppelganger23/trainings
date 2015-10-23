package by.epam.grodno.uladzimir_stsiatsko.java.se02_5;

import java.util.*;

public class Student {

	/** перечень изучаемых дисциплин */
	private List<Discipline<? extends Number>> disciplines = new ArrayList<Discipline<? extends Number>>();

	/** добавить дисциплину в перечень */
	public void addDiscipline(Discipline<? extends Number> d) {
		disciplines.add(d);
	}

	/** вывести на экран изучаемые дисциплины */
	public void getStatList() {
		for (Discipline<? extends Number> d : disciplines) {
			System.out.println(d.getName());
			// и сравнить оценки по ним
			System.out.println(d.getGrades());
		}
	}
	
}

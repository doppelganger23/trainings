package by.epam.grodno.uladzimir_stsiatsko.java.se02_5;

import java.util.*;

public class Discipline<T> {

	/** название дисциплины */
	private String disciplineName;
	
	/** перечень обучающихся студентов */
	private List<Student> students = new ArrayList<Student>();

	/** карта фамилий и оценок */
	private Map<String, T> grades = new HashMap<String, T>();
	
	/** конструктор с названием дисциплины */
	public Discipline(String dName) {
		this.disciplineName = dName;
	}
	
	/** геттер для названия дисциплины */
	public String getName() {
		return disciplineName;
	}
	
	/** добавить студента в перечень */
	public void addStudents(Student s) {
		students.add(s);
	}

	/** задать фамилию и оценку */
	public void setGrade(String lName, T grade) {
		// вводим данные в карту оценок пофамильно
		grades.put(lName, grade);
	}
	
	/** ссылка на карту фамилий и оценок */
	public Map<String, T> getGrades() {
		return grades;
	}

}

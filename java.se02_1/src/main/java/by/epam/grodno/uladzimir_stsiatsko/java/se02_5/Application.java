package by.epam.grodno.uladzimir_stsiatsko.java.se02_5;

import java.util.*;

public class Application {
	
	/**Карта, хранящая студентов по фамилиям*/
	private Map<String, Student> students = new HashMap<String, Student>();
	
	/**Добавить студента в перечень*/ //создавать не надо
	public void makeNewStudent(String lName){
		students.put(lName, new Student());
	}

	/**Записать студентов в группу по дисциплине*/ //обоюдное действие
	public void allocateStudents(Discipline<? extends Number> dis, String... lNames){
		//для каждой введенной фамилии
		for (String name : lNames){
			//получаем объект студента по имени
			Student s = students.get(name);
			//и прописываем дисциплину студенту
			s.addDiscipline(dis);
			//а студента - дисциплине
			dis.addStudents(s);
		}
	}
	
	/**Вывести все группы и оценки студента*/
	public void getStudentInfo(String lName){
		//шапка для красоты
		System.out.println("------Статистика--" + lName + "----------");
		//по фамилии вылавливаем студента из хэшмэпа
		Student s = students.get(lName);
		//запрашиваем у него необходимую информацию
		s.getStatList();
		//раделитель для красоты
		System.out.println("==================================");
	}
	
}

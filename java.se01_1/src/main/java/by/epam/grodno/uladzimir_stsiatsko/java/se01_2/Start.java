package by.epam.grodno.uladzimir_stsiatsko.java.se01_2;

public class Start {

	public static void main(String[] args) {
	
		/*создаем экземпляр калькулятора тангенсов
		*первый параметр - начало отрезка (а)
		*второй параметр - конец отрезка (b)
		*третий параметр - шаг аргумента
		*/
		Tangulator t = new Tangulator(1, 5, 0.5);
		
		//вызываем вычисляющую функцию объекта
		t.calculate();
				
	}

}

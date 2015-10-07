package by.epam.grodno.uladzimir_stsiatsko.java.se01_1;

public class First {

	public static void main(String[] args) {
		
		//создаем массив "а" из 6 нечетных чисел
		EvenArray a = new EvenArray(6);
		//выводим на экран
		a.printArray();
		//умножаем каждое второе число на предыдущее
		a.multiFor();
		//выводим измененный массив на экран
		a.printArray();
		
		//разделитель
		System.out.println();
		
		//то же с массивом b из 8 чисел, но с циклом while
		EvenArray b = new EvenArray(8);
		b.printArray();
		b.multiWhile();
		b.printArray();
		
		System.out.println();
				
		//массив с, цикл do while
		EvenArray c = new EvenArray(10);
		c.printArray();
		c.multiDoWhile();
		c.printArray();
		

	}

}

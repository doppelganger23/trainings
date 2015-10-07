package by.epam.grodno.uladzimir_stsiatsko.java.se01_2;

import java.math.BigDecimal;

//почитать о размерах значений Math.tan!!!!
public class Tangulator {
	
	//конструктор
	 public Tangulator(double a, double b, double h){
		 
		 //инициализация полей класса
		 this.a = a;
		 this.b = b;
		 this.h = h;
		 
	 }
	 
	 //начало диапазона значений аргумента
	 private double a;
	 //конец диапазона значений
	 private double b;
	 //шаг значений
	 private double h;
	 
	 //аргумент
	 private double x = a;
	 //функция
	 private double f;
	  
	 //вычисляющий и выводящий таблицу метод
	 public void calculate(){
		 
		//(предполагается, что идем от а к б и шаг не отрицательный)
		 while(x < b){
			
			//подсчитали значение функции
			f = Math.tan(2*x) - 3;
			
			//поместили в обертку для вывода с двумя знаками после запятой
			BigDecimal fx = new BigDecimal(f);
			fx = fx.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			//вывели строку-разделитель
			System.out.println("--------------------------");
			//вывели строку со значениями аргумента и функции
			System.out.println("| x = " + x + " | F(x) = " + fx + " |");
			
			//увеличили аргумент на значение шага
			x = x + h;
			
		}
		System.out.println("--------------------------");
	 }
}

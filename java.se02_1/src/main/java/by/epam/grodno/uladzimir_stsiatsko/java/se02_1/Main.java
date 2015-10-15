package by.epam.grodno.uladzimir_stsiatsko.java.se02_1;

public class Main {

	public static void main(String[] args) {
	
		Spec spec = new Spec();
		System.out.print(spec.getText());

		System.out.println();
		
		Pen pen = new Pen();
		pen.write("я новая ручка");//выключена
		pen.setOn();
		pen.write("Ой, забыл включить");
		pen.write("Мама");
		pen.write("мыла");
		pen.write("раму");//закончились чернила
		
		System.out.println();
		
		Pen redPen = new Pen("red");
		redPen.setOn();
		redPen.setOff();
		redPen.setOn();
		redPen.write("Проверка");//сломалась
		
		System.out.println();
		
		Pen greenPen = new Pen("green");
		pen.refill("green");
		System.out.println(greenPen == pen);
		System.out.println(greenPen.equals(pen));
		
		Pen goodPen = new Pen ("red", 100);
		System.out.println(redPen.equals(goodPen));
				
	}

}

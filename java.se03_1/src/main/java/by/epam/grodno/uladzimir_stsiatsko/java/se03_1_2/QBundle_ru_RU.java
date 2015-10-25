package by.epam.grodno.uladzimir_stsiatsko.java.se03_1_2;

import java.util.ListResourceBundle;

public class QBundle_ru_RU extends ListResourceBundle {

	private Object[][] contents = {
	        { "1", "Есть ли жизнь на марсе?" },
	        { "2", "Сколько будет 2х2?" },
	        { "3", "Кто подставил кролика Роджера?"},
	    };
	
	public Object[][] getContents(){
		return contents;
	}
}

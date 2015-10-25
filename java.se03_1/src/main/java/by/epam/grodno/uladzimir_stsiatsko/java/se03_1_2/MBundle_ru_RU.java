package by.epam.grodno.uladzimir_stsiatsko.java.se03_1_2;

import java.util.ListResourceBundle;

public class MBundle_ru_RU extends ListResourceBundle {

	private Object[][] contents = {
	        { "QHeader", "Введите номер вопроса, чтобы увидеть ответ. Нажмите Q, чтобы выйти" },
	        { "AHeader", "Ответ:" },
	        { "Return", "Нажмите R для возврата к списку вопросов, Q чтобы выйти" },
	        { "Quit", "Пока!" },
	    };
	
	public Object[][] getContents(){
		return contents;
	}
}
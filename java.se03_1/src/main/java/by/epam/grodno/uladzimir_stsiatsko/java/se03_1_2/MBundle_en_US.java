package by.epam.grodno.uladzimir_stsiatsko.java.se03_1_2;

import java.util.ListResourceBundle;

public class MBundle_en_US extends ListResourceBundle {

	private Object[][] contents = {
	        { "QHeader", "Input number to get answer, press Q for quit" },
	        { "AHeader", "The answer is:"},
	        { "Return", "Press R to return to question list, Q for quit" },
	        { "Quit", "Goodbye!" },
	    };
	
	public Object[][] getContents(){
		return contents;
	}
}
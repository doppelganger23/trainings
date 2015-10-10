package by.epam.grodno.uladzimir_stsiatsko.java.se01_6;

/** Main class for the Notebook program.
 * On current development stage it simulates notebook interface and process of work with project.
 * 
 * @author Uladzimir Stsiatsko
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
	
		/** Creating new notebook object*/
		Notebook toDoList = new Notebook();
		
		/** Adding a records into it */
		toDoList.addRecord("начать бегать по утрам");
		toDoList.addRecord("начать учить Java");
		toDoList.addRecord("не забывать об отдыхе");
		
		/** Removing a record */
		toDoList.remRecord(1);
		
		/** Editing chosen record */
		toDoList.editRecord(0, "начать просыпаться по утрам");
		
		/** Reading all records */
		toDoList.readAll();
	
	}

}

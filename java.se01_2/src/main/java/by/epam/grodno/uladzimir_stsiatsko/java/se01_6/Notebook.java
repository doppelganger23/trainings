package by.epam.grodno.uladzimir_stsiatsko.java.se01_6;

/**Simple Notebook (has no interface yet, works through Main class commands).
 * Capacity - 100 pages.
 * 
 * @author Uladzimir Stsiatsko
 * @version 1.0
 */
public class Notebook {

	/** Field that contains notebook data*/
	private Record[] nb = new Record[100];
	
	/** Records identifier field*/
	private int num = 0;
	
	/** Create a record (record text) */
	public void addRecord(String text){
	
		//создаем объект записи в массиве записей
		nb[num] = new Record(text);
		
		//увеличиваем идентификатор позиции, если она не последняя
		if(num < 99)
		num++;
		else
		System.out.println("Странички закончились, для корректной работы может потребоваться перезапуск программы!");
		
	}
	
	/** Delete record (record number) */
	public void remRecord(int num){
		
		//обнуляем ссылку на запись
		nb[num] = null;
		
	}
	
	/** Edit record. Previous text will be lost!  */
	public void editRecord(int num, String text){
		
		//делегируем выполнение сеттеру соответствующей записи
		nb[num].setText(text);
		
				
	}
	
	/** Show all records */
	public void readAll(){
		
		for(int i = 0; i < 100; i++){
			
			//проверка во избежание NullPointerException
			if(nb[i] instanceof Record)
			System.out.println(i + ". " + nb[i].getText());
			
		}
		
	}
	
}

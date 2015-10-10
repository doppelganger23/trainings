package by.epam.grodno.uladzimir_stsiatsko.java.se01_6;

/** Class for the records used in the notebook class.
 * 
 * @author Uladzimir Stsiatsko
 * @version 1.0
 */
public class Record {
	
	/** This field contains record text*/
	private String text;
	
	/** Constructor */
	public Record(String text){
		
		//сохраняем запись из параметра в поле
		this.text = text;
		
	}
	
	/** Getter */
	public String getText(){
		
		return text;
	
	}
	
	/** Setter */
	public void setText(String nText){
	
		text = nText;
		
	}
	
	
}

package by.epam.grodno.uladzimir_stsiatsko.java.se01_5;

//квадратная матрица
public class XMatrix {

	//поле, хранящее матрицу
	private int[][] m;
	
	//конструктор с аргументом
	public XMatrix(int v){
		
		m = new int[v][v];
		
	}
	
	//конструктор по умолчанию
	public XMatrix(){
		
		m = new int[7][7];
		
	}
		
	//заполнить матрицу единицами и вывести на экран
	public void getMatrix(){
		
		//для каждой строки
		for(int i = 0; i < m.length; i++){
			
			//и каждого столбца этой строки
			for(int j = 0; j < m[i].length; j++){
				
				//проверяем, не достигнута ли нужная позиция
				if(i == j || i + j == m.length - 1){
				
					//и если достигнута, заполняем элемент единицей
					m[i][j] = 1;
					
				}
				
				//в любом случае выводим элемет
				System.out.print(m[i][j] + " ");
				
			}
			
			//перенос строки
			System.out.println();
		}
		
		
	}
}

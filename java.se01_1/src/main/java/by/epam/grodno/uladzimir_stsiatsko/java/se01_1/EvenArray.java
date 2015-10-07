package by.epam.grodno.uladzimir_stsiatsko.java.se01_1;

//нечетный массив с функциями создания, вывода на экран и умножения каждого второго числа на предыдущее
public class EvenArray {
	
	//конструктор массива (v -размер)
	public EvenArray(int v){
	
		a = new int[v];
		
		for(int i = 0; i < v; i++){
			
		//генерируем целые четные в диапазоне (0;20)
			a[i] = 2*((int) Math.round(Math.random()*10));
				
		}
		
	}
	
	//поле, хранящее состояние массива
	private int[] a;

	//вывод массива на экран
	public void printArray(){
			
		for(int i = 0; i < a.length; i++){
				
			System.out.print(a[i] + " ");
		}
	
		//разделитель между 2 выводами
		System.out.println();
	}
		
	//умножаем каждое второе число на предыдущее
	public void multiFor(){
			
		for(int i = 0; i < a.length; i++){
				
			//проверка на нечетность индекса 
			if((i % 2) == 1){
					
				a[i] = a[i]*a[i-1];
					
			}
				
		}
			
	}
		
	//то же с циклом while
	public void multiWhile(){
			
		int i = 0;
		while(i < a.length){
				
			if((i % 2) == 1){
					
				a[i] = a[i]*a[i-1];
					
			}
				
			i++;
				
		}
			
	}
		
	//и с do while
	public void multiDoWhile(){
			
		int i = 0;
		do{
				
			if((i % 2) == 1){
					
				a[i] = a[i]*a[i-1];
					
			}
				
			i++;
				
		} while (i < a.length);
			
	}
		
}

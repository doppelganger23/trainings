package by.epam.grodno.uladzimir_stsiatsko.java.se02_1;

public class Rod {

	// объем чернил в стержне
	private int ink = 3;

	// цвет чернил (только для сравнения)
	private String color = "blue";

	// конструктор по умолчанию
	public Rod() {

	}

	// конструктор с цветом
	public Rod(String color) {
		this.color = color;
	}

	//геттер для чернил
	public int getInk(){
		return ink;
	}
	
	//вызываем при письме
	public void looseInk() {
		ink--;
	}

	
	//переопределяем хэшкод и иквалс по цвету
	//(стандартной генерацией эклипса)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Rod)) {
			return false;
		}
		Rod other = (Rod) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		return true;
	}

	
}

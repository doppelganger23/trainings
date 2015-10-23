package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

import java.util.List;

//РАЗОБРАТЬСЯ В СТРАННОЙ НУМЕРАЦИИ ОБЪЕКТОВ
public class Main {
	public static void main(String[] args) {
		System.out.println("------------------------------\n\n Д/З №3:");
		//тестируем элементы иерархии в работе:
		
		//бумага и пачка бумаг
		PaperPack pack = new PaperPack();
		Paper paper1 = pack.getPaper();
		Paper paper2 = pack.getPaper();
		Paper paper3 = pack.getPaper();
		Paper paper4 = pack.getPaper();
		paper2.write("я надпись на бумаге");
		System.out.println(paper2.getText());
		
		pack.countPapers();
		
		//корректор
		new Corrector().correct(paper2);
		System.out.println(paper2.getText());
		
		//скрепляющий интерфейс (скрепка)
		Fixative fixator = new PaperClip();
		List<Paper> list = fixator.staple(paper1, paper2);
		System.out.println("скреплено: " + list.toString());
		
		//пробуем скрепить другие листы той же скрепкой
		fixator.staple(paper3, paper4);
		//а теперь степлер
		Fixative fixator2 = new Stepler();
		fixator2.staple(pack.getPaper(), pack.getPaper());
		fixator2.staple(pack.getPaper(), pack.getPaper());//степлер не скрепка
		
		//стикеры
		Sticker s = new Sticker(); 
		s.write("я наклейка");
		pack.addSticker(s);
		Sticker s2 = new Sticker();
		s2.write("я тоже");
		pack.addSticker(s2);
		
		pack.readStickedMessages();
		
		System.out.println("------------------------------\n\n Д/З №2:");	
		//подсчет стоимости
		
		Workspace my = new Workspace();
		my.add(pack, new Corrector(), new Stepler(), s, s2);
		System.out.println("В наборе содержатся:\n" + my.getAccList());
		System.out.println("Итого: $ " + my.getSumm());
		
		System.out.println("------------------------------\n\n Д/З №4:");
		//сортировка тремя разными компараторами
		
		my.sortByName();
		System.out.println(my.getAccList());
		my.sortByPrice();
		System.out.println(my.getAccList());
		my.sortByBoth();
		System.out.println(my.getAccList());
		
	}

}

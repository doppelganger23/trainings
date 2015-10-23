package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

import java.util.ArrayList;
import java.util.List;

public class PaperClip extends OfficeAcc implements Fixative {

	// пачка бумаг, на которой висит данная скрепка
	private List<Paper> papersPile;

	/** Return list of chosen papers */
	public List<Paper> staple(Paper... papers) {
		// если скрепка не используется
		if (papersPile == null) {
			// инициализируем лист ArrayList-ом
			papersPile = new ArrayList<Paper>();
			// добавляем каждый параметр в лист
			for (Paper p : papers) {
				papersPile.add(p);
			}
			// возвращаем лист
			return papersPile;
		} else {
			// создаем новую скрепку
			System.out.println("This paperclip is allredy in use; new paperclip is generated");
			PaperClip newClip = new PaperClip();
			/*
			 * Рекурсивно вызываем в ней тот же метод, т.к. там papersPile точно
			 * null, и возвращаем результат его работы.
			 */
			return newClip.staple(papers);
		}
	}

	/** Free paper clip from papers to use again */
	public void unStaple() {
		papersPile = null;
	}

	/** Check is paper clip free for use */
	public boolean isFree() {
		if (papersPile == null)
			return true;
		else
			return false;
	}

}

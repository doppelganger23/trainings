package by.epam.grodno.uladzimir_stsiatsko.java.se04_1_1to3;

/**
 * Вспомогательный класс для задач 4_1 и 4_2.
 * Содержит перечень ключевых слов Java и проверяет другие слова на соответствие им.
 * */
public class Keywords {

	public static final String[] keywords = { "abstract", "assert", "boolean", "break", "byte", "case", "сatch", "char",
			"class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally",
			"float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
			"new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
			"switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while" };

	// проверить на соответствие списку ключевых слов
	public static boolean contains(String word) {

		for (String s : keywords) {
			if (s.equals(word)) {
				return true;
			}
		}
		return false;
	}

}

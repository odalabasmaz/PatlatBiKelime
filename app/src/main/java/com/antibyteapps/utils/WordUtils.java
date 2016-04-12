package com.antibyteapps.utils;

import com.antibyteapps.dictionary.common.DictionaryConstants;

/**
 * @author Orhun Dalabasmaz
 */
public class WordUtils {
	/* Frequencies
	* {a:61654}{b:12195}{c:6797}{ç:6417}{d:11287}{e:50005}{f:4134}
	* {g:5500}{ğ:2569}{h:5291}{ı:23453}{i:38141}{j:801}{k:38464}{l:45000}
	* {m:33664}{n:21701}{o:10785}{ö:3240}{p:5975}{r:28416}
	* {s:16870}{ş:12300}{t:24169}{u:12646}{ü:9848}{v:5599}{y:10921}{z:10250}
	* */

	public static String format(String word) {
		word = word.toLowerCase(DictionaryConstants.LOCALE_TR);
		word = word.replaceAll("â", "a");
		word = word.replaceAll("î", "i");
		word = word.replaceAll("û", "u");
		word = word.replaceAll("̇", "");
		return word;
	}

	public static boolean isRegularWord(String word) {
		if (word.contains("-")) return false;
		return true;
	}
}

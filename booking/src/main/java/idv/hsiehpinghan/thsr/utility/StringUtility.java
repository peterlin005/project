package idv.hsiehpinghan.thsr.utility;

import java.util.ArrayList;

public class StringUtility {
	/**
	 * 將string中的字元轉換為字元字串ArrayList。
	 * @param string 欲轉換成字元字串ArrayList。
	 * @return 字元字串ArrayList。
	 */
	public static ArrayList<String> getCharacterStringArray(String string) {
		ArrayList<String> arrayList = new ArrayList<String>();
		for(int i = 0, endPosition = string.length(); i < endPosition; ++i) {
			String characterString = String.valueOf(string.charAt(i));
			arrayList.add(characterString);
		}
		return arrayList;
	}
}

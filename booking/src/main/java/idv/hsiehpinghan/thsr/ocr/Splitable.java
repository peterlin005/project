package idv.hsiehpinghan.thsr.ocr;

import java.util.ArrayList;

/**
 * 可切割成子物件的類別。
 * @author 謝秉翰
 *
 * @param <T> 切割後的子物件類別。
 */
public interface Splitable<T> {
	/**
	 * 將本物件切割成子物件。
	 * @return 子物件的ArrayList<T>。
	 */
	public ArrayList<T> splitToArrayList();
}

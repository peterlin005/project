package idv.hsiehpinghan.thsr.utility;

import java.io.IOException;

public class ConsoleUtility {
	/**
	 * 請使用者由console輸入字串，移除空白字元後回傳。
	 * @param message
	 * @return
	 * 回傳目錄的String物件：
	 * <ol>
	 * <li>成功讀取使用者輸入字串。
	 * </ol>
	 * 回傳null：
	 * <ol>
	 * <li>讀取使用者輸入字串失敗。
	 * </ol>
	 */
	public static String getConsoleInput(String message) {
		System.out.print(message + " (lenth < 32) : ");
		byte[] inputBytes = new byte[32];
		try {
			System.in.read(inputBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		String inputString = new String(inputBytes);
		return inputString.trim();
	}
}

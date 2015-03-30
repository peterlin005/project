package idv.hsiehpinghan.thsr.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtility {
	/**
	 * 關閉OutputStream物件，且不丟出Exception。
	 * @param outputStream 卻關閉的OutputStream物件。
	 */
	public static void closeOutputStream(OutputStream outputStream) {
		if(outputStream == null) {
			return;
		}
		
		try {
			outputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 關閉InputStream物件，且不丟出Exception。
	 * @param InputStream 卻關閉的InputStream物件。
	 */
	public static void closeInputStream(InputStream inputStream) {
		if(inputStream == null) {
			return;
		}
		
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

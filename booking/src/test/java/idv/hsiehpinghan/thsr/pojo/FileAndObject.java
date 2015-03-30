package idv.hsiehpinghan.thsr.pojo;

import java.io.File;

public class FileAndObject {
	private File file = null;
	private Object object = null;
	
	public FileAndObject(File file, Object object) {
		this.file = file;
		this.object = object;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	@Override
	public String toString() {
		return "file = " + file + "; object = " + object;
	}
}

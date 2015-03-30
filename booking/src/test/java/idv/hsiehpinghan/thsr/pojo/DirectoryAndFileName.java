package idv.hsiehpinghan.thsr.pojo;

public class DirectoryAndFileName {
	private String directoryPath = null;
	private String fileName = null;
	
	public DirectoryAndFileName(String directoryPath, String fileName) {
		this.directoryPath = directoryPath;
		this.fileName = fileName;
	}
	public String getDirectoryPath() {
		return directoryPath;
	}
	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return "directoryPath = " + directoryPath + "; fileName = " + fileName;
	}
}

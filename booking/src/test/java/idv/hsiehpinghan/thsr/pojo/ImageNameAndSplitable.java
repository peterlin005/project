package idv.hsiehpinghan.thsr.pojo;

import idv.hsiehpinghan.thsr.ocr.Splitable;

public class ImageNameAndSplitable<T> {
	String imageName;
	Splitable<T> splitable;
	
	public ImageNameAndSplitable(String imageName, Splitable<T> splitable) {
		this.imageName = imageName;
		this.splitable = splitable;	
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Splitable<T> getSplitable() {
		return splitable;
	}
	public void setSplitable(Splitable<T> splitable) {
		this.splitable = splitable;
	}
	
	@Override
	public String toString() {
		return "imageName = " + imageName + "; splitable = " + splitable;
	}
}

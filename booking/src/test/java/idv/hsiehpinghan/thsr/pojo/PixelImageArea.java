package idv.hsiehpinghan.thsr.pojo;

public class PixelImageArea {
	int startColumn;
	int startRow;
	int width;
	int height;
	boolean isAllElementsZero;
	
	public PixelImageArea(int startColumn, int startRow, int width, int height) {
		this.startColumn = startColumn;
		this.startRow = startRow;
		this.width = width;
		this.height = height;
	}
	public int getStartColumn() {
		return startColumn;
	}
	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}

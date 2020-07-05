package com.binvi.springboot.demo03.model;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/12/24 21:59
 */
public class NoteBook {

	private double numberOfSheets;
	private String description;

	public NoteBook() {}

	public NoteBook(double numberOfSheets, String description) {
		super();
		this.numberOfSheets = numberOfSheets;
		this.description = description;
	}

	public double getNumberOfSheets() {
		return numberOfSheets;
	}
	public String getDescription() {
		return description;
	}

	public void setNumberOfSheets(double numberOfSheets) {
		this.numberOfSheets = numberOfSheets;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
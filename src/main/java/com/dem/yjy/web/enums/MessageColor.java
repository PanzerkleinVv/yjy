package com.dem.yjy.web.enums;

public enum MessageColor {
	SUCCESS("#00FF00"), FAILURE("#FF0000");
	private String color;

	private MessageColor(String color) {
        this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}

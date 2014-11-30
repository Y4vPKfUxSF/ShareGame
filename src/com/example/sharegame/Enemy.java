package com.example.sharegame;

import android.graphics.Bitmap;

public class Enemy{
	Bitmap eCharImage; 
	int charX, charY, color;
	
	//
	public Enemy(Bitmap eCharImage, int charX, int charY, int color) {
		this.eCharImage = eCharImage;
		this.charX = charX;
		this.charY = charY;
		this.color = color;
	}

	/**
	 * @return the eCharImage
	 */
	public Bitmap geteCharImage() {
		return eCharImage;
	}

	/**
	 * @param eCharImage the eCharImage to set
	 */
	public void seteCharImage(Bitmap eCharImage) {
		this.eCharImage = eCharImage;
	}

	/**
	 * @return the charX
	 */
	public int getCharX() {
		return charX;
	}

	/**
	 * @param charX the charX to set
	 */
	public void setCharX(int charX) {
		this.charX = charX;
	}

	/**
	 * @return the charY
	 */
	public int getCharY() {
		return charY;
	}

	/**
	 * @param charY the charY to set
	 */
	public void setCharY(int charY) {
		this.charY = charY;
	}

	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Enemy [eCharImage=" + eCharImage + ", charX=" + charX
				+ ", charY=" + charY + ", color=" + color + "]";
	}
}